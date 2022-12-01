package ua.goit.hibernate.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.hibernate.model.dao.CompanyDao;
import ua.goit.hibernate.config.HibernateProvider;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepository implements Repository<CompanyDao> {
    HibernateProvider connector;

    public CompanyRepository(HibernateProvider connector) {
        this.connector = connector;
    }

    @Override
    public CompanyDao save(CompanyDao entity) {
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
    public CompanyDao update(CompanyDao entity) {
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
    public void delete(CompanyDao entity) {
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CompanyDao findById(Integer id) {
        CompanyDao companiesDao = new CompanyDao();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            companiesDao = session.load(CompanyDao.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companiesDao;
    }

    @Override
    public List<CompanyDao> findAll() {
        List<CompanyDao> daoList = new ArrayList<>();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            daoList = loadAllData(session);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daoList;
    }

    private static List<CompanyDao> loadAllData(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CompanyDao> criteria = builder.createQuery(CompanyDao.class);
        criteria.from(CompanyDao.class);
        return session.createQuery(criteria).getResultList();
    }
}
