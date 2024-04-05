package br.com.vainaweb.escolaVNW.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolaVNW.dto.DadosAtualizadosColaborador;
import br.com.vainaweb.escolaVNW.dto.EnderecoDTO;
import br.com.vainaweb.escolaVNW.enums.Cargo;
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
@Table(name = "tb_colaboradores" )

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorModel {
	

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
	private Cargo cargo;
	
	@Embedded
	private Endereco endereco;
	
	// |------------------------------------------CONSTRUTORES--------------------------------------|
	public ColaboradorModel(String nome, String email, String cpf, Cargo cargo, EnderecoDTO endereco) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.cargo = cargo;
		this.endereco = new Endereco(endereco.cep(), endereco.logradouro(), endereco.bairro(), endereco.cidade(), endereco.complemento(), endereco.numero());
	}

	//|------------------------------------------- MÉTODOS --------------------------------|

	public void atualizarInfo(@Valid DadosAtualizadosColaborador dados) {
		this.nome = dados.nome() != null ? dados.nome() : this.nome;
		this.email = dados.email()!= null ? dados.email() : this.email;
	}
	
}