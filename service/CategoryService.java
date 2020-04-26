package com.technocrats.creatingjoy.service;

import com.technocrats.creatingjoy.dto.CategoryDTO;
import com.technocrats.creatingjoy.entity.Category;
import org.springframework.stereotype.Service;


public interface CategoryService {
    CategoryDTO findByName(String categoryName);
}
