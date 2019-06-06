package br.cadastrosocial.model;

import java.time.LocalDate;
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
@Table(name="tb_atendimento")
public class Atendimento 
{
	@Id
	@GeneratedValue
	private int idAtendimento;
	private LocalDate dataAtendimento;
	private String tipoAtendimento;
	private String relatotrioAtendimento;
	/*mapear chaves estrangeiras*/
	@ManyToOne
	@JoinColumn(name = "idFuncionario",nullable = false)
	private Funcionario idFuncionario;
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario idUsuario;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idAtendimento")
	private Collection<Beneficio> beneficioAtd;
	
	
	/*metodos geters/seters*/
	public int getIdAtendimento() {
		return idAtendimento;
	}
	public void setIdAtendimento(int idAtendimento) {
		this.idAtendimento = idAtendimento;
	}
	public LocalDate getDataAtendimento() {
		return dataAtendimento;
	}
	public void setDataAtendimento(LocalDate dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}
	public String getTipoAtendimento() {
		return tipoAtendimento;
	}
	public void setTipoAtendimento(String tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}
	public Funcionario getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Funcionario idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public Usuario getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getRelatotrioAtendimento() {
		return relatotrioAtendimento;
	}
	public void setRelatotrioAtendimento(String relatotrioAtendimento) {
		this.relatotrioAtendimento = relatotrioAtendimento;
	}
	public Collection<Beneficio> getBeneficioAtd() {
		return beneficioAtd;
	}
	public void setBeneficioAtd(Collection<Beneficio> beneficioAtd) {
		this.beneficioAtd = beneficioAtd;
	}
	
}
