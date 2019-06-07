package br.cadastrosocial.dao;

import javax.persistence.EntityManager;

public class CrudDao 
{
	private EntityManager em;
	
	public CrudDao() 
	{
		DAO dao = new DAO();
		em = dao.getEntity();
	}
	
	public <T> void save(T model) 
	{
		try 
		{
			em.getTransaction().begin();
			em.persist(model);
			em.getTransaction().commit();
		} catch (Exception e) 
		{
			em.getTransaction().rollback();
		}finally 
		{
			em.close();
		}
	}
	
	public <T> void delete(T model)
	{
		try 
		{
			em.getTransaction().begin();
			em.remove(model);
			em.getTransaction().commit();
		} catch (Exception e) 
		{
			em.getTransaction().rollback();
		}finally 
		{
			em.close();
		}
	}
	
	public <T> void edit (T model) 
	{
		try 
		{
			em.getTransaction().begin();
			em.merge(model);
			em.getTransaction().commit();
		} catch (Exception e) 
		{
			em.getTransaction().rollback();
		}finally 
		{
			em.close();
		}
	}
	
	
}
