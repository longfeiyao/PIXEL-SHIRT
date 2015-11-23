package com.pixel.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pixel.entities.Client;
import com.pixel.entities.Utilisateur;
import com.pixel.form.ConnexionForm;
import com.pixel.sessions.ClientDAO;
import com.pixel.sessions.PanierBean;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
	private static final String VUE = "/WEB-INF/connexion.jsp";
	
	@EJB
    ClientDAO user;
	
    public ConnexionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnexionForm connexion = new ConnexionForm(user);
		Utilisateur utilisateur = connexion.connexionUtilisateur(request);
		
        if(connexion.getErreurs().isEmpty()){
        	HttpSession session = request.getSession(true);
    		PanierBean panier = (PanierBean) session.getAttribute(AccueilServlet.KEY_SESSION_BEAN);
        	panier.fusion(((Client) utilisateur).getPanier());
        	response.sendRedirect("Articles");
        }else{
        	request.setAttribute( ATT_FORM, connexion );
            request.setAttribute( ATT_USER, utilisateur );
        	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}
	}

}
