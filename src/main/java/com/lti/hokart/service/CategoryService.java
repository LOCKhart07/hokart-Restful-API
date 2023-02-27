package com.lti.hokart.service;

import com.lti.hokart.exception.CategoryNotFoundException;
import com.lti.hokart.model.Category;
import com.lti.hokart.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryService implements ICategoryService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        LOGGER.info("Output all categories");
        return categories;
    }

    @Override
    public Category addCategory(Category category) {
        LOGGER.info("Added category");
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(int id) {
        Optional<Category> category = categoryRepository.findById(id);

        if (category.isEmpty()) {
            String errorMessage = "Category with ID:" + id + " not found";
            LOGGER.warn(errorMessage);
            throw new CategoryNotFoundException(errorMessage);
        }

        LOGGER.info("Fetched category by id");
        return category.get();
    }

    @Override
    public Category updateCategory(Category category) {
        this.getCategoryById(category.getCategoryId());
        LOGGER.info("Updated Category");
        return categoryRepository.save(category);
    }

    @Override
    public Category removeCategoryByID(int id) {
        Category category = this.getCategoryById(id);
        categoryRepository.deleteById(id);
        LOGGER.info("Removed Category");
        return category;
    }
}
