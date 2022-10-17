package com.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.model.entity.Almacen;

public interface AlmacenRepository extends JpaRepository<Almacen, Long> {

}
