package com.lti.hokart.Repository;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;

import com.lti.hokart.model.Product;
import com.lti.hokart.model.ProductReview;

public class ProductReviewRepository {

	public List<ProductReview> findByProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	public ProductReview save(ProductReview review) {
		// TODO Auto-generated method stub
		return null;
	}
	public static Optional<ProductReview> findByIdAndUser(Long reviewId, User user) {
		// TODO Auto-generated method stub
		return null;
	}
	public static List<ProductReview> findByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	public void deleteById(Optional<ProductReview> review) {
		// TODO Auto-generated method stub
		
	}

}

