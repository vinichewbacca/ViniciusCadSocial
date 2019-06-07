package br.cadastrosocial.dao;

import java.awt.Button;

import br.cadastrosocial.jpa.Conexao;
import javafx.fxml.FXML;

public class Autenticar 
{
	/*variaveis-----------------------------------------------------*/
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCadastrar;

	/*logica de negocio para autenticacao de login------------------*/
	public String logar(String user, String pwd) 
	{
		return "Usuário ou Senha incorretos";
	}
	
	/*metódo para sair do sistema----------------------------------*/
	public void logout() 
	{
		Conexao conn = new Conexao();
		conn.closeEMF();
		/*destruir sesssao
		 * redirecionar view
		 * web chama JSF
		 * javafx chama FXML
		 * mobile chama java
		 */
	}
	
	/*------------------------------------------------------------*/
}
