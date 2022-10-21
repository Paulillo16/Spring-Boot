package com.backend.service;

import com.backend.mapper.EstanteriaMapper;
import com.backend.mapper.common.CycleAvoidingMappingContext;
import com.backend.model.entity.AlmacenEntity;
import com.backend.model.entity.EstanteriaEntity;
import com.backend.repository.IEstanteriaRepository;
import com.backend.web.AlmacenDto;
import com.backend.web.EstanteriaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EstanteriaService implements IEstanteriaService {

    private static final String UPDATE = "update";
    private static final String INSERT = "insert";

    @Autowired
    IEstanteriaRepository estanteriaRepository;

    @Autowired
    EstanteriaMapper estanteriaMapper;

    @Override
    public List<EstanteriaDto> findAll() {
        return estanteriaMapper.toListDto(estanteriaRepository.findAll(), new CycleAvoidingMappingContext());
    }

    @Override
    public EstanteriaDto findById(long id) {
        Optional<EstanteriaEntity> optionalResult = estanteriaRepository.findById(id);
        if (optionalResult.isPresent()) {
            return estanteriaMapper.toDto(optionalResult.get(), new CycleAvoidingMappingContext());
        }
        return null;
    }

    @Override
    public EstanteriaDto update(long id, EstanteriaDto dto) {
        var oldDto = this.findById(id);
        if (oldDto != null) {
            oldDto.setTipo(dto.getTipo());
            oldDto.setAlmacen(dto.getAlmacen());
            return save(oldDto, UPDATE);
        }
        return null;
    }

    @Override
    public EstanteriaDto insert(EstanteriaDto dto) {
        return save(dto, INSERT);
    }
    private EstanteriaDto save(EstanteriaDto dto, String modo) {
        var saveEntity = estanteriaMapper.toEntity(dto, new CycleAvoidingMappingContext());
        if (INSERT.equals(modo)){
            saveEntity.setUuid(UUID.randomUUID());
        }
        var resEntity = estanteriaRepository.save(saveEntity);
        var resDto = estanteriaMapper.toDto(resEntity, new CycleAvoidingMappingContext());
        return resDto;
    }

    @Override
    public void deleteById(long id) {
        estanteriaRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        estanteriaRepository.deleteAll();
    }

}
