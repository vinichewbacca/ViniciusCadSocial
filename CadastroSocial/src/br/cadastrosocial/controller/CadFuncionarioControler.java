package br.cadastrosocial.controller;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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
    private JFXTextField txtCargo;

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
		carregaGenero();
		carregaEstadoCivil();
		
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
		func.setCargo(txtCargo.getText());
		func.setEmail(txtEmail.getText());
		func.setLoginFuncionario(txtLogin.getText());
		func.setSenhaFuncionario(txtSenha.getText());
		
		cd.save(func);
    }
	
	private void carregaGenero() 
	{
		ObservableList<String> genero = FXCollections.observableArrayList("Masculino","Feminino","Outro");
		cbGeneroFunc.setItems(genero.sorted());
		
	}

	private void carregaEstadoCivil() 
	{
		ObservableList<String> estadoCivil = FXCollections.observableArrayList("Solteira(o)","Casada(o)","Viúva(o)",
				"Separada(o)","Amasiada(o)");
		cbEstadoCivilFunc.setItems(estadoCivil.sorted());	
	}

}
