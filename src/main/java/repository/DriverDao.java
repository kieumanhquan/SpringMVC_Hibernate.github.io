package repository;

import entity.Driver;

import java.util.List;

public interface DriverDao {

    void add(Driver driver);

    Driver findById(int id);

    List<Driver> getAll();

    boolean delete(int id);

    void update(Driver driver);

}
