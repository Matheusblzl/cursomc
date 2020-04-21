package com.maiconsantos.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.maiconsantos.cursomc.domain.Categoria;
import com.maiconsantos.cursomc.repositories.CategoriaRepository;
import com.maiconsantos.cursomc.services.exception.DataIntegrityException;
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

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepositoryrepository.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return categoriaRepositoryrepository.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			categoriaRepositoryrepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}

	public List<Categoria> findAll() {
		return categoriaRepositoryrepository.findAll();
	}
}
