package br.cadastrosocial.app;

import org.apache.log4j.BasicConfigurator;

import br.cadastrosocial.dao.CrudDao;
import br.cadastrosocial.jpa.Conexao;
import br.cadastrosocial.model.Estado;



public class CadastroSocialStart 
{

	public static void main(String[] args) 
	{
		BasicConfigurator.configure();
		 Estado e = new Estado();
		 CrudDao cd = new CrudDao();
		 
		 e.setNomeEstado("Tocantis");
		 e.setUf("TO");
		 cd.save(e);
		
	
	}

}
