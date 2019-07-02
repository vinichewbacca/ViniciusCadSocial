package br.cadastrosocial.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import br.cadastrosocial.dao.CrudDao;
import br.cadastrosocial.model.Cidade;
import br.cadastrosocial.model.Estado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CadCidadeControler implements Initializable{

	CrudDao cd = new CrudDao();
	Estado e = new Estado();
	Cidade c = new Cidade();
	Cidade c2 = new Cidade();
    @FXML
    private JFXTextField txtCidade;

    @FXML
    private JFXComboBox<Estado> cbEstados;

    @FXML
    private Button btnSaveCidade;

    @FXML
    private JFXCheckBox ckCidade;

    @FXML
    private JFXCheckBox ckCidade2;

    @FXML
    void saveCidade(ActionEvent event) throws IOException 
    {
    	e = cbEstados.getSelectionModel().getSelectedItem();
    	c.setNomeCidade(txtCidade.getText());
    	c.setIdEstado(e);
    	cd.save(c);
    	
    		Stage stage = (Stage) btnSaveCidade.getScene().getWindow();
        	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_cadastradoSucesso.fxml"));
        	Scene scene = new Scene(root);
        	stage.setTitle("CADSocial");
        	stage.setScene(scene);
        	stage.show();
    	
    	/*if(ckCidade2.isSelected()) 
    	{
    		System.out.println(ckCidade2.getText());
    		e.setIdEstado(15);
    		c.setNomeCidade(ckCidade2.getText().toString());
        	c.setIdEstado(e);
        	cd.save(c);	
    	}
    	if (ckCidade.isSelected()) 
    	{System.out.println(ckCidade.getText());
    		e.setIdEstado(15);
    		c.setNomeCidade(ckCidade.getText());
        	c.setIdEstado(e);
        	cd.save(c);		
    	}*/
    	
    }

    @FXML
    void selecionaEstado(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarEstados();
		
	}
	
	/*Metodo para carregar todos os estados no comboBox*/
	private void carregarEstados()
	{
		ObservableList<Estado> obs = FXCollections.observableArrayList(cd.listaEstado());
		cbEstados.setItems(obs.sorted());
		
	}

}
