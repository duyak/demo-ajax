package com.laptrinhjavaweb.server;

import com.laptrinhjavaweb.entity.State;
import com.laptrinhjavaweb.entity.StateEntity;

import java.util.List;

public interface StateServer {

    public List<State> findByCountry(Integer countryId);



}
