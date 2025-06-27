package org.yearup.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.List;

// add the annotations to make this a REST controller
// add the annotation to make this controller the endpoint for the following url
    // http://localhost:8080/categories
// add annotation to allow cross site origin requests

@CrossOrigin
@RestController
@RequestMapping("/categories")

public class CategoriesController {
    // create an Autowired controller to inject the categoryDao and ProductDao
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProductDao productDao;


    // add the appropriate annotation for a get action
    @GetMapping
    public ResponseEntity<List<Category>> getAll() {

        // find and return all categories
        List<Category> categories = categoryDao.getAllCategories();
        return  new ResponseEntity<>(categories,HttpStatus.OK);
    }

    // add the appropriate annotation for a get action
    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable int id) {
        Category category = categoryDao.getById(id);



        if(category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>( HttpStatus.OK);

        // get the category by id

    }

    // the url to return all products in category 1 would look like this
    // https://localhost:8080/categories/1/products
    @GetMapping("{categoryId}/products")
    public ResponseEntity<List<Product>> getProductsById(@PathVariable int categoryId) {
        List<Product> products = productDao.listByCategoryId(categoryId);

        if(products == null || products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        // get a list of product by categoryId
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // add annotation to call this method for a POST action
    // add annotation to ensure that only an ADMIN can call this function
    @PostMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category created = categoryDao.create(category);
        // insert the category
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // add annotation to call this method for a PUT (update) action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> updateCategory(@PathVariable int id, @RequestBody Category category) {
        Category existing = categoryDao.update(id,category);

        if(existing == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // update the category by id
        categoryDao.update(id, category);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    // add annotation to call this method for a DELETE action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        // delete the category by id

        Category existing = categoryDao.getById(id);

        if ( existing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        categoryDao.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }


