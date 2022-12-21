package ua.goit.hibernate.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.hibernate.model.dao.DeveloperDao;
import ua.goit.hibernate.config.HibernateProvider;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepository implements Repository<DeveloperDao> {
    private final HibernateProvider connector;

    public DeveloperRepository(HibernateProvider connector) {
        this.connector = connector;
    }

    @Override
    public DeveloperDao save(DeveloperDao entity) {
        try (Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public DeveloperDao update(DeveloperDao entity) {
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        }
        return entity;
    }

    @Override
    public void delete(DeveloperDao entity) {
        try (Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DeveloperDao findById(Integer id) {
        DeveloperDao developersDao = new DeveloperDao();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            developersDao = session.load(DeveloperDao.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return developersDao;
    }

    @Override
    public List<DeveloperDao> findAll() {
        List<DeveloperDao> daoList = new ArrayList<>();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            daoList = loadAllData(session);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daoList;
    }

    private static List<DeveloperDao> loadAllData(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<DeveloperDao> criteria = builder.createQuery(DeveloperDao.class);
        criteria.from(DeveloperDao.class);
        return session.createQuery(criteria).getResultList();
    }
}
