package br.com.ufpb.labs2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufpb.labs2.Entity.Disciplinas;
import br.com.ufpb.labs2.service.DisciplinasService;

@RestController
@RequestMapping("/v1/api")
public class DisciplinasController {
	
	@Autowired
	DisciplinasService service;
	
	@GetMapping("/disciplinas")
	public ResponseEntity<List<Disciplinas>> getAll() {
		return ResponseEntity.ok().body(service.getListaDasDisciplinas());

	}
	
	@PostMapping("/disciplinas")
	public ResponseEntity<Disciplinas> adionarDisciplina(@RequestBody Disciplinas disciplina) {
		return new ResponseEntity<Disciplinas>(service.addDisciplinas(disciplina), HttpStatus.CREATED);

	}
	
	@PutMapping("/disciplinas/{id}/nota")
	public ResponseEntity<Disciplinas> atualizanota(@PathVariable int id, @RequestBody Disciplinas disciplina) {
		try {
		return ResponseEntity.ok().body(service.atualizarLNota( disciplina , id));
		} catch (Exception e) {

			return new ResponseEntity<Disciplinas>(new Disciplinas(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/disciplinas/{id}/like")
	public ResponseEntity<Disciplinas> atualizalike(@PathVariable int id, @RequestBody Disciplinas disciplina) {
		try {
		return ResponseEntity.ok().body(service.atualizarLikes( disciplina , id));
		} catch (Exception e) {

			return new ResponseEntity<Disciplinas>(new Disciplinas(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/disciplinas/rankNota")
	public ResponseEntity<List<Disciplinas>> ranknota() {
		return ResponseEntity.ok().body(service.rankNotas());

	}
	
	
	@GetMapping("/disciplinas/ranklikes")
	public ResponseEntity<List<Disciplinas>> ranklike() {
		return ResponseEntity.ok().body(service.rankLikes());

	}
	

}
