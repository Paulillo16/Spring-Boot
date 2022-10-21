package com.backend.web;

import com.backend.model.enumeration.TiposAlmacen;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlmacenDto implements Serializable {
	private Long id;
	private String cliente;
	private TiposAlmacen tipo;
	private Integer tamanio;
	//private List<EstanteriaDto> estanteriaList;
}
