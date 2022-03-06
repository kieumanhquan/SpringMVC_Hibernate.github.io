package repository;

import entity.Line;
import util.DataUtil;
import util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class LineDaoImpl implements LineDao{

    @Override
    public void add(Line line) {
        if (DataUtil.isEmptyOrNull(line)) {
            return;
        }
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(line);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            assert session != null;
            session.getTransaction().rollback();
        }
    }
    @Override
    public List<Line> getAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            return (List<Line>) session.createQuery("from Line ").list();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Line line) {
        if (DataUtil.isEmptyOrNull(line)) {
            return;
        }
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(line);
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
            Line line = session.load(Line.class, id);
            session.delete(line);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public Line findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Line line=null;
        try {
            session.beginTransaction();
            line = session.load(Line.class, id);
            session.getTransaction().commit();
            return line;
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return line;
    }
}
