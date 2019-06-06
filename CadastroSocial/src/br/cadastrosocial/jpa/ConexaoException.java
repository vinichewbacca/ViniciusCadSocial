package br.cadastrosocial.jpa;

public class ConexaoException extends Exception 
{
	public void JPAException(String ex) 
	{
		System.out.println("Erro na conexão:\n "+ex);
	}
}
