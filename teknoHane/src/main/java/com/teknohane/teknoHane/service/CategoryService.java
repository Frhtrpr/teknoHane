package com.teknohane.teknoHane.service;

import com.teknohane.teknoHane.model.dto.CategoryDTO;


import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<CategoryDTO> getAll();
    CategoryDTO getCategoryById(Long id);
    CategoryDTO create(CategoryDTO categoryDTO);
    CategoryDTO update(Long id, CategoryDTO categoryDTO);
    boolean deleteCategory(Long id);
}
