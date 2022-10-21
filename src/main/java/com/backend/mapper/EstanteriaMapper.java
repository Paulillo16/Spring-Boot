package com.backend.mapper;

import com.backend.mapper.common.BaseMapper;
import com.backend.model.entity.EstanteriaEntity;
import com.backend.web.EstanteriaDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true),
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = {EstanteriaMapper.class})
public interface EstanteriaMapper extends BaseMapper<EstanteriaEntity, EstanteriaDto> {
}
