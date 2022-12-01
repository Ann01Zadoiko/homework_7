package ua.goit.hibernate.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.hibernate.model.dao.SkillDao;
import ua.goit.hibernate.config.HibernateProvider;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class SkillRepository implements Repository<SkillDao> {
    private final HibernateProvider connector;

    public SkillRepository(HibernateProvider connector) {
        this.connector = connector;
    }

    @Override
    public SkillDao save(SkillDao entity) {
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
    public SkillDao update(SkillDao entity) {
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
    public void delete(SkillDao entity) {
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public SkillDao findById(Integer id) {
        SkillDao skillsDao = new SkillDao();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            skillsDao = session.load(SkillDao.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return skillsDao;
    }

    @Override
    public List<SkillDao> findAll() {
        List<SkillDao> daoList = new ArrayList<>();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            daoList = loadAllData(session);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daoList;

    }

    private static List<SkillDao> loadAllData(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SkillDao> criteria = builder.createQuery(SkillDao.class);
        criteria.from(SkillDao.class);
        return session.createQuery(criteria).getResultList();
    }
}
