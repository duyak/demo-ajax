package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.entity.Country;
import com.laptrinhjavaweb.repository.CountryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("countryDAO")
public class CountryRepositoryImpl implements CountryRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Country> findAll() {
        List<Country> countries = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            countries = session.createQuery("FROM country").list();
            transaction.commit();

        } catch (Exception e) {
            countries = null;
            if (transaction != null) {
                transaction.rollback();
            }

        } finally {
            session.close();

        }
        return countries;
    }
}
