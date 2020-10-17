package com.example.demo.repository;

import com.example.demo.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author amit.bhoraniya
 * @created 17/10/20
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    boolean existsById(Long id);
}