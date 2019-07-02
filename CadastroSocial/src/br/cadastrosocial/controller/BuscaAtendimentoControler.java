package br.cadastrosocial.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import br.cadastrosocial.model.Atendimento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BuscaAtendimentoControler {

    @FXML
    private JFXTextField txtBusca;

    @FXML
    private Button btnBuscaAtendimento;

    @FXML
    private Button btnCancelar;

    @FXML
    private JFXListView<Atendimento> listAtendimentos;

    @FXML
    void buscaAtendimento(ActionEvent event) {

    }

    @FXML
    void cancelaTela(ActionEvent event) throws IOException 
    {
    	Stage stage = (Stage) btnCancelar.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_principal.fxml"));
    	Scene scene = new Scene(root);
    	stage.setTitle("CADSocial");
    	stage.setScene(scene);
    	stage.show();
    }

}
