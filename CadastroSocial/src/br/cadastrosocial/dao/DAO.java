package br.cadastrosocial.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/*Essa classe responsavel por salvar algo ela busca a entity
 * se existir ela usa a mesma caso não tenha ela cria nova*/
public class DAO 
{
	  
	private EntityManager em = null;
	
	public DAO()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadSocialJPA");
		if(em == null)
			em = emf.createEntityManager();
	}
	
	public EntityManager getEntity() 
	{
		return em;
	}
	
	
}
