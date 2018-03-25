package com.serverWebChatAppBouchon.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Post_Request")
public class Post_Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Post_Request() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// récupération des paramètres
		String pseudo = request.getParameter("pseudo");
		String contact = request.getParameter("contact");
		String message = request.getParameter("message");

		// création d'une réponse au message envoyé
		String reponse = "Je te fais une réponse générique si cela ne te dérange pas.";

		// association des variables créées à la requête
		request.setAttribute("pseudo", pseudo);
		request.setAttribute("contact", contact);
		request.setAttribute("message", message);
		request.setAttribute("reponse", reponse);

		getServletContext().getRequestDispatcher("/WEB-INF/Post_Request.jsp").forward(request, response);
	}
}
