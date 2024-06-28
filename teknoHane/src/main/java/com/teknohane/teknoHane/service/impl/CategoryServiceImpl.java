package com.teknohane.teknoHane.service.impl;

import com.teknohane.teknoHane.model.Category;
import com.teknohane.teknoHane.model.dto.CategoryDTO;
import com.teknohane.teknoHane.model.mapper.CategoryMapper;
import com.teknohane.teknoHane.repository.CategoryRepository;
import com.teknohane.teknoHane.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {


    private  final CategoryRepository categoryRepository;


    @Override
    public List<CategoryDTO> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        return CategoryMapper.toDTO(category);
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toDTO(category);
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        Category updatedCategory = CategoryMapper.toEntity(categoryDTO);
        updatedCategory.setCategoryId(existingCategory.getCategoryId());
        updatedCategory = categoryRepository.save(updatedCategory);
        return CategoryMapper.toDTO(updatedCategory);
    }

    @Override
    public boolean deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            return false;
        }
        categoryRepository.deleteById(id);
        return true;
    }


}
