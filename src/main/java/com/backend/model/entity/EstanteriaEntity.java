package com.backend.model.entity;

import com.backend.model.enumeration.TiposEstanteria;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estanterias")
public class EstanteriaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "almacen_id", nullable = false)
	private AlmacenEntity almacen;

	@Column(columnDefinition = "UUID", length = 36, nullable = false)
	private UUID uuid;

	@Column(length = 1, nullable = false)
	@Enumerated(EnumType.STRING)
	private TiposEstanteria tipo;
}
