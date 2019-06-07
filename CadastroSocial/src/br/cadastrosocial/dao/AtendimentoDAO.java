package br.cadastrosocial.dao;

import javax.persistence.EntityManager;

import br.cadastrosocial.model.Atendimento;

public class AtendimentoDAO 
{
	private EntityManager em;
	
	public AtendimentoDAO() 
	{
		DAO dao = new DAO();
		em = dao.getEntity();	
		}
	
	/*Metodo responsavel por salvar o objeto*/
	public void saveAtendimento(Atendimento model) 
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
	public void deleteAtendimento (Atendimento model) 
	{
		
		try 
		{
			em.getTransaction().begin();
			model = em.merge(model);
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
	public void editAtendimento(Atendimento model) 
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
	
	/*Metodo que lista todos os objetos*/
	/*Metodo que busca objeto por data de atendimento*/
	/*Metodo que busca objeto por funcionario*/
	/*Metodo que busca objeto por usuario*/

}
