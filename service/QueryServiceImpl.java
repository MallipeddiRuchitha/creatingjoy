package com.technocrats.creatingjoy.service;

import com.technocrats.creatingjoy.dao.QueryRepository;
import com.technocrats.creatingjoy.dto.QueryDTO;
import com.technocrats.creatingjoy.entity.Query;
import com.technocrats.creatingjoy.objectmapper.QueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class QueryServiceImpl implements QueryService{

    private QueryRepository queryRepository;

    @Autowired
    public QueryServiceImpl(QueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }
    @Autowired
    private QueryMapper queryMapper;
    @Override
    @Transactional
    public List<Query> findAll() {
        return queryRepository.findAll();
    }

    @Override
    @Transactional
    public Query findById(int id) {
        Optional<Query> result=queryRepository.findById(id);

        if(result.isPresent()){
            return result.get();
        }
        else{
            throw new RuntimeException("Did not found Query with id "+id);
        }


    }

    @Override
    @Transactional
    public void save(QueryDTO queryDTO) {
     Query query=queryMapper.convertToEntity(queryDTO);
        queryRepository.save(query);

    }

    @Override
    @Transactional
    public void deleteById(int id) {

        queryRepository.deleteById(id);

    }
}
