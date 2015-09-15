package br.com.laylson.dominacao.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.laylson.dominacao.persistencia.entidade.Usuario;

public class UsuarioDAO {
	private Connection con = ConectionFactory.getConnection();
	
	public void cadastrar(Usuario usu) {
		String sql = "INSERT INTO usuario (nome, login, senha)VALUES(?,?,?)";
		
		try {
			//Criando um Statment
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			//Executando o comando SQL no banco
			preparador.execute();
			//Encerrando o objeto preparador
			preparador.close();
			
		} catch (SQLException e) {
			e.getStackTrace();
		
		}
		
		
	}

	public void alterar(Usuario usu) {
		String sql = "UPDATE usuario set nome=?, login=?, senha=? where id=?";
	
		try {
			//Criando um Statment
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			//Executando o comando SQL no banco
			preparador.execute();
			//Encerrando o objeto preparador
				preparador.close();
				
			} catch (SQLException e) {
				e.getStackTrace();
			}
		
	
	}

	public void deletar(Usuario usu) {
		String sql = "DELETE FROM usuario WHERE id=?";
		
		try {
			//Criando um Statment
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, usu.getId());
			//Executando o comando SQL no banco
			preparador.execute();
			//Encerrando o objeto preparador
				preparador.close();
				
			} catch (SQLException e) {
				e.getStackTrace();

			}
		
	}
		
	

}
