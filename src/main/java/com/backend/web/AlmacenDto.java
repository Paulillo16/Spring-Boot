package com.backend.web;

import com.backend.model.enumeration.TiposAlmacen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlmacenDto {

	private long id;
	private String cliente;
	private TiposAlmacen tipo;
	private Integer tamanio;
	private List<EstanteriaDto> estanteriaList;
}
