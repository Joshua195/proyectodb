package com.compucom.proyecto.repository;

import com.compucom.proyecto.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Serializable>{}
