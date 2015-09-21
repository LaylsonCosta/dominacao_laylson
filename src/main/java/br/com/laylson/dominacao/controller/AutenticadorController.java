package br.com.laylson.dominacao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.laylson.dominacao.persistencia.entidade.Usuario;
import br.com.laylson.dominacao.persistencia.jdbc.UsuarioDAO;

@WebServlet("/autenticador.do")
public class AutenticadorController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);//qnd especifica o parâmetro 'false' a sessão é acessada porém não é criada
		
		if(session != null){
			session.invalidate();			
		}
	
		resp.sendRedirect("login.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1) Capturando dados da tela (login e senha)
		String login = req.getParameter("login");
		String senha  = req.getParameter("senha");
		//2) Colocando os dados capturados em um objeto Usuario
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		//3) Consultando se existe no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario usuAutenticado = usuDAO.autenticar(usuario);
		//4) Verificando se existe cadastro para o login e senha apresentados
		if(usuAutenticado != null){
			//5) Atribuindo a sessão para o usuário
			HttpSession sessao = req.getSession();
			sessao.setAttribute("usuAutenticado", usuAutenticado);
			//6) Definindo intervado de inatividade para a sessão (em segundos)
			sessao.setMaxInactiveInterval(60*5);
			//7) Redirecionando usuário para a tela princial
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
		}else{
			//8) Caso não exista cadastro para o login apresentado é mostrando um alerta e o 
			//usuário é redirecionado para o tela de login novamente
			resp.getWriter().print("<script> window.alert('não encontrado!'); location.href='login.html'</script>");
		}
		 
		
		
	}

}
