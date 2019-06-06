package br.cadastrosocial.model;
/*Classe de padrão de projeto POJO
 *classes pojo são classes com atributos construtor padrão 
 *e métodos geters e seters
 */
public class Login 
{
	/*variáveis*/
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
