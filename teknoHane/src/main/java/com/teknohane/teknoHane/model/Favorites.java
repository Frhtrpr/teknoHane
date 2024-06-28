package com.teknohane.teknoHane.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "favorites")
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "favorite_id")
    private Long fovoriteId;

    @ManyToOne(cascade = {CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH , CascadeType.DETACH}, targetEntity = Users.class)
    @JoinColumn(name = "user_izd", insertable = false , updatable = false)
    @JsonIgnore
    private Users user;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(cascade = {CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH , CascadeType.DETACH}, targetEntity = Category.class)
    @JoinColumn(name = "category_id", insertable = false , updatable = false)
    @JsonIgnore
    private Category category;

    @Column(name = "category_id")
    private Long categoryId;


    @ManyToOne(cascade = {CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH , CascadeType.DETACH}, targetEntity = Products.class)
    @JoinColumn(name = "product_id", insertable = false , updatable = false )
    @JsonIgnore
    private Products products;

    @Column(name = "product_id")
    private Long productId;


    @Column(name = "creation_Date")
    private Date creationDate;

}


