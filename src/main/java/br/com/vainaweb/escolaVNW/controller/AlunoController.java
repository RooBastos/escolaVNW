package br.com.vainaweb.escolaVNW.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolaVNW.dto.DadosAluno;
import br.com.vainaweb.escolaVNW.dto.DadosAtualizadosAluno;
import br.com.vainaweb.escolaVNW.model.AlunoModel;
import br.com.vainaweb.escolaVNW.repository.AlunoRepository;
import br.com.vainaweb.escolaVNW.service.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno")

public class AlunoController {
    
	@Autowired
	private AlunoService service;
	
	@Autowired
	private AlunoRepository repository;


	@GetMapping
	public List<AlunoModel> listarTodosAlunos() {
		return service.encontrarTodos();
	}
	
	// @GetMapping("/{id}")
	// public ResponseEntity<AlunoModel> listarPorId(@PathVariable Long id) {
	// 	ResponseEntity<AlunoModel> response = repository.findById(id)
	// 			.map( resposta -> ResponseEntity.ok(resposta))
	// 			.orElse(ResponseEntity.notFound().build());
	// 	return response;
	// }

	@PostMapping
	public String cadastrar(@RequestBody DadosAluno dados) {
		return service.cadastrar(dados);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizadosAluno dados) {
		var aluno = repository.getReferenceById(id);
		aluno.atualizarInfo(dados);
		repository.save(aluno);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id) {
		repository.deleteById(id);
		return "Deletado";
	}
}
