package com.pixel.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pixel.entities.Article;
import com.pixel.sessions.ArticleDAO;
import com.pixel.sessions.PanierBean;

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
		HttpSession session = request.getSession(true);
		PanierBean panier = (PanierBean) session.getAttribute(AccueilServlet.KEY_SESSION_BEAN);
		if(panier == null){
			try {
				panier = (PanierBean) new InitialContext().lookup("java:global/Pixel_Shirt/PanierBean");
				session.setAttribute(AccueilServlet.KEY_SESSION_BEAN, panier);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		String quantites = (String) request.getParameter("quantite");
		int quantite = Integer.parseInt(quantites);
		
		String articleid = request.getParameter("article_id");
		Article article = articleDao.findById(articleid);
		
		if(article.getQuantite()-quantite>=0){
			article.setQuantite(article.getQuantite()-quantite);
			articleDao.update(article);
			panier.addArticle(article, quantite);
		}
		
		List<?> articles = articleDao.findAll();
		request.setAttribute( ATT_ART, articles );
		getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
