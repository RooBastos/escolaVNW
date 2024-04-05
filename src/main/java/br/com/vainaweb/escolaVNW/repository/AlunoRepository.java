package br.com.vainaweb.escolaVNW.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vainaweb.escolaVNW.model.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository <AlunoModel, Long> {
	
	Optional<AlunoModel> findByCpf(String cpf);
	
	Optional<AlunoModel> findByID(Long ID);
	
}
