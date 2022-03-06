package repository;

import entity.Line;

import java.util.List;

public interface LineDao {

    void add(Line line);

    Line findById(int id);

    List<Line> getAll();

    boolean delete(int id);

    void update(Line line);
}
