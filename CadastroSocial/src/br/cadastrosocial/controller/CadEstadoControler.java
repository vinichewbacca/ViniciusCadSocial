package br.cadastrosocial.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.cadastrosocial.dao.CrudDao;
import br.cadastrosocial.model.Estado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CadEstadoControler {

    @FXML
    private JFXTextField idNomeEstado;

    @FXML
    private JFXTextField txtUf;

    @FXML
    private JFXButton btnSalvar;

    @FXML
    void salvarEstado(ActionEvent event) 
    {
    	Estado e = new Estado();
    	CrudDao cd = new CrudDao();
    	
    	e.setNomeEstado(idNomeEstado.getText());
    	e.setUf(txtUf.getText());
    	cd.save(e);
    }

}
