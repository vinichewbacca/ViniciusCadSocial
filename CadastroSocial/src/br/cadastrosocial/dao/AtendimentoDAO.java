package br.cadastrosocial.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.cadastrosocial.model.Atendimento;

public class AtendimentoDAO 
{
	private EntityManagerFactory emf;//variavel responsavel para fazer conexão com o bd
	
	private EntityManager getEntityManager() 
	{/*Responsavel pelas operações do bd*/
		return emf.createEntityManager();
	}
	
	public AtendimentoDAO() 
	{
		emf = Persistence.createEntityManagerFactory("cadSocialJPA");
	}
	
	/*Metodo responsavel por salvar o objeto*/
	public void saveAtendimento(Atendimento model) 
	{
		EntityManager em = getEntityManager();//abre conexao com o bd
		
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
		EntityManager em = getEntityManager();
		
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
		EntityManager em = getEntityManager();
		
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
