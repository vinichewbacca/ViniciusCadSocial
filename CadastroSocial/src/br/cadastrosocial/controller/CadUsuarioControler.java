package br.cadastrosocial.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import br.cadastrosocial.dao.CrudDao;
import br.cadastrosocial.model.Beneficio;
import br.cadastrosocial.model.Cidade;
import br.cadastrosocial.model.Endereco;
import br.cadastrosocial.model.Estado;
import br.cadastrosocial.model.Gastos;
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
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;

public class CadUsuarioControler implements Initializable {

	CrudDao cd = new CrudDao();
	Cidade c = new Cidade();
	Endereco end = new Endereco();
	Gastos g = new Gastos();
	Usuario u = new Usuario();
	
    @FXML
    private JFXTextField txtNomeUsuario;

    @FXML
    private JFXDatePicker dtpDataNascUsuario;

    @FXML
    private JFXComboBox<String> cbGeneroUsuario;

    @FXML
    private JFXTextField txtRgUsuario;

    @FXML
    private JFXTextField txtCpfUsuario;

    @FXML
    private JFXTextField txtNis;

    @FXML
    private JFXComboBox<String> cbEstadoCivilUsuario;

    @FXML
    private JFXTextField txtPai;

    @FXML
    private JFXTextField txtMae;

    @FXML
    private JFXTextField txtRenda;

    @FXML
    private JFXComboBox<Estado> cbEstado;

    @FXML
    private JFXComboBox<Cidade> cbCidade;

    @FXML
    private JFXTextField txtLogradouro;

    @FXML
    private JFXTextField txtNumero;

    @FXML
    private JFXTextField txtBairro;

    @FXML
    private JFXTextField txtComplemento;

    @FXML
    private JFXTextField txtCep;

    @FXML
    private JFXTextField txtLuz;

    @FXML
    private JFXTextField txtAgua;

    @FXML
    private JFXTextField txtAluguel;

    @FXML
    private JFXTextField txtAlimentacao;

    @FXML
    private JFXTextField txtTotalGastos;

    @FXML
    private JFXCheckBox checkBF;

    @FXML
    private JFXCheckBox checkVr;

    @FXML
    private JFXCheckBox checkBpcIdoso;

    @FXML
    private JFXCheckBox checkBpcPcd;

    @FXML
    private Button btnSaveUsuario;

    @FXML
    private Button brnCancelUsuario;

    @FXML
    void cancelaTela(ActionEvent event) throws IOException 
    {
    	Stage stage = (Stage) brnCancelUsuario.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_principal.fxml"));
    	Scene scene = new Scene(root);
    	stage.setTitle("CADSocial");
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void salvaUsuario(ActionEvent event) throws IOException 
    {
    	end.setIdCidade(cbCidade.getSelectionModel().getSelectedItem());
    	end.setLogradouro(txtLogradouro.getText());
    	end.setNumero(Integer.parseInt(txtNumero.getText()));
    	end.setBairro(txtBairro.getText());
    	end.setComplemento(txtComplemento.getText());
    	end.setCep(txtCep.getText());
    	cd.save(end);
    	
    	g.setLuz(Float.parseFloat(txtLuz.getText()));
    	g.setAgua(Float.parseFloat(txtAgua.getText()));
    	g.setAluguel(Float.parseFloat(txtAluguel.getText()));
    	g.setAlimentacao(Float.parseFloat(txtAlimentacao.getText()));
    	cd.save(g);
    	
    	u.setNome(txtNomeUsuario.getText());
		u.setCpf(txtCpfUsuario.getText());
		u.setRg(txtRgUsuario.getText());
		u.setGenero(cbGeneroUsuario.getValue());
		u.setEstadoCivil(cbEstadoCivilUsuario.getValue());
		u.setDataNascimento(dtpDataNascUsuario.getValue());
		u.setMae(txtMae.getText());
		u.setPai(txtPai.getText());
		u.setRenda(Float.parseFloat(txtRenda.getText()));
		u.setNis(txtNis.getText());
		u.setIdEndereco(end);
		u.setIdGastos(g);
		cd.save(u);
		
		if(checkBF.isSelected()) 
		{
			Beneficio b = new Beneficio();
			b.setIdUsuario(u);
			b.setNomeBeneficio(checkBF.getText());
			b.setTipoBeneficio("Transferencia de Renda");
			cd.save(b);
		}
		
		if(checkBpcIdoso.isSelected()) 
		{
			Beneficio b2 = new Beneficio();
			b2.setIdUsuario(u);
			b2.setNomeBeneficio(checkBpcIdoso.getText());
			b2.setTipoBeneficio("Transferencia de Renda");
			cd.save(b2);
		}
		
		if(checkBpcPcd.isSelected()) 
		{
			Beneficio b3 = new Beneficio();
			b3.setIdUsuario(u);
			b3.setNomeBeneficio(checkBpcPcd.getText());
			b3.setTipoBeneficio("Transferencia de Renda");
			cd.save(b3);
		}
		
		if(checkVr.isSelected()) 
		{
			Beneficio b4 = new Beneficio();
			b4.setIdUsuario(u);
			b4.setNomeBeneficio(checkVr.getText());
			b4.setTipoBeneficio("Transferencia de Renda");
			cd.save(b4);
		}
		
		Stage stage = (Stage) btnSaveUsuario.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_cadastradoSucesso.fxml"));
    	Scene scene = new Scene(root);
    	stage.setTitle("CADSocial");
    	stage.setScene(scene);
    	stage.show();
		
		
    }
    
    @FXML
    void somaGastos(ActionEvent event) 
    { float soma;
    	float luz = Float.parseFloat(txtLuz.getText());
    	float agua = Float.parseFloat(txtAgua.getText());
    	float aluguel = Float.parseFloat(txtAluguel.getText());
    	float alimentacao = Float.parseFloat(txtAlimentacao.getText());	
    	soma = luz+agua+aluguel+alimentacao;
    	
    	txtTotalGastos.setText(""+soma);
    }
    
    @FXML
    void carregaCidadeTeste(ActionEvent event) 
    { 	
    	ObservableList<Cidade> obsCidade = FXCollections.observableArrayList(cd.buscaCidade(cbEstado.getSelectionModel().getSelectedItem()));
		cbCidade.setItems(obsCidade);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		cbGeneroUsuario.getItems().addAll("Masculino","Feminino","Outros");
		cbEstadoCivilUsuario.getItems().addAll("Solteira(o)","Casada(o)","Viúva(o)",
				"Separada(o)","Amasiada(o)");
		carregarEstado();

	}

	private void carregarEstado() 
	{
		ObservableList<Estado> obsEstado = FXCollections.observableArrayList(cd.listaEstado());
		cbEstado.setItems(obsEstado.sorted());
		
	}
	
	

}
