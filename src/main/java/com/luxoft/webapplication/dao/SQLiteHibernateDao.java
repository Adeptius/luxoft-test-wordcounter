package com.luxoft.webapplication.dao;


import com.luxoft.webapplication.model.LineStatistic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class SQLiteHibernateDao implements StatisticDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void insert(LineStatistic statistic) {
        Session session = sessionFactory.getCurrentSession();
        session.save(statistic);
    }

    @Override
    @Transactional
    public List<LineStatistic> getAllStatistic() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select l from LineStatistic l").list();
    }

    @Override
    @Transactional
    public void delete(LineStatistic statistic) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(statistic);
    }

    @Override
    @Transactional
    public void deleteAll() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete  from LineStatistic").executeUpdate();;
    }


}
