package com.lti.hokart.controller;


import com.lti.hokart.model.Category;
import com.lti.hokart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/categories/", "/categories"})
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    //  http://127.0.0.1:8069/api/categories
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List> getCategories() {
        List<Category> categories = categoryService.getAllCategories();
        HttpStatus httpStatus = HttpStatus.FOUND;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Message", "Get all Categories");
        return new ResponseEntity<>(categories, httpHeaders, httpStatus);
    }

    //  http://127.0.0.1:8069/api/categories
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        HttpStatus httpStatus = HttpStatus.OK;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Message", "Category added successfully!");
        return new ResponseEntity<>(categoryService.addCategory(category), httpHeaders, httpStatus);
    }


    //  http://127.0.0.1:8069/api/categories/1
    @RequestMapping(value = {"{category_id}"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Category> getProducts(@PathVariable(name = "category_id") int categoryID) {
        Category category = categoryService.getCategoryById(categoryID);
        HttpStatus httpStatus = HttpStatus.FOUND;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Message", "Here is the product");

        return new ResponseEntity<>(category, httpHeaders, httpStatus);
    }

    //  http://127.0.0.1:8069/api/categories/1
    @RequestMapping(value = {"{category_id}"}, method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Category> removeCategory(@PathVariable(name = "category_id") int categoryID) {
        Category category = categoryService.removeCategoryByID(categoryID);
        HttpStatus status = HttpStatus.CREATED;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Message", "Category was deleted successfully!");
        ResponseEntity<Category> response = new ResponseEntity<>(category, headers, status);
        return response;
    }

    //  http://127.0.0.1:8069/api/categories
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(category);
        HttpStatus status = HttpStatus.CREATED;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Message", "Category was updated successfully!");
        ResponseEntity<Category> response = new ResponseEntity<>(updatedCategory, headers, status);
        return response;
    }
}
