package br.cadastrosocial.app;

import java.time.LocalDate;

import org.apache.log4j.BasicConfigurator;

import br.cadastrosocial.dao.CrudDao;
import br.cadastrosocial.jpa.Conexao;
import br.cadastrosocial.model.Beneficio;
import br.cadastrosocial.model.Cidade;
import br.cadastrosocial.model.Estado;
import br.cadastrosocial.model.Funcionario;
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
		Parent root = FXMLLoader.load(getClass().getResource("../view/ui_cadFuncionario.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	

}
