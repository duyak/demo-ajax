package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.State;
import com.laptrinhjavaweb.entity.StateEntity;

import java.util.List;

public interface StateRepository {

    public List<State> findByCountry(Integer countryId);




}
