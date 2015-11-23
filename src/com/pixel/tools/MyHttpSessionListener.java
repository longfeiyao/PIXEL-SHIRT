package com.pixel.tools;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.pixel.servlets.AccueilServlet;
import com.pixel.sessions.PanierBean;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session =event.getSession();
		try {
			PanierBean panier = (PanierBean) new InitialContext().lookup("java:global/Pixel_Shirt/PanierBean");
			session.setAttribute(AccueilServlet.KEY_SESSION_BEAN, panier);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		System.out.println("session créée");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("session destroy");
		PanierBean panier=(PanierBean) event.getSession().getAttribute(AccueilServlet.KEY_SESSION_BEAN);
		if(panier != null){
			panier.update();
			panier.remove();
		}
	}

}
