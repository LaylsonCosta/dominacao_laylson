package br.com.laylson.dominacao;

import br.com.laylson.dominacao.persistencia.entidade.Usuario;
import br.com.laylson.dominacao.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		testeCadastrar();
		
	}
	public static void testeAlterar(){
		//Criando Usuário
		Usuario usu = new Usuario();
		usu.setId(4);
		usu.setNome("jaoalterado");
		usu.setLogin("jaologinalteradp");
		usu.setSenha("ja0123alterado");
		
		//Alterando usuário no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);
		
		System.out.println("Alterado com Sucesso!!");
		
		
	}
	public static void testeCadastrar(){
		//Criando Usuário
		Usuario usu = new Usuario();
		usu.setNome("jao");
		usu.setLogin("jaologin");
		usu.setSenha("ja0123");
		
		//Cadastrando usuário no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
		
		System.out.println("Cadatrado com Sucesso!!");
		
		
	}
	public static void testeDeletar(){
		//Criando Usuário
		Usuario usu = new Usuario();
		usu.setId(1);
		
		//Deletando usuário no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.deletar(usu);
		
		System.out.println("Deletado com Sucesso!!");
		
		
	}
}
