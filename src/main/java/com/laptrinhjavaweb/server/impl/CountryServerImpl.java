package com.laptrinhjavaweb.server.impl;

import com.laptrinhjavaweb.entity.Country;
import com.laptrinhjavaweb.repository.CountryRepository;
import com.laptrinhjavaweb.server.CountryServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("countyServer")
@Transactional
public class CountryServerImpl implements CountryServer {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country find(Integer id) {
        return countryRepository.find(id);
    }
}
