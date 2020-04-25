package com.technocrats.creatingjoy.objectmapper;

import com.technocrats.creatingjoy.dto.QueryDTO;
import com.technocrats.creatingjoy.entity.Query;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryMapper {


    @Autowired
    private ModelMapper mapper;

    public QueryDTO convertToDto(Query theQuery){

        QueryDTO theQueryDto=mapper.map(theQuery,QueryDTO.class);
        return theQueryDto;

    }


    public Query convertToEntity(QueryDTO theQueryDto){

        Query theQuery=mapper.map(theQueryDto,Query.class);
        return theQuery;

    }







}
