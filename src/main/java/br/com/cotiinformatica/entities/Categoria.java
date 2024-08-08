package br.com.cotiinformatica.entities;

import java.util.List;

public class Categoria {

	private Integer id;
	private String nome;

	public Categoria() {
		// TODO Auto-generated constructor stub
	}

	public Categoria(Integer id, String nome, List<Tarefa> tarefas) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}

}
