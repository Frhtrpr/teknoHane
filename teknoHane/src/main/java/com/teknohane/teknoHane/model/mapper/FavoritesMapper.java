package com.teknohane.teknoHane.model.mapper;

import com.teknohane.teknoHane.model.Favorites;
import com.teknohane.teknoHane.model.dto.FavoritesDTO;
import org.springframework.stereotype.Component;

@Component
public class FavoritesMapper {

    public static FavoritesDTO toDTO(Favorites favorites){
        FavoritesDTO favoritesDTO = new FavoritesDTO();

        favoritesDTO.setFavoriteId(favorites.getFovoriteId());
        favoritesDTO.setUserId(favorites.getUserId());
        favoritesDTO.setCategoryId(favorites.getCategoryId());
        favoritesDTO.setProductId(favorites.getProductId());
        favoritesDTO.setCreationDate(favorites.getCreationDate());

        return favoritesDTO;
    }

    public  static Favorites toEntity(FavoritesDTO favoritesDTO){
        Favorites favorites = new Favorites();

        favorites.setFovoriteId(favoritesDTO.getFavoriteId());
        favorites.setUserId(favoritesDTO.getUserId());
        favorites.setCategoryId(favoritesDTO.getCategoryId());
        favorites.setProductId(favoritesDTO.getProductId());
        favorites.setCreationDate(favoritesDTO.getCreationDate());

        return favorites;
    }
}
