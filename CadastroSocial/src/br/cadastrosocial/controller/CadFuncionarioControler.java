package br.cadastrosocial.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import br.cadastrosocial.dao.CrudDao;
import br.cadastrosocial.model.Funcionario;
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

public class CadFuncionarioControler implements Initializable {

	Funcionario func = new Funcionario();
	CrudDao cd = new CrudDao();
	
    @FXML
    private JFXTextField txtNomeFunc;

    @FXML
    private JFXDatePicker dtpDataNascFunc;

    @FXML
    private JFXTextField txtRgFunc;

    @FXML
    private JFXTextField txtCpfFunc;

    @FXML
    private JFXComboBox<String> cbGeneroFunc;

    @FXML
    private JFXComboBox<String> cbEstadoCivilFunc;

    @FXML
    private JFXDatePicker dtpDataAdmissao;

    @FXML
    private JFXTextField txtMatricula;

    @FXML
    private JFXComboBox<String> cbCargo;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private Button btnCancelarFunc;

    @FXML
    private Button btnSaveFunc;

    @FXML
    private JFXTextField txtLogin;

    @FXML
    private JFXTextField txtSenha;

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		carregaCombo();
		
	}
	
	@FXML
    void saveFuncionario(ActionEvent event) 
	{
		func.setNome(txtNomeFunc.getText());
		func.setDataNascimento(dtpDataNascFunc.getValue());
		func.setGenero(cbGeneroFunc.getValue());
		func.setRg(txtRgFunc.getText());
		func.setCpf(txtCpfFunc.getText());
		func.setEstadoCivil(cbEstadoCivilFunc.getValue());
		func.setDataAdmissao(dtpDataAdmissao.getValue());
		func.setMatricula(txtMatricula.getText());
		func.setCargo(cbCargo.getValue());
		func.setEmail(txtEmail.getText());
		func.setLoginFuncionario(txtLogin.getText());
		func.setSenhaFuncionario(txtSenha.getText());
		
		cd.save(func);
    }
	
	@FXML
    void cancelaTela(ActionEvent event) throws IOException 
    {
    	Stage stage = (Stage) btnCancelarFunc.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_principal.fxml"));
    	Scene scene = new Scene(root);
    	stage.setTitle("CADSocial");
    	stage.setScene(scene);
    	stage.show();
    }
	
	private void carregaCombo() 
	{
		ObservableList<String> genero = FXCollections.observableArrayList("Masculino","Feminino","Outro");
		ObservableList<String> cargo = FXCollections.observableArrayList("Assistente Social","Psicólogo");
		cbGeneroFunc.setItems(genero.sorted());
		cbCargo.setItems(cargo);
		ObservableList<String> estadoCivil = FXCollections.observableArrayList("Solteira(o)","Casada(o)","Viúva(o)",
				"Separada(o)","Amasiada(o)");
		cbEstadoCivilFunc.setItems(estadoCivil.sorted());
		
	}

	

}
