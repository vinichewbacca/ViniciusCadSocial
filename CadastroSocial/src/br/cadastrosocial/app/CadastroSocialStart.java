package br.cadastrosocial.app;

import java.time.LocalDate;

import org.apache.log4j.BasicConfigurator;

import br.cadastrosocial.dao.CrudDao;
import br.cadastrosocial.jpa.Conexao;
import br.cadastrosocial.model.Beneficio;
import br.cadastrosocial.model.Cidade;
import br.cadastrosocial.model.Estado;
import br.cadastrosocial.model.Funcionario;



public class CadastroSocialStart 
{

	public static void main(String[] args) 
	{
		BasicConfigurator.configure();
		 //Cidade e = new Cidade();
		 CrudDao cd = new CrudDao();
		 //Estado est = new Estado();
		 //Beneficio b = new Beneficio();
		 Funcionario func = new Funcionario();
		 
		func.setNome("Pedro Prado");
		func.setDataNascimento(LocalDate.of(1977, 10, 19));
		func.setGenero("Masculino");
		func.setRg("4568X");
		func.setCpf("888123456-89");
		func.setEstadoCivil("solteiro");
		func.setCargo("Psicologo");
		func.setEmail("aranha@gmail.com");
		func.setMatricula("20111");
		func.setLoginFuncionario("peter");
		func.setSenhaFuncionario("aranha555");
		func.setDataAdmissao(LocalDate.of(2015, 7, 15));
		 
		 cd.save(func);
		
	
	}

}
