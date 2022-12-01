package ua.goit.hibernate.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.hibernate.model.dao.ProjectDao;
import ua.goit.hibernate.config.HibernateProvider;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository implements Repository<ProjectDao> {
    private final HibernateProvider connector;

    public ProjectRepository(HibernateProvider connector) {
        this.connector = connector;
    }

    @Override
    public ProjectDao save(ProjectDao entity) {
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
    public ProjectDao update(ProjectDao entity) {
        try (Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public void delete(ProjectDao entity) {
        try (Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProjectDao findById(Integer id) {
        ProjectDao projectsDao = new ProjectDao();
        try (Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            projectsDao = session.load(ProjectDao.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectsDao;
    }

    @Override
    public List<ProjectDao> findAll() {
        List<ProjectDao> daoList = new ArrayList<>();
        try (Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            daoList = loadAllData(session);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daoList;
    }

    private static List<ProjectDao> loadAllData(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ProjectDao> criteria = builder.createQuery(ProjectDao.class);
        criteria.from(ProjectDao.class);
        return session.createQuery(criteria).getResultList();
    }
}
