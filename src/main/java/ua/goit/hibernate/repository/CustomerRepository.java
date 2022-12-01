package ua.goit.hibernate.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.hibernate.model.dao.CustomerDao;
import ua.goit.hibernate.config.HibernateProvider;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements Repository<CustomerDao> {
    private final HibernateProvider connector;

    public CustomerRepository(HibernateProvider connector) {
        this.connector = connector;
    }

    @Override
    public CustomerDao save(CustomerDao entity) {
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public CustomerDao update(CustomerDao entity) {
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public void delete(CustomerDao entity) {
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CustomerDao findById(Integer id) {
        CustomerDao customersDao = new CustomerDao();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            customersDao = session.load(CustomerDao.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customersDao;
    }

    @Override
    public List<CustomerDao> findAll() {
        List<CustomerDao> daoList = new ArrayList<>();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            daoList = loadAllData(session);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daoList;
    }

    private static List<CustomerDao> loadAllData(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CustomerDao> criteria = builder.createQuery(CustomerDao.class);
        criteria.from(CustomerDao.class);
        return session.createQuery(criteria).getResultList();
    }
}
