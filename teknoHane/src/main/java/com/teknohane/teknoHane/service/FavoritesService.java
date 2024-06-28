package com.teknohane.teknoHane.service;

import com.teknohane.teknoHane.model.dto.FavoritesDTO;
import com.teknohane.teknoHane.model.dto.ProductDTO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
public interface FavoritesService {

    List<FavoritesDTO> getAllFavorites();
    FavoritesDTO getFavoritesById(Long id);

    List<FavoritesDTO> getAllFavoritesByUserId(Long userId);

    FavoritesDTO createFavorites(Authentication authentication, FavoritesDTO favoritesDTO);
    FavoritesDTO updateFavorites(FavoritesDTO favoritesDTO,Long id);
    boolean delete( Long id);

    int deleteByProductId(Long productId);
}
