package br.cadastrosocial.app;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.BasicConfigurator;

import br.cadastrosocial.controller.IndexControler;
import br.cadastrosocial.dao.CrudDao;
import br.cadastrosocial.jpa.Conexao;
import br.cadastrosocial.model.Beneficio;
import br.cadastrosocial.model.Cidade;
import br.cadastrosocial.model.Endereco;
import br.cadastrosocial.model.Estado;
import br.cadastrosocial.model.Funcionario;
import br.cadastrosocial.model.Gastos;
import br.cadastrosocial.model.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class CadastroSocialStart extends Application
{

	public static void main(String[] args) 
	{
		BasicConfigurator.configure();
		launch(args); 
		
		
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{	
		Parent root = FXMLLoader.load(getClass().getResource("../view/ui_principal.fxml"));
		Scene scene = new Scene(root);
		primaryStage.centerOnScreen();
		primaryStage.setScene(scene);
		primaryStage.setTitle("CADSocial");
		primaryStage.show();

		
	}
	
	

}
