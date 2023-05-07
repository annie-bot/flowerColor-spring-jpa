package com.flowercolor.shop.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_enterprise")
public class Enterprise implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)

	private Long id;
	private String cnpj;
	private String flowerColor;
	private String cep;

	@OneToMany
	private List<Supplier> suppliers;
	
	public Enterprise() {
	}
	
	public Enterprise(String cnpj, String flowerColor, String cep) {
		super();
		this.cnpj = cnpj;
		this.flowerColor = flowerColor;
		this.cep = cep;
		}

	public String getCnpj() {
	return cnpj;
	}

	public void setCnpj(String cNPJ) {
		cnpj = cNPJ;
	}

	public String getFlowerColor() {
		return flowerColor;
	}

	public void setFlowerColor(String flowerColor) {
		this.flowerColor = flowerColor;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cEP) {
		cep = cEP;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cep, cnpj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enterprise other = (Enterprise) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(cnpj, other.cnpj);
	}
}

