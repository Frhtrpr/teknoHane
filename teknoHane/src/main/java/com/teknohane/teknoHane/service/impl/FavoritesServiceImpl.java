package com.teknohane.teknoHane.service.impl;

import com.teknohane.teknoHane.model.Favorites;
import com.teknohane.teknoHane.model.Users;
import com.teknohane.teknoHane.model.dto.FavoritesDTO;
import com.teknohane.teknoHane.model.dto.ProductDTO;
import com.teknohane.teknoHane.model.mapper.FavoritesMapper;
import com.teknohane.teknoHane.repository.FavoritesRepository;
import com.teknohane.teknoHane.service.FavoritesService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoritesServiceImpl implements FavoritesService {

    private final FavoritesRepository favoritesRepository;
    @Override
    public List<FavoritesDTO> getAllFavorites() {
        List<Favorites> favorites = favoritesRepository.findAll();
        return favorites.stream().map(FavoritesMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public FavoritesDTO getFavoritesById(Long id) {
        Favorites favorites = favoritesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Favorites not found by id"+ id));
        return FavoritesMapper.toDTO(favorites);
    }

    @Override
    public List<FavoritesDTO> getAllFavoritesByUserId(Long userId) {
        List<Favorites> favorites = favoritesRepository.findAllByUserId(userId);
        return favorites.stream().map(FavoritesMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public FavoritesDTO createFavorites (Authentication authentication, FavoritesDTO favoritesDTO) {

        Users users= (Users) authentication.getPrincipal();

        Favorites favorites = FavoritesMapper.toEntity(favoritesDTO);

        favorites.setUserId(users.getId());
        Favorites savedFavorites = favoritesRepository.save(favorites);
        return FavoritesMapper.toDTO(savedFavorites);
    }

    @Override
    public FavoritesDTO updateFavorites(FavoritesDTO favoritesDTO, Long id) {
        Favorites favorites = favoritesRepository.findById(id)
                .orElseThrow(() -> new  RuntimeException("Favorites not found id" + id));
        Favorites updateFavorites = FavoritesMapper.toEntity(favoritesDTO);
        updateFavorites.setProductId(favorites.getProductId());
        updateFavorites = favoritesRepository.save(updateFavorites);
        return FavoritesMapper.toDTO(updateFavorites);
    }

    @Override
    public boolean delete(Long id) {
        if (!favoritesRepository.existsById(id)){
            return false;
        }
            favoritesRepository.deleteById(id);
            return true;

    }


    @Override
    @Transactional
    public int deleteByProductId(Long productId) {
        return favoritesRepository.deleteByProductId(productId);
    }


}
