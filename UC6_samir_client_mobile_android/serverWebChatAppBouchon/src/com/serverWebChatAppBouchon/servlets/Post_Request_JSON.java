package com.serverWebChatAppBouchon.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Post_Request_JSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Post_Request_JSON() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// récupération du paramètre Json object - METHODE 1
		// String paramJson = request.getParameter("jso");
		// JSONObject obj;
		// try {
		// obj = new JSONObject(paramJson);
		// String pseudo = obj.getString("pseudo");
		// request.setAttribute("pseudo", pseudo);
		// } catch (JSONException e1) {
		// // TODO Auto-generated catch block e1.printStackTrace();
		// }

		// récupération du paramètre Json object - METHODE 2
		// JSONObject obj = new JSONObject();
		// try {
		// JSONObject newObj = obj.getJSONObject(request.getParameter("jso"));
		// String pseudo = newObj.getString("pseudo");
		// request.setAttribute("pseudo", pseudo);
		// } catch (JSONException e) {
		// // TODO Auto-generated catch block e.printStackTrace();
		// }

		// création d'une réponse au message envoyé
		String reponse = "Je te fais une réponse générique pour vérifier que la requête HTTP POST avec paramètres en JSON, et son retour, fonctionnent correctement.";
		// association du message à la requête
		request.setAttribute("reponse", reponse);

		getServletContext().getRequestDispatcher("/WEB-INF/Post_Request_JSON.jsp").forward(request, response);
	}
}
