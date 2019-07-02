package br.cadastrosocial.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import br.cadastrosocial.dao.CrudDao;
import br.cadastrosocial.model.Funcionario;
import br.cadastrosocial.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BuscaUsuario implements Initializable{
	
	CrudDao cd = new CrudDao();

    @FXML
    private JFXComboBox<String> cbBuscarPor;

    @FXML
    private JFXTextField txtBusca;

    @FXML
    private Button btnBuscarUsuario;

    @FXML
    private Button btnNovoUsuario;

    @FXML
    private JFXListView<Usuario> listUsuario;

    @FXML
    public void buscaUsuario(ActionEvent event) 
    {
    	/*Seleciona o tipo e faz a busca por tipo*/
    	String tipo = cbBuscarPor.getValue();
    	String nome = txtBusca.getText();
		ObservableList<Usuario> obsUser = FXCollections.observableArrayList(cd.buscaUsuario(tipo, nome));
		if(obsUser.isEmpty()) 
		{	listUsuario.setItems(obsUser.sorted());
			btnNovoUsuario.setVisible(true);
		}
		else {
		listUsuario.setItems(obsUser.sorted());
		btnNovoUsuario.setVisible(false);
		}
    }
    
    @FXML
    void novoUsuario(ActionEvent event) throws IOException 
    {
    	Stage stage = (Stage) btnNovoUsuario.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_cadUsuario.fxml"));
    	Scene scene = new Scene(root);
    	stage.setTitle("CADSocial - Cadastro");
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void chamaTelaTeste(ActionEvent event)  throws IOException {
    	Stage stage = (Stage) listUsuario.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_cadUsuario.fxml"));
    	Scene scene = new Scene(root);
    	stage.setTitle("CADSocial - Busca Usuário");
    	stage.setScene(scene);
    	stage.show();

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		carregarCombo();
		btnNovoUsuario.setVisible(false);
		
		
	}

	private void carregarCombo() 
	{
		/*Carrega o combo box para busca*/
		ObservableList<String> busca = FXCollections.observableArrayList("Nome","NIS","CPF");
		cbBuscarPor.setItems(busca.sorted());
	
	}
	

}
