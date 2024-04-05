package br.com.vainaweb.escolaVNW.controller;

import java.util.List;

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

import br.com.vainaweb.escolaVNW.dto.DadosColaborador;
import br.com.vainaweb.escolaVNW.model.ColaboradorModel;
import br.com.vainaweb.escolaVNW.repository.ColaboradorRepository;
import br.com.vainaweb.escolaVNW.service.ColaboradorService;
import br.com.vainaweb.escolaVNW.dto.DadosAtualizadosColaborador;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/colaborador")


public class ColaboradorController {

	@Autowired
	private ColaboradorService service;
	
	@Autowired
	private ColaboradorRepository repository;

	@GetMapping
	public List<ColaboradorModel> listarTodosColaboradores() {
		return service.encontrarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ColaboradorModel> listarPorId(@PathVariable Long id) {
		var response = repository.findById(id)
				.map( resposta -> ResponseEntity.ok(resposta) )
				.orElse(ResponseEntity.notFound().build());
		return response;
	}

	@PostMapping
	public String cadastrar(@RequestBody DadosColaborador dados) {
		return service.cadastrar(dados);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizadosColaborador dados) {
		var colaborador = repository.getReferenceById(id);
		colaborador.atualizarInfo(dados);
		repository.save(colaborador);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id) {
		repository.deleteById(id);
		return "Deletado";
	}
}
