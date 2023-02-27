package com.lti.hokart.controller;

import com.lti.hokart.model.Product;
import com.lti.hokart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/products/", "/products"})
public class ProductController {

    @Autowired
    ProductService productService;

    //  http://127.0.0.1:8069/api/products
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List> getProducts() {
        List<Product> products = productService.getAllProducts();
        HttpStatus httpStatus = HttpStatus.FOUND;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Message", "Output all products");
        return new ResponseEntity<>(products, httpHeaders, httpStatus);
    }

    //  http://127.0.0.1:8069/api/products
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        HttpStatus httpStatus = HttpStatus.OK;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Message", "Product added successfully!");
        return new ResponseEntity<>(productService.addProduct(product), httpHeaders, httpStatus);
    }

    //  http://127.0.0.1:8069/api/products/1
    @RequestMapping(value = {"{product_id}"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Product> getProducts(@PathVariable(name = "product_id") int productID) {
        Product product = productService.getProductByID(productID);
        HttpStatus httpStatus = HttpStatus.FOUND;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Message", "Here is the product");

        return new ResponseEntity<>(product, httpHeaders, httpStatus);
    }

    //  http://127.0.0.1:8069/api/products/1
    @RequestMapping(value = {"{product_id}"}, method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Product> removeProduct(@PathVariable(name = "product_id") int productID) {
        Product product = productService.removeProductByID(productID);
        HttpStatus status = HttpStatus.CREATED;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Message", "Product was deleted successfully!");
        ResponseEntity<Product> response = new ResponseEntity<>(product, headers, status);
        return response;
    }

    //  http://127.0.0.1:8069/api/products
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        HttpStatus status = HttpStatus.CREATED;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Message", "Product was updated successfully!");
        ResponseEntity<Product> response = new ResponseEntity<>(updatedProduct, headers, status);
        return response;
    }
}
