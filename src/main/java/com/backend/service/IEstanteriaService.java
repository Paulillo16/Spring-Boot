package com.backend.service;

import com.backend.web.AlmacenDto;
import com.backend.web.EstanteriaDto;

import java.util.List;

public interface IEstanteriaService {

    List<EstanteriaDto> findAll();

    EstanteriaDto findById(long id);

    EstanteriaDto update(long id, EstanteriaDto dto);

    EstanteriaDto insert(EstanteriaDto dto);

    void deleteById(long id);

    void deleteAll();

}
