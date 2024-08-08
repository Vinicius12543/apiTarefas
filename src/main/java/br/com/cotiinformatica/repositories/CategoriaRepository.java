package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cotiinformatica.entities.Categoria;
import br.com.cotiinformatica.factories.ConnectionFactory;

/*
 * Classe de repositório de banco de dados para CRUD na tabela de categoria
 */
public class CategoriaRepository {

	/*
	 * Método para cadastrar uma categoria
	 */
	public void insert(Categoria categoria) throws Exception {

		// abrir conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();

		// executando um comando SQL no banco de dados
		PreparedStatement statement = connection.prepareStatement("INSERT INTO categoria(nome) VALUES(?)");
		statement.setString(1, categoria.getNome());
		statement.execute();

		// fechando a conexão com o banco de dados
		connection.close();
	}

	public void update(Categoria categoria) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("UPDATE categoria SET nome=? WHERE id=?");
		statement.setString(1, categoria.getNome());
		statement.setInt(1, categoria.getId());

		connection.close();

	}

	public void delete(Integer id) throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("DELETE FROM categoria WHERE id=?");
		statement.setInt(1, id);
		statement.execute();

		connection.close();
	}

	public List<Categoria> getAll() throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("SELECT * FROM categoria");
		ResultSet resultSet = statement.executeQuery(); // executando a consulta e trazendo os registos

		List<Categoria> lista = new ArrayList<>();

		while (resultSet.next()) {

			Categoria categoria = new Categoria();
			categoria.setId(resultSet.getInt("id"));
			categoria.setNome(resultSet.getString("nome"));

			lista.add(categoria);

		}

		connection.close();

		return lista;
	}

	public Categoria getByid(Integer id) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("SELECT * FROM categoria WHERE id=?");
		statement.setInt(1, id);
		
		Categoria categoria = null;
		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			categoria = new Categoria();
			categoria.setId(resultSet.getInt("id"));
			categoria.setNome(resultSet.getString("nome"));
		}
		
		connection.close();
		
		return categoria;

	}
}
