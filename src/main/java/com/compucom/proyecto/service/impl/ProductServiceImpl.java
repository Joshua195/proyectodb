package com.compucom.proyecto.service.impl;

import com.compucom.proyecto.converter.ProductConverter;
import com.compucom.proyecto.entity.Producto;
import com.compucom.proyecto.model.ProductModel;
import com.compucom.proyecto.repository.ProductoRepository;
import com.compucom.proyecto.service.ProductService;
import com.compucom.proyecto.utils.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private StorageService storageService;

    @Override
    public void saveProduct(ProductModel productModel) {
        productoRepository.save(productConverter.modelToEntity(productModel));
        storageService.store(productModel.getImagen());
    }

    @Override
    public ProductModel getProductById(Integer id) {
        return productConverter.entityToModel(productoRepository.findById(id));
    }

    @Override
    public List<ProductModel> getAllProducts() {
         List<ProductModel> productModels = new ArrayList<>();
         for (Producto producto : productoRepository.findAll()){
             productModels.add(productConverter.entityToModel(producto));
         }
        return productModels;
    }

    @Override
    public void deleteProductById(Integer id) {
        storageService.deleteOne(findImagenById(id));
        productoRepository.deleteById(id);
    }

    @Override
    public String findImagenById(Integer id) {
        return productoRepository.findImagenById(id);
    }
}
