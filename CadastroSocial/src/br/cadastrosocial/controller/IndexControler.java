package br.cadastrosocial.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXProgressBar;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class IndexControler implements Initializable{

    @FXML
    private MenuButton mbtnSistema;

    @FXML
    private ImageView imgBuscarUsuario;

    @FXML
    private ImageView imgAtendimento;

    @FXML
    private ImageView imgGeraRelatorio;

    @FXML
    private ImageView imgGeraGrafico;
    
    @FXML
    private JFXProgressBar carregamento;

    @FXML
    void telaBuscar(MouseEvent event) throws IOException 
    {
    	
    	Stage stage = (Stage) imgBuscarUsuario.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_buscaUsuario.fxml"));
    	Scene scene = new Scene(root);
    	carregamento.setVisible(true);
    	stage.setTitle("CADSocial - Buscar Usuario");
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
   

	@FXML
    void telaAtendimento(MouseEvent event) throws IOException 
    {
    	Stage stage = (Stage) imgAtendimento.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_buscaAtendimento.fxml"));
    	Scene scene = new Scene(root);
    	stage.setTitle("CADSocial - Atendimentos");
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void telaGeraGraficos(MouseEvent event) throws IOException 
    {
    	Stage stage = (Stage) imgGeraGrafico.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_contrucao.fxml"));
    	Scene scene = new Scene(root);
    	stage.setTitle("Desculpe Pelo Transtorno");
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void telaGeraRelatorio(MouseEvent event)throws IOException 
    {
    	Stage stage = (Stage) imgGeraRelatorio.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_contrucao.fxml"));
    	Scene scene = new Scene(root);
    	stage.setTitle("Desculpe Pelo Transtorno");
    	stage.setScene(scene);
    	stage.show();

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
    	
		
	}
	

}
