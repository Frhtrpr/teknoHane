package com.teknohane.teknoHane.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CategoryDTO  {

    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
    private List<String> categoryImages;
}
