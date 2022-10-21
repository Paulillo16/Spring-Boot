package com.backend.web;

import com.backend.model.enumeration.TiposEstanteria;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstanteriaDto implements Serializable {
	private long id;
	private AlmacenDto almacen;
	private TiposEstanteria tipo;

}
