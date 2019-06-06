package br.cadastrosocial.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_cidade")
public class Cidade 
{
	@Id
	@GeneratedValue
	private int idCidade;
	private String nomeCidade;
	/*mapear chaves esntrangeiras
	 * ManytoOne diz que existe um relacionamento de muitos pra um
	 * nullable diz se a tabela pode ser not nul ou não*/
	@ManyToOne
	@JoinColumn(name="idEstado", nullable = false)
	private Estado idEstado;
	/*cascadeType.ALL indica que as alterações
	 * na entidade cidade serão refletidas automaticmente 
	 * nas entidades relacionadas (Endereco)*/
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCidade")
	private Collection<Endereco> endereco;
	
	
	/*métodos geters/seters*/
	public int getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	public Estado getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Estado idEstado) {
		this.idEstado = idEstado;
	}
	public Collection<Endereco> getEndereco() {
		return endereco;
	}
	public void setEndereco(Collection<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	
}
