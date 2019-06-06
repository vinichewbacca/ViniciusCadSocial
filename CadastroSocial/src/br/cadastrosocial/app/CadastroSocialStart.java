package br.cadastrosocial.app;

import org.apache.log4j.BasicConfigurator;

import br.cadastrosocial.jpa.Conexao;



public class CadastroSocialStart 
{

	public static void main(String[] args) 
	{
		BasicConfigurator.configure();
		Conexao con = new Conexao();//responsavel por inicializar o log4j
		
		con.getEntity();
		
	
	}

}
