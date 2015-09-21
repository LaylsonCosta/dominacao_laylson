package br.com.laylson.dominacao.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import br.com.laylson.dominacao.persistencia.entidade.Usuario;
import br.com.laylson.dominacao.persistencia.jdbc.UsuarioDAO;

//http://localhost:8080/dominacao/usucontroller.do
@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {

	public UsuarioController() {
		System.out.println("Construtor!");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		String acao = req.getParameter("acao");
		if (acao.equals("exc")) {
			String id = req.getParameter("id");
			Usuario usu = new Usuario();
			if (id != null)
				usu.setId(Integer.parseInt(id));

			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.deletar(usu);

			resp.sendRedirect("usucontroller.do?acao=lis");
		
		
		} else if (acao.equals("lis")) {
			//Implementar a lista
			UsuarioDAO usuDAO = new UsuarioDAO();
			List<Usuario> lista = usuDAO.buscarTodos();
			
			//preenchendo uma 'gaveta' do request com uma lista em forma de objeto
			//rotulando essa 'gaveta' como 'lista' 
			req.setAttribute("lista", lista);
			
			//encaminhando o request preenchido para o JSP
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/listausu.jsp");
			dispatcher.forward(req, resp);
		
		
		}else if (acao.equals("alt")){
			
			String id = req.getParameter("id");
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = usuarioDAO.buscarPorId(Integer.parseInt(id));
			
			req.setAttribute("usu", usuario);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/frmUsuario.jsp");
			dispatcher.forward(req, resp);
			
			
		}else if(acao.equals("cad")){
			
			Usuario usuario = new Usuario();
			usuario.setId(0);
			usuario.setNome("");
			usuario.setLogin("");
			usuario.setSenha("");
			
			req.setAttribute("usu", usuario);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/frmUsuario.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Usuario usu = new Usuario();
		if (id != null)
			usu.setId(Integer.parseInt(id));
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usu);

		resp.sendRedirect("usucontroller.do?acao=lis");
		// System.out.println("Cadastrado com sucesso!!");
	}

	@Override
	public void init() throws ServletException {
		
		System.out.println("init...");
		super.init();
	}

}
