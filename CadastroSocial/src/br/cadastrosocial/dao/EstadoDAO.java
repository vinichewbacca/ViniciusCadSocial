package br.cadastrosocial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.cadastrosocial.model.Estado;

public class EstadoDAO 
{
	
	private EntityManager em;
	
		
	public EstadoDAO() 
	{
		DAO dao = new DAO();
		em = dao.getEntity();
	}
	
	/*Metodo responsavel por salvar o objeto*/
	public void saveEstado(Estado model) 
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
	
	/*Metodo responsalvel por excluir o objeto*/
	public void deleteEstado (Estado model) 
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
	
	/*Metodo responsalvel por atualizar o objeto*/
	public void editEstado(Estado model) 
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
	
	/*Metodo que busca por id*/
	public Estado getById (final int id) 
	{
		return em.find(Estado.class, id);
	}
	
	/*Metodo para lista todos os objetos*/
	@SuppressWarnings("unchecked")
	public List<Estado> getAll()
	{
		return em.createQuery("FROM "+ Estado.class.getName()).getResultList();
	}
}
