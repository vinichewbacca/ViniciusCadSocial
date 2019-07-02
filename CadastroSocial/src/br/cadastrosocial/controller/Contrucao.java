package br.cadastrosocial.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Contrucao {

    @FXML
    private Button btnVoltar;

    @FXML
    void cancelaTela(ActionEvent event) throws IOException 
    {
    	Stage stage = (Stage) btnVoltar.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_principal.fxml"));
    	Scene scene = new Scene(root);
    	stage.centerOnScreen();
    	stage.setTitle("CADSocial");
    	stage.setScene(scene);
    	stage.show();
    }

}
