package com.backend.web;

import com.backend.model.enumeration.TiposEstanteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstanteriaDto {

	private long id;
	private AlmacenDto almacen;
	private TiposEstanteria tipo;

}
