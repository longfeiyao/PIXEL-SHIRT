package com.pixel.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pixel.entities.Article;
import com.pixel.form.RechercheForm;
import com.pixel.sessions.ArticleDAO;

/**
 * Servlet implementation class RechercheServlet
 */
@WebServlet("/Recherche")
public class RechercheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/recherche.jsp";
	private static final String ATT_ART= "listeArticles";
	
	@EJB
	private ArticleDAO articleDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RechercheForm form = new RechercheForm();
		List<String> tags = form.getSearch(request);
		List<Article> listArticle = null;
		if(form.getErreurs().isEmpty()){
			listArticle=articleDao.findByTag(tags);
		}
		request.setAttribute( ATT_ART, listArticle );
		getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
