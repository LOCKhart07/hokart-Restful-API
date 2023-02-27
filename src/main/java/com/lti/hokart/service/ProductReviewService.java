package com.lti.hokart.service;

import java.util.List;

import com.lti.hokart.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.hokart.repository.ProductReviewRepository;
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

    public List<ProductReview> getUserProductReviews(AppUser user) {
        return productReviewRepository.findByUser(user);
    }

    public ProductReview addProductReview(Product product, AppUser user, Integer rating, String comment) {
        ProductReview review = new ProductReview();
        review.setProduct(product);
        review.setUser(user);
        review.setRating(rating);
        review.setComment(comment);
        return productReviewRepository.save(review);
    }
    public void deleteProductReview(Long reviewId, AppUser user) {
        java.util.Optional<ProductReview> review = java.util.Optional.empty();
		try {
			review = productReviewRepository.findByIdAndUser(reviewId, user);
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


