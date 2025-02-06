package com.market.market.services;

import com.market.market.dtos.ProductDTO;
import com.market.market.dtos.UpdateProductDTO;
import com.market.market.exceptions.ProductNotFoundException;
import com.market.market.models.Product;
import com.market.market.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class responsible for handling product-related business logic.
 * It interacts with the ProductRepository to perform some operations on products.
 */
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    /**
     * Finds a product by its ID.
     *
     * @param id the unique identifier of the product.
     * @return the found product.
     * @throws ProductNotFoundException if the product with the given id is not found.
     */
    public Product findProductById(Long id){
        return this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    /**
     * Saves a given product to the repository.
     *
     * @param product the product to save.
     */
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    /**
     * Creates a new product using the provided ProductDTO.
     *
     * @param productDTO the DTO containing the product information.
     * @return the newly created product.
     */
    @Transactional
    public Product createProduct(ProductDTO productDTO){
        Product product = new Product(productDTO);
        saveProduct(product);
        return product;
    }

    /**
     * Updates the details of an existing product by its ID.
     *
     * @param updateProductDTO the DTO containing the updated product information.
     * @param id the unique identifier of the product to update.
     * @throws ProductNotFoundException if the product with the given id is not found.
     */
    @Transactional
    public void updateProductById(UpdateProductDTO updateProductDTO, Long id) {
        Product product = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        product.setPrice(updateProductDTO.price());
        saveProduct(product);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the unique identifier of the product to delete.
     * @throws ProductNotFoundException if the product with the given id is not found.
     */
    @Transactional
    public void deleteProductById(Long id) {
        if (!this.productRepository.existsById(id))
            throw new ProductNotFoundException();

        this.productRepository.deleteById(id);
    }
}