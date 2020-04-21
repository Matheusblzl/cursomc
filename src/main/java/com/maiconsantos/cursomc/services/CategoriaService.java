package com.maiconsantos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiconsantos.cursomc.domain.Categoria;
import com.maiconsantos.cursomc.repositories.CategoriaRepository;
import com.maiconsantos.cursomc.services.exception.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepositoryrepository;


	public Categoria find(Integer id) {
		Optional<Categoria> obj = categoriaRepositoryrepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
