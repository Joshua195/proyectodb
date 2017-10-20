package com.compucom.proyecto.service;

import com.compucom.proyecto.model.ProductModel;

import java.util.List;

public interface ProductService {
    void saveProduct(ProductModel productModel);
    ProductModel getProductById(Integer id);
    List<ProductModel> getAllProducts();
    void deleteProductById(Integer id);
    String findImagenById(Integer id);
}
