package com.backend.model.entity;

import com.backend.model.enumeration.TiposAlmacen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "almacenes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Almacen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@GeneratedValue(generator = "UUID")
	@Column(columnDefinition = "UUID", length = 36, nullable = false)
	private UUID uuid;

	@Column(length = 50, nullable = false)
	private String cliente;

	@Column(length = 3, nullable = false)
	@Enumerated(EnumType.STRING)
	private TiposAlmacen tipo;

	@Column(length = 3, nullable = false)
	private Integer tamanio;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "almacen")
	private List<Estanteria> estanteriaList;

}
