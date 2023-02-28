package com.lti.hokart.repository;

import java.util.List;
import java.util.Optional;

import com.lti.hokart.model.AppUser;

import com.lti.hokart.model.Product;
import com.lti.hokart.model.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {

    public List<ProductReview> findByProduct(Product product) ;

    public ProductReview save(ProductReview review) ;

    public Optional<ProductReview> findByIdAndUser(Long reviewId, AppUser user) ;

    public List<ProductReview> findByUser(AppUser user) ;

    public void deleteById(Optional<ProductReview> review) ;

}

