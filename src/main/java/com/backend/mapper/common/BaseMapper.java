package com.backend.mapper.common;

import org.mapstruct.Context;

import java.util.List;


public interface BaseMapper<E,D> {

    E toEntity(D dto, @Context CycleAvoidingMappingContext context);

    D toDto (E entiy, @Context CycleAvoidingMappingContext context);

    List<E> toListEntity (List<D> dto, @Context CycleAvoidingMappingContext context);

    List<D> toListDto (List<E> entiy, @Context CycleAvoidingMappingContext context);

}
