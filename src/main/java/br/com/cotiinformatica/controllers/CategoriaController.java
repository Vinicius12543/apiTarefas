package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.CategoriaDto;
import br.com.cotiinformatica.entities.Categoria;
import br.com.cotiinformatica.repositories.CategoriaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@PostMapping
	public String post(@RequestBody @Valid CategoriaDto dto) throws Exception {

		// capturando o nome da categoria
		Categoria categoria = new Categoria();
		categoria.setNome(dto.getNome());

		// gravando a categoria no banco de dados
		CategoriaRepository categoriaRepository = new CategoriaRepository();
		categoriaRepository.insert(categoria);

		// resposta de sucesso
		return "Categoria " + dto.getNome() + " cadastrada com sucesso.";
	}

	@PutMapping("{id}")
	public String put(@PathVariable Integer id, @RequestBody @Valid CategoriaDto dto) throws Exception {

		CategoriaRepository categoriaRepository = new CategoriaRepository();
		Categoria categoria = categoriaRepository.getByid(id);

		if (categoria == null)
			return "Categoria não encontrada, por favor verifique o ID!";

		categoria.setNome(dto.getNome());
		categoriaRepository.update(categoria);

		return "Categoria editada com sucesso";
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable Integer id) throws Exception {

		CategoriaRepository categoriaRepository = new CategoriaRepository();
		Categoria categoria = categoriaRepository.getByid(id);

		if (categoria == null)
			return "Categoria não encontrada, por favor verifique o ID";

		categoriaRepository.delete(id);
		return "Categoria apagada com sucesso";

	}

	@GetMapping
	public List<Categoria> getAll() throws Exception {

		CategoriaRepository categoriaRepository = new CategoriaRepository();
		List<Categoria> lista = categoriaRepository.getAll();

		return lista;

	}

	@GetMapping("{id}")
	public Categoria getById(@PathVariable Integer id) throws Exception {

		CategoriaRepository categoriaRepository = new CategoriaRepository();
		Categoria categoria = categoriaRepository.getByid(id);

		return categoria;

	}
}
