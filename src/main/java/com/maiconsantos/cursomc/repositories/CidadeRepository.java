package com.maiconsantos.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maiconsantos.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
