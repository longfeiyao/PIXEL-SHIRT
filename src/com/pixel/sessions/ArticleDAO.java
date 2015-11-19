package com.pixel.sessions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.pixel.entities.Article;
import com.pixel.exceptions.DAOException;
import com.pixel.tools.SortMap;

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
	
	public Article findById(String Id){
		Article article = null;
		Long id = Long.parseLong(Id);
		try {
			article = (Article) em.find(Article.class, id);
		} catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
		return article;
	}
	
	public List<Article> findByTag(List<String> tags){
		List<Article> articles = null;
		Map<Article, Integer> articleMap = new HashMap<>();
		TypedQuery<Article> query = em.createQuery(JPQL_SELECT_BASE+" WHERE :tag IN (a.tags)",Article.class);
		for(String tag : tags){
			query.setParameter("tag", tag);
			try {
				articles= query.getResultList();
				for(Article article : articles){
					System.out.println("article id: " + article.getId());
					Integer nbTag = articleMap.get(article);
					System.out.println("article nbTag: " + nbTag);
					if(nbTag != null){
						articleMap.put(article,nbTag+1);
					}else{
						articleMap.put(article,1);
					}
				}
			}catch ( Exception e ) {
	            throw new DAOException( e );
	        }
		}
		articles = SortMap.sortMap(articleMap);
		//System.out.println("article list: " + articles.size());
		return articles;
	}
	
	public Article update(Article article){
		return em.merge(article);
	}

}
