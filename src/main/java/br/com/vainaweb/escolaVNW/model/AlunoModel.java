package br.com.vainaweb.escolaVNW.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolaVNW.dto.DadosAtualizadosAluno;
import br.com.vainaweb.escolaVNW.dto.DadosRetornadosAluno;
import br.com.vainaweb.escolaVNW.dto.EnderecoDTO;
import br.com.vainaweb.escolaVNW.enums.Curso;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_alunos" )

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoModel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(unique = true)
	@Email
	private String email;
	
	@Column(unique = true)
	@CPF
	private String cpf;

	private String telefone;

	private Curso curso;
	
	@Embedded
	private Endereco endereco;
	
	// |------------------------------------------CONSTRUTORES--------------------------------------|
	public AlunoModel(String nome, String email, String cpf, String telefone, Curso curso, EnderecoDTO endereco) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.curso = curso;
		this.endereco = new Endereco(endereco.cep(), endereco.logradouro(), endereco.bairro(), endereco.cidade(), endereco.complemento(), endereco.numero());
	}

	//|------------------------------------------- MÉTODOS --------------------------------|

	public void atualizarInfo(@Valid DadosAtualizadosAluno dados) {
		this.nome = dados.nome() != null ? dados.nome() : this.nome;
		this.email = dados.email()!= null ? dados.email() : this.email;
		this.telefone = dados.telefone() != null ? dados.telefone() : this.telefone;
	}
	
}