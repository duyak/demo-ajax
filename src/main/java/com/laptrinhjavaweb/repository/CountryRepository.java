package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository {

     public List<Country> findAll();


}
