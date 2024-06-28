package com.teknohane.teknoHane.model.mapper;

import com.teknohane.teknoHane.model.Category;
import com.teknohane.teknoHane.model.dto.CategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {


    public static CategoryDTO toDTO(Category category){
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        dto.setCategoryDescription(category.getCategoryDescription());
        dto.setCategoryImages(category.getCategoryImages());

        return dto;
    }

    public static Category toEntity(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setCategoryId(categoryDTO.getCategoryId());
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setCategoryDescription(categoryDTO.getCategoryDescription());
        category.setCategoryImages(categoryDTO.getCategoryImages());

        return category;
    }
}
