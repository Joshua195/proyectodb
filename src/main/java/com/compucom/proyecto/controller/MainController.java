package com.compucom.proyecto.controller;


import com.compucom.proyecto.entity.Producto;
import com.compucom.proyecto.model.ProductModel;
import com.compucom.proyecto.repository.CompraRepository;
import com.compucom.proyecto.service.ProductService;
import com.compucom.proyecto.utils.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.core.io.Resource;

@Controller
public class MainController {


    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private StorageService storageService;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("product", new Producto());
        if (!productService.getAllProducts().isEmpty()) {
            modelAndView.addObject("products", productService.getAllProducts());
        }
        return modelAndView;
    }

    @PostMapping("/new-product")
    public String saveProduct(@ModelAttribute(name = "product") ProductModel productoModel){
        productService.saveProduct(productoModel);
        return "redirect:/";
    }

    @GetMapping("/delete-product")
    public String deleteProduct(@RequestParam(name = "id") Integer id){
        productService.deleteProductById(id);
        return "redirect:/";
    }

    @GetMapping("/files")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@RequestParam Integer id) {
        String filename = productService.findImagenById(id);
        if (filename != null){
            Resource file = storageService.loadAsResource(filename);
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        }
        return null;
    }
}
