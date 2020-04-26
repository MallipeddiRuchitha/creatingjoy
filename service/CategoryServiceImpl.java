package com.technocrats.creatingjoy.service;

import com.technocrats.creatingjoy.dao.CategoryRepository;
import com.technocrats.creatingjoy.dto.CategoryDTO;
import com.technocrats.creatingjoy.entity.Category;
import com.technocrats.creatingjoy.objectmapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements  CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public CategoryDTO findByName(String categoryName){
       return categoryMapper.convertToDto(categoryRepository.findByCategoryName(categoryName));
    }
}
