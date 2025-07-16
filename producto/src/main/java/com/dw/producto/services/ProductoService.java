package com.dw.producto.services;

import java.util.List;

import com.dw.producto.entity.Producto;

public interface ProductoService {

    List<Producto> getAllProductos();
    Producto getProductoById(Integer id);
    Producto createProducto(Producto producto);
    Producto updateProducto(Integer id, Producto producto);
    void deleteProducto(Integer id);
}
