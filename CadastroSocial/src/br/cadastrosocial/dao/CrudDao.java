package br.cadastrosocial.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.cadastrosocial.model.Estado;
/*Classe generica para realizar o CRUD
 *salva edita e exclui e lista*/
public class CrudDao 
{
	private EntityManager em;
	
	public CrudDao() 
	{
		DAO dao = new DAO();
		em = dao.getEntity();
	}
	
	/*metodo responsavel por salvar o modelo*/
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
	
	/*metodo para deletar seu modelo*/
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
	
	/*metodo para editar o modelo*/
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
	
	/*metodo para listar todos os estados*/
	public List<Estado> listaEstado()
	{
		return em.createQuery("FROM " + Estado.class.getName()).getResultList();
	}
	
	
}
