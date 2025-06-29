package com.teknohane.teknoHane.model.dto;

import com.teknohane.teknoHane.model.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.servlet.view.script.ScriptTemplateConfig;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProductDTO {

    private Long productId;
    private String productName;
    private String description;
    private double price;
    private int stockQuantity;
    private String productInfo;
    private Long categoryId;
    private String sellerName;
    private List<String> productImages;


}
