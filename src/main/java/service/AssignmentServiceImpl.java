package service;

import dto.AssigmentTableDto;
import dto.AssignmentTable;
import dto.LineTurn;
import entity.Assignment;
import entity.Driver;
import repository.AssigmnetDaoImpl;
import repository.AssignmentDao;
import util.CollectionUtil;
import util.DataUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentDao assignmentDao = new AssigmnetDaoImpl();

    @Override
    public List<Assignment> getAll() {
        return assignmentDao.getAll();
    }

    @Override
    public String add(Assignment assignment) {
        List<Assignment> exitsAssignmentList = assignmentDao.findByDriverId(assignment.getDriver().getId());

        if (CollectionUtil.isNullOrEmpty(exitsAssignmentList)) {
            // Thêm mới
            if (assignment.getTurnNumber() <= 15) {
                assignmentDao.add(assignment);
                return "success";
            } else {
                return "over-15-turn";
            }
        } else {
            // update bảng phân công đã có trong hệ thống
            Assignment exitsAssignment = assignmentDao.findById(assignment.getDriver().getId(), assignment.getLine().getId());
            if (DataUtil.isEmptyOrNull(exitsAssignment)) {
                int turnSumCurrent = exitsAssignmentList.stream().mapToInt(Assignment::getTurnNumber).sum();
                if (turnSumCurrent + assignment.getTurnNumber() <= 15) {
                    assignmentDao.add(assignment);
                    return "success";
                } else {
                    return "over-15-turn";
                }
            } else {
                int turnSumCurrent = exitsAssignmentList.stream().mapToInt(Assignment::getTurnNumber).sum() - exitsAssignment.getTurnNumber();
                if (turnSumCurrent + assignment.getTurnNumber() <= 15) {
                    assignmentDao.update(assignment);
                    return "override-assignment-exits";
                } else {
                    return "over-15-turn";
                }
            }
        }
    }

    @Override
    public String update(Assignment assignment) {
        List<Assignment> exitsAssignmentList = assignmentDao.findByDriverId(assignment.getDriver().getId());
        Assignment exitsAssignment = assignmentDao.findById(assignment.getDriver().getId(), assignment.getLine().getId());
        int turnSumCurrent = exitsAssignmentList.stream().mapToInt(Assignment::getTurnNumber).sum() - exitsAssignment.getTurnNumber();
        if (turnSumCurrent + assignment.getTurnNumber() <= 15) {
            assignmentDao.update(assignment);
            return "override-assignment-exits";
        } else {
            return "over-15-turn";
        }
    }

    @Override
    public void delete(int driverId, int lineId) {
        assignmentDao.delete(driverId, lineId);
    }

    @Override
    public Assignment findById(int driverId, int lineId) {
        return assignmentDao.findById(driverId, lineId);
    }

    @Override
    public List<Assignment> findByDriverName(String driverName) {
        return assignmentDao.findByDriverName(driverName);
    }

    @Override
    public List<Assignment> sortByNameDriver() {
        List<Assignment> assignmentList = assignmentDao.getAll();

        assignmentList.sort((o1, o2) -> {
            String[] ten1 = o1.getDriver().getFullName().split("\\s+");
            String[] ten2 = o2.getDriver().getFullName().split("\\s+");
            if (ten1[ten1.length - 1].equalsIgnoreCase(ten2[ten2.length - 1])) {
                return o1.getDriver().getFullName().compareToIgnoreCase(o2.getDriver().getFullName());
            } else {
                return ten1[ten1.length - 1].compareToIgnoreCase(ten2[ten2.length - 1]);
            }
        });
        return assignmentList;
    }

    @Override
    public List<Assignment> sortByTurnNumber() {
        List<Assignment> assignmentList = assignmentDao.getAll();
        assignmentList.sort((o1, o2) -> o2.getTurnNumber() - o1.getTurnNumber());
        return assignmentList;
    }


    public List<AssignmentTable> getAssigmentTable() {
        List<Assignment> assignmentList = assignmentDao.getAll();
        List<AssignmentTable> assignmentTableList = new ArrayList<>();
        for (Assignment assignment : assignmentList) {
            boolean checkExits = false;
            for (AssignmentTable assignmentTable : assignmentTableList) {
                if (assignmentTable.getDriver().getId() == assignment.getDriver().getId()) {
                    assignmentTable.getLineTurns().add(new LineTurn(assignment.getLine(), assignment.getTurnNumber()));
                    checkExits = true;
                    break;
                }
            }
            if (!checkExits) {
                List<LineTurn> lineTurns = new ArrayList<>();
                lineTurns.add(new LineTurn(assignment.getLine(), assignment.getTurnNumber()));
                assignmentTableList.add(new AssignmentTable(assignment.getDriver(), lineTurns));
            }
        }
        return assignmentTableList;
    }

    @Override
    public List<AssigmentTableDto> distanceStatistics() {
        List<AssignmentTable> assignmentTableList = getAssigmentTable();
        List<AssigmentTableDto> assigmentTableDtoList = new ArrayList<>();
        for (AssignmentTable assignmentTable : assignmentTableList) {
            assigmentTableDtoList.add(new AssigmentTableDto(assignmentTable.getDriver(), assignmentTable.getLineTurns().stream().mapToDouble(LineTurn::getDistance).sum()));
        }
        return assigmentTableDtoList;
    }
}