package com.serverWebChatAppBouchon.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Post_Request_String extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Post_Request_String() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// création d'une réponse au message envoyé
		String reponse = "Je te fais une réponse générique pour vérifier que la requête HTTP POST avec paramètres en String, et son retour, fonctionnent correctement.";

		// association de la variable créée à la requête
		request.setAttribute("reponse", reponse);

		getServletContext().getRequestDispatcher("/WEB-INF/Post_Request_String.jsp").forward(request, response);
	}
}
