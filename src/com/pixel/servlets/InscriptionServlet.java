package com.pixel.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pixel.entities.Utilisateur;
import com.pixel.form.InscriptionForm;
import com.pixel.sessions.ClientDAO;
import com.pixel.sessions.PanierBean;

/**
 * Servlet implementation class Inscription
 */
@WebServlet(urlPatterns = {"/Inscription"})
public class InscriptionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
	private static final String VUE = "/WEB-INF/inscription.jsp";
	
	@EJB
    private ClientDAO user;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
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
		
		HttpSession session = request.getSession(true);
		PanierBean panier = (PanierBean) session.getAttribute(AccueilServlet.KEY_SESSION_BEAN);
		
		InscriptionForm form = new InscriptionForm( user );
        /* Traitement de la requête et récupération du bean en résultant */
		
        Utilisateur utilisateur = form.inscrireUtilisateur( request, panier);

        /* Stockage du formulaire et du bean dans l'objet request */

        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
