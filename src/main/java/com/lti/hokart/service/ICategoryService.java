package com.lti.hokart.service;

import com.lti.hokart.model.Category;

import java.util.List;

public interface ICategoryService {
    List getAllCategories();

    Category addCategory(Category category);

    Category getCategoryById(int id);

    Category updateCategory(Category category);

    Category removeCategoryByID(int id);
}
