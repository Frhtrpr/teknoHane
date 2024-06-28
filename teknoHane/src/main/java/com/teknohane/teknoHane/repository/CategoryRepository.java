package com.teknohane.teknoHane.repository;

import com.teknohane.teknoHane.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository <Category , Long> {
}
