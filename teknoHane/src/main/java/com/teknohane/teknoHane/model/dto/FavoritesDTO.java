package com.teknohane.teknoHane.model.dto;

import com.teknohane.teknoHane.model.Category;
import com.teknohane.teknoHane.model.Products;
import com.teknohane.teknoHane.model.Users;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FavoritesDTO {

    private Long favoriteId;
    private Long userId;
    private Long categoryId;
    private Long productId;
    private Date creationDate;
}
