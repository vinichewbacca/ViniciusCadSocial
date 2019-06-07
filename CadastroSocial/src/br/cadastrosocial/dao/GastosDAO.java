package br.cadastrosocial.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.cadastrosocial.model.Gastos;

public class GastosDAO 
{
	private EntityManagerFactory emf;//variavel responsavel para fazer conexão com o bd
	
	private EntityManager getEntityManager() 
	{/*Responsavel pelas operações do bd*/
		return emf.createEntityManager();
	}
	
	public GastosDAO() 
	{
		emf = Persistence.createEntityManagerFactory("cadSocialJPA");
	}
	
	/*Metodo responsavel por salvar o objeto*/
	public void saveGastos(Gastos model) 
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
	public void deleteGastos(Gastos model) 
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
	public void editGastos(Gastos model) 
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
	/*Metodo que busca objeto por nome*/
	/*Metodo que busca objeto por cpf*/
	/*Metodo que busca objeto por n*/


}
