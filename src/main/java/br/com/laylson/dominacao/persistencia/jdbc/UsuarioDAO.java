package br.com.laylson.dominacao.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		
	public void salvar(Usuario usu){
		if (usu.getId()!=null && usu.getId()!=0){
			alterar(usu);
		}else {
			cadastrar(usu);
			
		}
		
	}
	/**
	 * Busca de um registro no banco de dados pelo numero do id do usuário
	 * @param id é um inteiro que reprensenta o número do id do usuário a ser buscado
	 * @return Um objeto usuário quando encontra ou null quando não encontra
	 */
	public Usuario buscarPorId(Integer id){
		String sql = "select * from usuario where id =?";
		
		try(PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			//posicionado cursos no primeiro registro
			if(resultado.next()){//mesma coisa que: if(resultado.next()==true);
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
				return usuario;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * Realiza a busca de todos resgristros da tabela de usuário
	 * @return Uma lista de objetos Usuario contendo 0 elementos quando não tiver registro
	 * ou n elementos quando tiver resultado
	 */
	
	
	public java.util.List<Usuario> buscarTodos(){
		
		String sql = "select * from usuario order by id";
		java.util.List<Usuario> lista = new ArrayList<Usuario>();
		try(PreparedStatement pst = con.prepareStatement(sql)){
			
			ResultSet resultado = pst.executeQuery();
			//posicionado cursos no primeiro registro
			while(resultado.next()){//mesma coisa que: while(resultado.next()==true);
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				//Adicionando usuario na lista
				lista.add(usuario);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return lista;
		
	}
	
	public Usuario autenticar(Usuario usuConcuslta){
		
		String sql = "select * from usuario where login=? and senha=?";
		
		try(PreparedStatement pst = con.prepareStatement(sql)){
			pst.setString(1, usuConcuslta.getLogin());
			pst.setString(2, usuConcuslta.getSenha());
			ResultSet resultado = pst.executeQuery();
			
			if(resultado.next()){
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
				return usuario;
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
}
