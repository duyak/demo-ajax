package com.laptrinhjavaweb.server.impl;

import com.laptrinhjavaweb.entity.State;
import com.laptrinhjavaweb.entity.StateEntity;
import com.laptrinhjavaweb.repository.StateRepository;
import com.laptrinhjavaweb.server.StateServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stateServer")
public class StateServerImpl implements StateServer {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public List<State> findByCountry(Integer countryId) {
        return stateRepository.findByCountry(countryId);
    }


}
