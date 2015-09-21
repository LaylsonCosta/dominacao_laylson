package br.com.laylson.dominacao.controller;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home.do")
public class HomeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	//	String uri = req.getRequestURI();
	/*HttpSession session = req.getSession(false);

		if (session != null) {*/
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);;
		/*} else {

			req.getRequestDispatcher("login.html").forward(req, resp);
		}*/
	}
}
