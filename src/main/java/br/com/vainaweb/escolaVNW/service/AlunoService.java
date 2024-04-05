package br.com.vainaweb.escolaVNW.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolaVNW.dto.DadosAluno;
import br.com.vainaweb.escolaVNW.model.AlunoModel;
import br.com.vainaweb.escolaVNW.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	public List<AlunoModel> encontrarTodos() {
		return repository.findAll();
	}

	public String cadastrar(DadosAluno dados) {
		repository.save(new AlunoModel(dados.nome(), dados.email(), dados.cpf(), dados.telefone(), dados.curso(), dados.endereco()));
		return "Aluno Cadastrado com Sucesso!";
	}

}
