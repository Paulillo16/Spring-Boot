package com.backend.mapper;

import com.backend.mapper.common.BaseMapper;
import com.backend.model.entity.AlmacenEntity;
import com.backend.web.AlmacenDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true),
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = {AlmacenMapper.class})
public interface AlmacenMapper extends BaseMapper<AlmacenEntity, AlmacenDto> {
}
