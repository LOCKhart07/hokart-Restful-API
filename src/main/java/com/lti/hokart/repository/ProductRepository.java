package com.lti.hokart.repository;

import com.lti.hokart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public abstract List<Product> findByCategoryCategoryId(int CategoryId);
}
