package com.flowercolor.shop.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_supplier")
public class Supplier implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cnpj;
	private String cpf;
	private String name;
	private String email;
	private String cep;
	
	public Supplier() {
		
	}

	public Supplier(String cnpj, String cpf, String name, String email, String cep) {
		super();
		this.cnpj = cnpj;
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.cep = cep;
	}

	public String getcnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		cep = cep;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, cnpj, cpf, email, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(cnpj, other.cnpj) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(email, other.email) && Objects.equals(name, other.name);
	}
	
	
}
