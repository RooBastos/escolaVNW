package br.com.vainaweb.escolaVNW.dto;

import br.com.vainaweb.escolaVNW.enums.Curso;

public record DadosAluno(String nome, String email, String cpf, String telefone, Curso curso, EnderecoDTO endereco) {

}
