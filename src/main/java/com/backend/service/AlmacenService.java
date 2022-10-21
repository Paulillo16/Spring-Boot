package com.backend.service;

import com.backend.mapper.AlmacenMapper;
import com.backend.mapper.common.CycleAvoidingMappingContext;
import com.backend.model.entity.AlmacenEntity;
import com.backend.repository.IAlmacenRepository;
import com.backend.web.AlmacenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlmacenService implements IAlmacenService {

    private static final String UPDATE = "update";
    private static final String INSERT = "insert";

    @Autowired
    IAlmacenRepository almacenRepository;

    @Autowired
    AlmacenMapper almacenMapper;

    @Override
    public List<AlmacenDto> findAll() {
        return almacenMapper.toListDto(almacenRepository.findAll(), new CycleAvoidingMappingContext());
    }

    @Override
    public AlmacenDto findById(long id) {
        Optional<AlmacenEntity> optionalResult = almacenRepository.findById(id);
        if (optionalResult.isPresent()) {
            return almacenMapper.toDto(optionalResult.get(), new CycleAvoidingMappingContext());
        }
        return null;
    }

    @Override
    public AlmacenDto update(long id, AlmacenDto dto) {
        var oldDto = this.findById(id);
        if (oldDto != null) {
            oldDto.setCliente(dto.getCliente());
            oldDto.setTipo(dto.getTipo());
            oldDto.setTamanio(dto.getTamanio());
            return save(oldDto, UPDATE);
        }
        return null;
    }

    @Override
    public AlmacenDto insert(AlmacenDto dto) {
        return save(dto, INSERT);
    }
    private AlmacenDto save(AlmacenDto dto, String modo) {
        var saveEntity = almacenMapper.toEntity(dto, new CycleAvoidingMappingContext());
        if (INSERT.equals(modo)){
            saveEntity.setUuid(UUID.randomUUID());
        }
        var resEntity = almacenRepository.save(saveEntity);
        var resDto = almacenMapper.toDto(resEntity, new CycleAvoidingMappingContext());
        return resDto;
    }

    @Override
    public void deleteById(long id) {
        almacenRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        almacenRepository.deleteAll();
    }

}
