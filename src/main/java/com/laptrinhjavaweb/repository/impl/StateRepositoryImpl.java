package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.entity.Country;
import com.laptrinhjavaweb.entity.State;
import com.laptrinhjavaweb.entity.StateEntity;
import com.laptrinhjavaweb.repository.StateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.transform.*;

import java.util.List;

@Repository("stateRepository")
public class StateRepositoryImpl implements StateRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<State> findByCountry(Integer countryId) {
        List<State> stateEntities = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            stateEntities = session.createQuery("SELECT s.id as id,"
                    +"s.`name` as name "
                    +"FROM State s"
                    + "WHERE countryId = :countryId")
                    .setInteger("countryId", countryId)
                    .setResultTransformer(
                            Transformers.aliasToBean(
                                    StateEntity.class)
                    )
                    .list();
            System.out.println(stateEntities);
            transaction.commit();

        } catch (Exception e) {
            stateEntities = null;
            if (transaction != null) {
                transaction.rollback();
            }

        } finally {
            session.close();

        }
        return stateEntities;
    }


}
