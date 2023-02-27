package com.lti.hokart.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.hokart.Repository.ProductReviewRepository;
import com.lti.hokart.model.Product;
import com.lti.hokart.model.ProductReview;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductReviewService {
    @Autowired
    private ProductReviewRepository productReviewRepository;

    public List<ProductReview> getProductReviews(Product product) {
        return productReviewRepository.findByProduct(product);
    }

    public List<ProductReview> getUserProductReviews(User user) {
        return ProductReviewRepository.findByUser(user);
    }

    public ProductReview addProductReview(Product product, User user, Integer rating, String comment) {
        ProductReview review = new ProductReview();
        review.setProduct(product);
        review.setUser(user);
        review.setRating(rating);
        review.setComment(comment);
        return productReviewRepository.save(review);
    }
    public void deleteProductReview(Long reviewId, User user) {
        java.util.Optional<ProductReview> review = java.util.Optional.empty();
		try {
			review = ProductReviewRepository.findByIdAndUser(reviewId, user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (review != null) {
            productReviewRepository.deleteById(review);
        } else {
            throw new EntityNotFoundException("Product Review not found");
        }
    }

}


