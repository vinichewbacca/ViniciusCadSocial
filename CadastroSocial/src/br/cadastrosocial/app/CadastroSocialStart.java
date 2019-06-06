package br.cadastrosocial.app;

import org.apache.log4j.BasicConfigurator;

import br.cadastrosocial.controller.CidadeDAO;
import br.cadastrosocial.controller.EstadoDAO;
import br.cadastrosocial.jpa.Conexao;
import br.cadastrosocial.model.Cidade;
import br.cadastrosocial.model.Estado;

public class CadastroSocialStart 
{

	public static void main(String[] args) 
	{
		BasicConfigurator.configure();
		//Conexao con = new Conexao();//responsavel por inicializar o log4j
		Cidade e = new Cidade();
		Estado es = new Estado();
		es.setIdEstado(1);
		CidadeDAO cd = new CidadeDAO();
		//con.getEntity();
		e.setNomeCidade("Rio Branco");
		e.setIdEstado(es);
		cd.saveCidade(e);
	
	}

}
