package br.cadastrosocial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_beneficioSolicitado")
public class BeneficioSolicitado 
{
	@Id
	@GeneratedValue
	private int idBeneficio;
	private String nomeBeneficio;
	private String tipoBeneficio;
	@ManyToOne
	@JoinColumn(name = "idAtendimento", nullable = false)
	private Atendimento idAtendimento;
	
	public int getIdBeneficio() {
		return idBeneficio;
	}
	public void setIdBeneficio(int idBeneficio) {
		this.idBeneficio = idBeneficio;
	}
	public String getNomeBeneficio() {
		return nomeBeneficio;
	}
	public void setNomeBeneficio(String nomeBeneficio) {
		this.nomeBeneficio = nomeBeneficio;
	}
	public String getTipoBeneficio() {
		return tipoBeneficio;
	}
	public void setTipoBeneficio(String tipoBeneficio) {
		this.tipoBeneficio = tipoBeneficio;
	}
	public Atendimento getIdAtendimento() {
		return idAtendimento;
	}
	public void setIdAtendimento(Atendimento idAtendimento) {
		this.idAtendimento = idAtendimento;
	}
	
	
}
