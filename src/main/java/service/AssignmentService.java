package service;

import dto.AssigmentTableDto;
import entity.Assignment;

import java.util.List;

public interface AssignmentService {

    List<Assignment> getAll();

    String add(Assignment assignment);

    String update(Assignment assignment);

    void delete(int driverId, int lineId);

    Assignment findById(int driverId, int lineId);

    List<Assignment> findByDriverName(String driverName);

    List<Assignment> sortByNameDriver();

    List<Assignment> sortByTurnNumber();

    List<AssigmentTableDto> distanceStatistics();
}
