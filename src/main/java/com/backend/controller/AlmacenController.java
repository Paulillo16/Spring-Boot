package com.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.backend.repository.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.entity.Almacen;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AlmacenController {

	@Autowired
	AlmacenRepository almacenRepository;

	@GetMapping("/almacenes")
	public ResponseEntity<List<Almacen>> getAlmacenes() {
		try {
			List<Almacen> almacenesList = new ArrayList<Almacen>();
			almacenRepository.findAll().forEach(almacenesList::add);

			if (almacenesList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(almacenesList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/almacenes/{id}")
	public ResponseEntity<Almacen> getAlmacenById(@PathVariable("id") long id) {
		Optional<Almacen> optionalAlmacen = almacenRepository.findById(id);

		if (optionalAlmacen.isPresent()) {
			return new ResponseEntity<>(optionalAlmacen.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/almacenes")
	public ResponseEntity<Almacen> create(@RequestBody Almacen almacen) {
		try {
			Almacen almacenNew = new Almacen();
			almacenNew.setCliente(almacen.getCliente());
			almacenNew.setTipo(almacen.getTipo());
			almacenNew.setTamanio(almacen.getTamanio());
			Almacen _almacen = almacenRepository.save(almacenNew);
			return new ResponseEntity<>(_almacen, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/almacenes/{id}")
	public ResponseEntity<Almacen> update(@PathVariable("id") long id, @RequestBody Almacen almacen) {
		Optional<Almacen> optionalAlmacen = almacenRepository.findById(id);

		if (optionalAlmacen.isPresent()) {
			Almacen _almacen = optionalAlmacen.get();
			_almacen.setCliente(almacen.getCliente());
			_almacen.setTipo(almacen.getTipo());
			_almacen.setTamanio(almacen.getTamanio());
			_almacen.setEstanteriaList(almacen.getEstanteriaList());
			return new ResponseEntity<>(almacenRepository.save(_almacen), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/almacenes/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		try {
			almacenRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/almacenes")
	public ResponseEntity<HttpStatus> deleteAll() {
		try {
			almacenRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
