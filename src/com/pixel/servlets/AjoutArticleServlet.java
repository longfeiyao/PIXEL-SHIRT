package com.pixel.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pixel.entities.Article;
import com.pixel.form.ArticleForm;
import com.pixel.sessions.ArticleDAO;

/**
 * Servlet implementation class AjoutArticle
 */
@WebServlet("/Admin/AjoutArticle")
public class AjoutArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_ARTICLE = "article";
    public static final String ATT_FORM = "form";
	private static final String VUE = "/WEB-INF/ajout_article.jsp"; 
    
	@EJB
	private ArticleDAO articleDao;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutArticleServlet() {
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
		
		ArticleForm form = new ArticleForm(articleDao);
		Article article = form.addArticle(request);
		
		request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_ARTICLE, article );
		getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
