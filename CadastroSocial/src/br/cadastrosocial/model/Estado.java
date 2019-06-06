package br.cadastrosocial.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="tb_estado")
public class Estado 
{
	@Id
	@GeneratedValue
	private int idEstado;
	private String nomeEstado;
	private String uf;
	/*OneToMany significa que haverá um relacionamento
	 * um para muitos isso quer dizer que para
	 * um estado haverá várias cidades*/
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
	private Collection<Cidade> cidade;
	
	
	/*métodos geters/seters*/
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getNomeEstado() {
		return nomeEstado;
	}
	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public Collection<Cidade> getCidade() {
		return cidade;
	}
	public void setCidade(Collection<Cidade> cidade) {
		this.cidade = cidade;
	}
	
	
}
