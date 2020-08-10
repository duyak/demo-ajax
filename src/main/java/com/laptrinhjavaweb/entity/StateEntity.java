package com.laptrinhjavaweb.entity;

import java.io.Serializable;

public class StateEntity implements Serializable {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
