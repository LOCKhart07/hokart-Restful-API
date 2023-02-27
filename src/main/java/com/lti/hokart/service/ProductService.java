package com.lti.hokart.service;

import com.lti.hokart.exception.ProductNotFoundException;
import com.lti.hokart.model.Category;
import com.lti.hokart.model.Product;
import com.lti.hokart.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductRepository productRepository;

    @Override
    public List getAllProducts() {
        List<Product> products = productRepository.findAll();
        LOGGER.info("Output all products");
        return products;
    }

    @Override
    public Product getProductByID(int id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) {
            String errorMessage = "Product with ID:" + id + " not found";
            LOGGER.warn(errorMessage);
            throw new ProductNotFoundException(errorMessage);
        }

        LOGGER.info("Fetched product by id");
        return product.get();
    }

    @Override
    public List getProductsByCategory(Category category) {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        LOGGER.info("Added Product");
        return productRepository.save(product);
    }

    @Override
    public Product removeProductByID(int id) {
        Product product = this.getProductByID(id);
        productRepository.deleteById(id);
        LOGGER.info("Removed Product");
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        this.getProductByID(product.getId());
        LOGGER.info("Updated Product");
        return productRepository.save(product);
    }
}
