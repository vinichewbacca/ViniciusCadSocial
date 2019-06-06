package br.cadastrosocial.jpa;

import java.sql.Connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao 
{
	static Connection conn = null;
	EntityManagerFactory emf = null;
	
	/*método construtor-------------------------------------------------*/
	public Conexao() 
	{
		if(emf == null)//verifica se existe uma conexao aberta se tiver ele aproveita se não ele cria uma outra
			emf = createEntity();
		else
			getEntity();
	}
	/*recupera a conexão aberta para persistir objeto-----------------*/
	public EntityManagerFactory getEntity() 
	{
		return emf;
	}
	
	/*Faz conexao JDBC-------------------------------------------------*/
	public static Connection getConnection() 
	{
		return conn;
	}
	
	/*Cria uma conexão com o banco de dados---------------------------*/
	public EntityManagerFactory createEntity() 
	{
		emf = Persistence.createEntityManagerFactory("cadSocialJPA");
		
		return emf;
	}
	
	/*metodo responsável por fechar as conexões-----------------------*/
	public void closeEMF() 
	{
		emf.close();
	}
}
