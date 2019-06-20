package br.cadastrosocial.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import br.cadastrosocial.dao.CrudDao;
import br.cadastrosocial.model.Cidade;
import br.cadastrosocial.model.Estado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class CadCidadeControler implements Initializable {

	Cidade c = new Cidade();
	CrudDao cd = new CrudDao();
	
	@FXML
    private JFXTextField txtCidade;
	
    @FXML
    private Button btnSaveCidade;
    
    @FXML
    private JFXComboBox<Estado> cbEstados;

    @FXML
    public void saveCidade(ActionEvent event) 
    {
    	Estado e = cbEstados.getSelectionModel().getSelectedItem();
    	c.setNomeCidade(txtCidade.getText());
    	c.setIdEstado(e);
    	cd.save(c);
    	
    }
    
    @FXML
    public void selecionaEstado(ActionEvent event) 
    {
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		carregarEstados();
	}

	/*Metodo para carregar todos os estados no comboBox*/
	private void carregarEstados()
	{
		ObservableList<Estado> obs = FXCollections.observableArrayList(cd.listaEstado());
		cbEstados.setItems(obs.sorted());
		
	}

}
