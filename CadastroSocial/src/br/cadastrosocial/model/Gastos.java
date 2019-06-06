package br.cadastrosocial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_gastos")
public class Gastos 
{	
	@Id
	@GeneratedValue
	private int idGastos;
	private double luz,agua,aluguel, alimentacao;
	
	/*metodos geter/seters*/
	public int getIdGastos() {
		return idGastos;
	}
	public void setIdGastos(int idGastos) {
		this.idGastos = idGastos;
	}
	public double getLuz() {
		return luz;
	}
	public void setLuz(double luz) {
		this.luz = luz;
	}
	public double getAgua() {
		return agua;
	}
	public void setAgua(double agua) {
		this.agua = agua;
	}
	public double getAluguel() {
		return aluguel;
	}
	public void setAluguel(double aluguel) {
		this.aluguel = aluguel;
	}
	public double getAlimentacao() {
		return alimentacao;
	}
	public void setAlimentacao(double alimentacao) {
		this.alimentacao = alimentacao;
	}
	
	
}
