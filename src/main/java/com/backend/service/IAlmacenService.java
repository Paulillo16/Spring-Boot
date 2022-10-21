package com.backend.service;

import com.backend.web.AlmacenDto;

import java.util.List;

public interface IAlmacenService {

    List<AlmacenDto> findAll();

    AlmacenDto findById(long id);

    AlmacenDto update(long id, AlmacenDto dto);

    AlmacenDto insert(AlmacenDto dto);

    void deleteById(long id);

    void deleteAll();

}
