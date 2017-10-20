package com.compucom.proyecto.converter;

import com.compucom.proyecto.entity.Producto;
import com.compucom.proyecto.model.ProductModel;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ProductConverter {

    public Producto modelToEntity(ProductModel model){
        Producto producto = new Producto();
        producto.setId(model.getId());
        producto.setNombre(model.getNombre());
        producto.setCategoria(model.getCategoria());
        producto.setDescripcion(model.getDescripcion());
        producto.setImagen(StringUtils.cleanPath(model.getImagen().getOriginalFilename()));
        producto.setPrecio(model.getPrecio());
        return producto;
    }

    public ProductModel entityToModel(Producto producto){
        ProductModel productModel = new ProductModel();
        productModel.setId(producto.getId());
        productModel.setNombre(producto.getNombre());
        productModel.setCategoria(producto.getCategoria());
        productModel.setDescripcion(producto.getDescripcion());
        productModel.setPrecio(producto.getPrecio());
        return productModel;
    }
}
