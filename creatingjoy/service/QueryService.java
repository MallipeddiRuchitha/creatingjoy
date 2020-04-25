package com.technocrats.creatingjoy.service;

import com.technocrats.creatingjoy.entity.Query;

import java.util.List;

public interface QueryService {

    List<Query> findAll();
    Query findById(int id);
    void save(Query query);
    void deleteById(int id);
}
