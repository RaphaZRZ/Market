package com.market.market.controllers;

import com.market.market.dtos.ProductDTO;
import com.market.market.dtos.UpdateProductDTO;
import com.market.market.models.Product;
import com.market.market.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Validated
public class ProductController {
    @Autowired
    ProductService productService;

    // GET MAPPINGS
    @GetMapping("/id/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product obj = this.productService.findProductById(id);
        return ResponseEntity.ok().body(obj);
    }

    // POST MAPPINGS
    @Validated
    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        Product obj = this.productService.createProduct(productDTO);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    // PUT MAPPINGS
    @Validated
    @PutMapping("/id/{id}")
    public ResponseEntity<Void> updateProductById(@Valid @RequestBody UpdateProductDTO updateProductDTO, @PathVariable Long id) {
        this.productService.updateProductById(updateProductDTO, id);
        return ResponseEntity.noContent().build();
    }

    // DELETE MAPPINGS
    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        this.productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}
