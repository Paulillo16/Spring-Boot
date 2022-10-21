package com.backend.model.entity;

import com.backend.model.enumeration.TiposAlmacen;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "almacenes")
public class AlmacenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@GeneratedValue
	@Column(nullable = false, updatable = false)
	private UUID uuid;

	@Column(length = 50, nullable = false)
	private String cliente;

	@Column(length = 3, nullable = false)
	@Enumerated(EnumType.STRING)
	private TiposAlmacen tipo;

	@Column(length = 3, nullable = false)
	private Integer tamanio;

	@OneToMany(mappedBy = "almacen")
	private List<EstanteriaEntity> estanteriaList;
}
