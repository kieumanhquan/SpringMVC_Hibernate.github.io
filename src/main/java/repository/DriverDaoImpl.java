package repository;

import entity.Driver;
import util.DataUtil;
import util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class DriverDaoImpl implements DriverDao {

    @Override
    public void add(Driver driver) {
        if (DataUtil.isEmptyOrNull(driver)) {
            return;
        }
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(driver);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            assert session != null;
            session.getTransaction().rollback();
        }
    }

    @Override
    public List<Driver> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            return (List<Driver>) session.createQuery("from Driver").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Driver driver) {
        if (DataUtil.isEmptyOrNull(driver)) {
            return;
        }
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(driver);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            assert session != null;
            session.getTransaction().rollback();
        }
    }

    @Override
    public boolean delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Driver driver = session.load(Driver.class, id);
            session.delete(driver);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public Driver findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Driver driver=null;
        try {
            session.beginTransaction();
            driver = session.load(Driver.class, id);
            session.getTransaction().commit();
            return driver;
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return driver;
    }
}