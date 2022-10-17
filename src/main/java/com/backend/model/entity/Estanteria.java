package com.backend.model.entity;

import com.backend.model.enumeration.TiposEstanteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "estanterias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estanteria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JoinColumn(name = "almacen_id", nullable = false)
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Almacen almacen;

	@GeneratedValue(generator = "UUID")
	@Column(columnDefinition = "UUID", length = 36, nullable = false)
	private UUID uuid;

	@Column(length = 1, nullable = false)
	@Enumerated(EnumType.STRING)
	private TiposEstanteria tipo;

}
