package br.com.cotiinformatica.entities;

import java.util.Date;

public class Tarefa {

	private Integer id;
	private String nome;
	private Date data;
	private String descricao;
	private Categoria Categoria;
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Categoria getCategoria() {
		return Categoria;
	}
	public void setCategoria(Categoria categoria) {
		Categoria = categoria;
	}
	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", nome=" + nome + ", data=" + data + ", descricao=" + descricao + ", Categoria="
				+ Categoria + "]";
	}
	
	
}
