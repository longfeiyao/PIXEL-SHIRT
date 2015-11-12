package com.pixel.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.pixel.sessions.ArticleDAO;

/**
 * Servlet implementation class AffichageArticleServlet
 */
@WebServlet("/Articles")
public class AffichageArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/afficherArticles.jsp";  
	private static final String ATT_ART= "listeArticles";
	
	@EJB
	private ArticleDAO articleDao;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageArticleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<?> articles = articleDao.findAll();
		request.setAttribute( ATT_ART, articles );
		getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
