package service;

import entity.Line;
import repository.LineDao;
import repository.LineDaoImpl;

import java.util.List;

public class LineServiceImpl implements LineService{
    LineDao lineDao = new LineDaoImpl();

    @Override
    public void add(Line line) {
        lineDao.add(line);
    }

    @Override
    public Line findById(int id) {
        return lineDao.findById(id);
    }

    @Override
    public List<Line> getAll(){
        return lineDao.getAll();
    }

    @Override
    public void delete(int id){
        lineDao.delete(id);
    }

    @Override
    public void update(Line line){
        lineDao.update(line);
    }
}