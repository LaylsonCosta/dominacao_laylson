package br.com.laylson.dominacao;

import java.util.List;

import br.com.laylson.dominacao.persistencia.entidade.Usuario;
import br.com.laylson.dominacao.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	private static Usuario autenticar;
	public static void main(String[] args) {
		//testeCadastrar();
		//testeSalvar();
		//testeBuscarTodos();
		testeAutenticar();
	}
	private static void testeAutenticar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario.setLogin("laylson");
		usuario.setSenha("laylson123");
		
		Usuario usuRetorno = usuarioDAO.autenticar(usuario);
		System.out.println(usuRetorno);
		
	}
	private static void testeBuscarPorId() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorId(1);
		System.out.println(usuario);
		
	}
	
	private static void testeBuscarTodos() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> lista = usuarioDAO.buscarTodos();
		for (Usuario u: lista){
		System.out.println(u);
		}
	}
	
	public static void testeAlterar(){
		//Alterando Usuário
		Usuario usu = new Usuario();
		usu.setId(4);
		usu.setNome("");
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
		usu.setNome("laylson");
		usu.setLogin("laylson");
		usu.setSenha("laylson123");
		
		//Cadastrando usuário no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
		
		System.out.println("Cadatrado com Sucesso!!");
		
		
	}
	public static void testeDeletar(){
		//defininso Usuário a ser deletado
		Usuario usu = new Usuario();
		usu.setId(1);
		
		//Deletando usuário no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.deletar(usu);
		
		System.out.println("Deletado com Sucesso!!");
		
		
	}
	public static void testeSalvar(){
		Usuario usu = new Usuario();
		//usu.setId(5);
		usu.setNome("testedoSalvar");
		usu.setLogin("testedoSalvarLogin");
		usu.setSenha("testedoSalvar123");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usu);
		
		System.out.println("Salvo com sucesso!!!");
	}
	
	
}
