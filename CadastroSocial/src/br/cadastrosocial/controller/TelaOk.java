package br.cadastrosocial.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaOk {

    @FXML
    private Button btnOK;

    @FXML
    void cancelaTela(ActionEvent event) throws IOException 
    {
    	Stage stage = (Stage) btnOK.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_principal.fxml"));
    	Scene scene = new Scene(root);
    	stage.setTitle("CADSocial");
    	stage.setScene(scene);
    	stage.show();
    }

}
