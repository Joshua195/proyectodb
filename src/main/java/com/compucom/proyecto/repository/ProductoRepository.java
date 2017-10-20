package com.compucom.proyecto.repository;

import com.compucom.proyecto.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.sql.rowset.serial.SerialArray;
import javax.transaction.Transactional;
import java.io.Serializable;

public interface ProductoRepository extends JpaRepository<Producto, Serializable> {
    Producto findById(Integer id);
    @Transactional
    void deleteById(Integer id);

    @Query("SELECT r.imagen FROM Producto r where r.id = :id")
    String findImagenById(@Param("id") Integer id);
}
