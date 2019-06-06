package br.cadastrosocial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_beneficio")
public class Beneficio 
{
	@Id
	@GeneratedValue
	private int idBeneficio;
	private String nomeBeneficio;
	private String tipoBeneficio;
	/*mapear estrangeiras*/
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario idUsuario;
	@ManyToOne
	@JoinColumn(name = "idAtendimento", nullable = false)
	private Atendimento idAtendimento;
	
	/*metodos geters/seters*/
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
	public Usuario getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Atendimento getIdAtendimento() {
		return idAtendimento;
	}
	public void setIdAtendimento(Atendimento idAtendimento) {
		this.idAtendimento = idAtendimento;
	}
	
}
