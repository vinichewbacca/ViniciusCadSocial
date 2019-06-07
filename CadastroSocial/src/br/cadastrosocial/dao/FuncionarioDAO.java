package br.cadastrosocial.dao;

import javax.persistence.EntityManager;

import br.cadastrosocial.model.Funcionario;

public class FuncionarioDAO 
{
	private EntityManager em;//variavel responsavel para fazer conexão com o bd
	
	
	public FuncionarioDAO() 
	{
		DAO dao = new DAO();
		em = dao.getEntity();
	}
	
	/*Metodo responsavel por salvar o objeto*/
	public void saveFuncionario(Funcionario model) 
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
	public void deleteFuncionario (Funcionario model) 
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
	public void editFuncionario (Funcionario model) 
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
	/*Metodo que busca objeto por nome*/
	/*Metodo que busca objeto por cpf*/
	/*Metodo que busca objeto por cargo*/

}
