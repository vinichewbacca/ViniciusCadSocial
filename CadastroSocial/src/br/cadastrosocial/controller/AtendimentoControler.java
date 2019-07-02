package br.cadastrosocial.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class AtendimentoControler implements Initializable{

    @FXML
    private AnchorPane txtDataNascUsuario;

    @FXML
    private JFXTextField txtIdAtendimento;

    @FXML
    private JFXTextField txtDataAtendimento;

    @FXML
    private JFXTextField txtNomeUsuario;

    @FXML
    private JFXTextField txtDataNascimentoUsuario;

    @FXML
    private JFXComboBox<String> cbTipoAtendimento;

    @FXML
    private JFXCheckBox checkBpcIdoso;

    @FXML
    private JFXCheckBox checkBpcPcd;

    @FXML
    private JFXCheckBox chekIntermunicipalIdoso;

    @FXML
    private JFXCheckBox checkIntermunicipalPcd;

    @FXML
    private JFXCheckBox checkInterestadualIdoso;

    @FXML
    private JFXCheckBox checkInterestadualPcd;

    @FXML
    private JFXCheckBox checkAlimentar;

    @FXML
    private JFXCheckBox checkNatalidade;

    @FXML
    private JFXCheckBox checkOutros;

    @FXML
    private Button btnSalvarAtd;

    @FXML
    private Button btnCancelAtd;

    @FXML
    private JFXTextArea txareaAtendimento;

    @FXML
    private HTMLEditor htmlRelatorio;

    @FXML
    private Button btnGeraRelatorio;

    @FXML
    private JFXTextField txtNomeTecnico;

    @FXML
    private JFXTextField txtCargoTecnico;
    
    @FXML
    private JFXCheckBox ckPasse;

    @FXML
    private JFXCheckBox ckBpc;

    @FXML
    private JFXCheckBox ckEventual;


    @FXML
    void habilitaBpc(ActionEvent event) 
    {
    	if(ckBpc.isSelected()) 
    	{
	    	checkBpcIdoso.setDisable(false);
			checkBpcPcd.setDisable(false);
			
		}else 
		{
			checkBpcIdoso.setDisable(true);
			checkBpcPcd.setDisable(true);		
		}
    }

    @FXML
    void habilitaEventual(ActionEvent event) 
    {
    	if(ckEventual.isSelected()) 
    	{
	    	checkAlimentar.setDisable(false);
			checkNatalidade.setDisable(false);
			
		}else 
		{
			checkAlimentar.setDisable(true);
			checkNatalidade.setDisable(true);		
		}
    }

    @FXML
    void habilitaPasse(ActionEvent event) 
    {
    	if(ckPasse.isSelected()) 
    	{
	    	checkInterestadualIdoso.setDisable(false);
			checkInterestadualPcd.setDisable(false);
			checkIntermunicipalPcd.setDisable(false);
			chekIntermunicipalIdoso.setDisable(false);
		}else 
		{
			checkInterestadualIdoso.setDisable(true);
			checkInterestadualPcd.setDisable(true);
			checkIntermunicipalPcd.setDisable(true);
			chekIntermunicipalIdoso.setDisable(true);	
		}
    }
    
    @FXML
    void cancelaTela(ActionEvent event) throws IOException 
    {
    	Stage stage = (Stage) btnCancelAtd.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_principal.fxml"));
    	Scene scene = new Scene(root);
    	stage.setTitle("CADSocial");
    	stage.setScene(scene);
    	stage.show();
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		carregarCombos();	
		
		
	}
	
	private void carregarCombos() 
	{
		/*Carrega o combo Tipo Atendimento*/
		ObservableList<String>tipoAtendimento = FXCollections.observableArrayList("Encaminhamento","Orientação","Solicitar Benefícios",
				"Desbloqueio BF");
		cbTipoAtendimento.setItems(tipoAtendimento.sorted());		
	}
	
	public void habilitaCampos() 
	{
		
	}

}
