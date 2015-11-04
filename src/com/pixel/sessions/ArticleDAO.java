package com.pixel.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pixel.entities.Article;
import com.pixel.exceptions.DAOException;

@Stateless
public class ArticleDAO {
	
	@PersistenceContext( unitName = "bdd_pixel_shirt" )
    private EntityManager em;
	
	private static final String JPQL_SELECT_BASE = "SELECT a FROM Article a";
	
	
	public void creer(Article article){
		try {
            em.persist( article );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
	}
	
	public List<?> findAll(){
		List<?> list=null;
		Query query = em.createQuery(JPQL_SELECT_BASE);
		try {
			list= query.getResultList();
		} catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
		return list;	
	}
	
	public List<?> findByOption(String option){
		List<?> list=null;
		Query query = em.createQuery(JPQL_SELECT_BASE+" WHERE a."+option+":="+option);
		query.setParameter(option, option);
		try {
			list= query.getResultList();
		} catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
		return list;	
	}

}
