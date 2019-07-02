package br.cadastrosocial.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import br.cadastrosocial.model.Cidade;
import br.cadastrosocial.model.Estado;
/*Classe generica para realizar o CRUD
 *salva edita e exclui e lista*/
import br.cadastrosocial.model.Funcionario;
import br.cadastrosocial.model.Usuario;

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
			//em.close();
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
			//em.close();
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
	
	public List<Funcionario> listaFuncionario()
	{
		return em.createQuery("FROM " + Funcionario.class.getName()).getResultList();
	}
	
	/*Método para buscar funcionario*/
	public List<Funcionario> buscaFuncionario ( String tipo, String str) 
	{
		if(tipo.equals("Nome")) 
		{	
			return em.createQuery("FROM Funcionario f WHERE f.nome LIKE :nome")
					.setParameter("nome",str).getResultList();	
		}else if (tipo.equals("CPF")) 
		{
			return em.createQuery("FROM Funcionario f WHERE f.cpf = :cpf")
					.setParameter("cpf", str).getResultList();	
		}else if (tipo.equals("Matricula")) 
		{
			return em.createQuery("FROM Funcionario f WHERE f.matricula = :matricula")
					.setParameter("matricula", str).getResultList();	
		}
				
		return null;
	}
	
	/*Método para buscar usuario*/
	public List<Usuario> buscaUsuario( String tipo, String str) 
	{
		if(tipo.equals("Nome")) 
		{	
			return em.createQuery("FROM Usuario f WHERE f.nome LIKE :nome")
					.setParameter("nome","%"+str+"%").getResultList();	
		}else if (tipo.equals("CPF")) 
		{
			return em.createQuery("FROM Usuario f WHERE f.cpf = :cpf")
					.setParameter("cpf", str).getResultList();	
		}else if (tipo.equals("NIS")) 
		{
			return em.createQuery("FROM Usuario f WHERE f.nis = :nis")
					.setParameter("nis", str).getResultList();	
		}
				
		return null;
	}
	
	public List<Cidade> buscaCidade (Estado e)
	{
		return em.createQuery("FROM Cidade c WHERE c.idEstado = :idEstado")
				.setParameter("idEstado", e).getResultList();
	}
	
	
}
