package com.dw.producto.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.producto.entity.Producto;
import com.dw.producto.repositories.ProductoRepository;
import com.dw.producto.services.ProductoService;

@Service
public class ProductoServiceImp implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository; 

    @Override
    public List<Producto> getAllProductos() {
        try {
            return productoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving products", e);
        }
    }

    @Override
    public Producto getProductoById(Integer id) {
        try {
            return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving product by id", e);
        }
    }

    @Override
    public Producto createProducto(Producto producto) {
        try {
            return productoRepository.save(producto);
        } catch (Exception e) {
            throw new RuntimeException("Error creating product", e);
        }
    }

    @Override
    public Producto updateProducto(Integer id, Producto producto) {
        try {
            if (!productoRepository.existsById(id)) {
                throw new RuntimeException("Product not found with id: " + id);
            }
            producto.setId(id);
            return productoRepository.save(producto);
        } catch (Exception e) {
            throw new RuntimeException("Error updating product", e);
        }
    }

    @Override
    public void deleteProducto(Integer id) {
        try {
            if (!productoRepository.existsById(id)) {
                throw new RuntimeException("Product not found with id: " + id);
            }
            productoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting product", e);
        }
    }

    
}
