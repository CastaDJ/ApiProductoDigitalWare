package com.dw.producto.repositories;

import org.springframework.stereotype.Repository;

import com.dw.producto.entity.Producto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Additional query methods can be defined here if needed

}
