package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "state")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country countryId;
    @OneToMany(mappedBy = "stateId", fetch = FetchType.LAZY)
    private Set<City> citys = new HashSet<>();

    public State() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public Set<City> getCitys() {
        return citys;
    }

    public void setCitys(Set<City> citys) {
        this.citys = citys;
    }
}
