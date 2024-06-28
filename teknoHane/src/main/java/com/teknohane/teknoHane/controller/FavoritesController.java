package com.teknohane.teknoHane.controller;

import com.teknohane.teknoHane.model.Users;
import com.teknohane.teknoHane.model.dto.FavoritesDTO;
import com.teknohane.teknoHane.model.dto.ProductDTO;
import com.teknohane.teknoHane.service.FavoritesService;
import lombok.RequiredArgsConstructor;
import org.apache.el.lang.ELSupport;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/favorites")
public class FavoritesController {

    private final FavoritesService favoritesService;
    @GetMapping("/get")
    public ResponseEntity<List<FavoritesDTO>> getAllFavorites(){
        List<FavoritesDTO> favorites = favoritesService.getAllFavorites();
        return  new ResponseEntity<>(favorites, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<FavoritesDTO> getFavoritesBYId(@PathVariable Long id){
        FavoritesDTO favoritesDTO = favoritesService.getFavoritesById(id);
        return new ResponseEntity<>(favoritesDTO , HttpStatus.OK);
    }

    @GetMapping("/getUserFavoritesInfo")
    public ResponseEntity<List<FavoritesDTO>> getUserFavoritesInfo(Authentication authentication) {
        Long favoriteToken = ((Users)authentication.getPrincipal()).getId();
        List<FavoritesDTO> favorites = favoritesService.getAllFavoritesByUserId(favoriteToken);
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }
    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FavoritesDTO> createFavorite(Authentication authentication , @RequestBody FavoritesDTO favoritesDTO){
        Date now = new Date();
        favoritesDTO.setCreationDate(now);
        FavoritesDTO createFavorite = favoritesService.createFavorites(authentication,favoritesDTO);
        return new ResponseEntity<>(createFavorite , HttpStatus.OK);
    }


    @PutMapping(value = "/update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FavoritesDTO> updateFavorites(@RequestBody FavoritesDTO favoritesDTO , @PathVariable Long id){
        FavoritesDTO updateFavorite = favoritesService.updateFavorites(favoritesDTO , id);
        return  new ResponseEntity<>(updateFavorite , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFavorites (@PathVariable Long id){
        boolean result = favoritesService.delete(id);
        if (result){
            return  new  ResponseEntity<>("Deleted "+id, HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteByProductId/{productId}")
    public ResponseEntity<String> deleteFavoritesByProductId (@PathVariable Long productId){
        int affectedRows = favoritesService.deleteByProductId(productId);
        if (affectedRows > 0) {
            return new ResponseEntity<>("Favorites deleted by productId: " + productId, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("No favorites found for productId: " + productId, HttpStatus.NOT_FOUND);
        }
    }



}
