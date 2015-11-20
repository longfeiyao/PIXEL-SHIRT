package com.pixel.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
        // TODO Auto-generated constructor stub
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
		
		request.setAttribute( ATT_FORM, connexion );
        request.setAttribute( ATT_USER, utilisateur );
        if(connexion.getErreurs().isEmpty()){
        	HttpSession session = request.getSession(true);
    		PanierBean panier = (PanierBean) session.getAttribute(AccueilServlet.KEY_SESSION_BEAN);
        	if(panier !=null){
        		panier.fusion(((Client) utilisateur).getPanier());
        	}else{
        		try {
					panier = (PanierBean) new InitialContext().lookup("java:global/Pixel_Shirt/PanierBean");
					panier.fusion(((Client) utilisateur).getPanier());
				} catch (NamingException e) {
					e.printStackTrace();
				}
				session.setAttribute(AccueilServlet.KEY_SESSION_BEAN, panier);
        	}
    		response.sendRedirect("Articles");
        }else{
        	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}
	}

}
