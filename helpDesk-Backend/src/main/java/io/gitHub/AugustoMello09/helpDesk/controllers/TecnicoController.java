package io.gitHub.AugustoMello09.helpDesk.controllers;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.gitHub.AugustoMello09.helpDesk.dto.TecnicoDTO;
import io.gitHub.AugustoMello09.helpDesk.services.TecnicoService;

@RestController
@RequestMapping(value = "tecnico")
public class TecnicoController {

	@Autowired
	private TecnicoService service;

	@GetMapping
	public String status() {
		return "ok";
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable UUID id) {
		var tecnico = service.findById(id);
		return ResponseEntity.ok().body(tecnico);
	}

	@PostMapping
	public ResponseEntity<TecnicoDTO> create(@RequestBody TecnicoDTO dto) {
		var newObj = service.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).body(newObj);
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> update(@RequestBody TecnicoDTO dto,@PathVariable UUID id){
		var newObj = service.updateEmail(dto, id);
		return ResponseEntity.ok().body(newObj);
	}

}