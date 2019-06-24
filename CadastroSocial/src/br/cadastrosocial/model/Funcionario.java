package br.cadastrosocial.model;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_funcionario")
public class Funcionario extends Pessoa 
{
	
	private String cargo;
	private LocalDate dataAdmissao;
	private String matricula, email,loginFuncionario,senhaFuncionario;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionario")
	private Collection<Atendimento> atendimentoFun;
	
	/*Gerar mapeamento para referenciar a pessoa*/
	
	
	/*metodos geters/seters*/
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<Atendimento> getAtendimentos() {
		return atendimentoFun;
	}
	public void setAtendimentos(Collection<Atendimento> atendimentos) {
		this.atendimentoFun = atendimentos;
	}
	public String getLoginFuncionario() {
		return loginFuncionario;
	}
	public void setLoginFuncionario(String loginFuncionario) {
		this.loginFuncionario = loginFuncionario;
	}
	public String getSenhaFuncionario() {
		return senhaFuncionario;
	}
	public void setSenhaFuncionario(String senhaFuncionario) {
		this.senhaFuncionario = senhaFuncionario;
	}
	
	
	
}
