package br.com.vainaweb.escolaVNW.dto;

import br.com.vainaweb.escolaVNW.enums.Cargo;

public record DadosColaborador(String nome, String email, String cpf,  Cargo cargo, EnderecoDTO endereco) {

}
