package com.teknohane.teknoHane.controller;

import com.teknohane.teknoHane.model.dto.ProductDetailDTO;
import com.teknohane.teknoHane.service.ProductDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products-detail")
public class ProductDetailController {

    private final ProductDetailService productDetailService;

    @GetMapping("/get")
    public ResponseEntity<List<ProductDetailDTO>> getAllProductsDetail(){
        List<ProductDetailDTO> productsDetailList = productDetailService.getAllProductDetail();
        return new ResponseEntity<>(productsDetailList , HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductDetailDTO> getProductDetailById(@PathVariable  Long id){
        ProductDetailDTO getDetailById = productDetailService.getProductDetailById(id);
        return new ResponseEntity<>(getDetailById , HttpStatus.OK);
    }

    @GetMapping("/getDetailByProductId/{productId}")
    public  ResponseEntity<ProductDetailDTO> getProductDetailByProductId(@PathVariable Long productId){
        ProductDetailDTO getByProductId = productDetailService.getProductDetailByProductId(productId);
        return  new ResponseEntity<>( getByProductId , HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity <ProductDetailDTO> createProductDetail(@RequestBody ProductDetailDTO productDetailDTO){
        ProductDetailDTO saveProductDetail = productDetailService.createProductDetail(productDetailDTO);
        return new ResponseEntity<>(saveProductDetail , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDetailDTO> updateProductDetail (@PathVariable Long id , @RequestBody ProductDetailDTO productDetailDTO){
        ProductDetailDTO updateDetail = productDetailService.updateProductDetail(productDetailDTO, id);
        return new ResponseEntity<>(updateDetail , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> deleteProductDetail (@PathVariable Long id){
        boolean result = productDetailService.deleteByDetailId(id);
        if (result) {
            return new ResponseEntity<>("Deleted "+id , HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    }

