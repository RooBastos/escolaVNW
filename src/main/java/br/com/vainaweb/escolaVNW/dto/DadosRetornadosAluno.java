package br.com.vainaweb.escolaVNW.dto;

import br.com.vainaweb.escolaVNW.enums.Curso;

public record DadosRetornadosAluno (String nome, String email, Curso curso) {
    
}
