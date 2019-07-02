package br.cadastrosocial.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_usuario")
public class Usuario extends Pessoa
{
	
	
	private String nis;
	private double renda;
	private String pai, mae;
	/*mapear chaves esntrangeiras*/
	@OneToOne
	private Endereco idEndereco;
	@OneToOne
	private Gastos idGastos;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
	private Collection<Atendimento>atendimentoUsu;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
	private Collection<Beneficio>beneficioUsu;
	
	
	public Collection<Beneficio> getBeneficioUsu() {
		return beneficioUsu;
	}
	public void setBeneficioUsu(Collection<Beneficio> beneficioUsu) {
		this.beneficioUsu = beneficioUsu;
	}
	/*metodos geter/seters*/
	
	public String getNis() {
		return nis;
	}
	public void setNis(String nis) {
		this.nis = nis;
	}
	public double getRenda() {
		return renda;
	}
	public void setRenda(double renda) {
		this.renda = renda;
	}
	public String getPai() {
		return pai;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}
	public String getMae() {
		return mae;
	}
	public void setMae(String mae) {
		this.mae = mae;
	}
	public Endereco getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Endereco idEndereco) {
		this.idEndereco = idEndereco;
	}
	public Gastos getIdGastos() {
		return idGastos;
	}
	public void setIdGastos(Gastos idGastos) {
		this.idGastos = idGastos;
	}
	public Collection<Atendimento> getAtendimentoUsu() {
		return atendimentoUsu;
	}
	public void setAtendimentoUsu(Collection<Atendimento> atendimentoUsu) {
		this.atendimentoUsu = atendimentoUsu;
	}
	@Override
	public String toString() {
		
		return "Nome:"+getNome()+" -- Bairro: "+getIdEndereco().getBairro();
	}
	
 
	
}
