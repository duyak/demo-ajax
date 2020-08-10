package com.laptrinhjavaweb.server;

import com.laptrinhjavaweb.entity.Country;

import java.util.List;

public interface CountryServer {

    public List<Country> findAll();

    public Country find(Integer id);
}
