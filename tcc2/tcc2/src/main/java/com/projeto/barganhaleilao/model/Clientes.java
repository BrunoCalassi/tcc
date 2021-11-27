package com.projeto.barganhaleilao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "clientes")
public class Clientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotEmpty(message = "Campo usuario é obrigatório")
	private String usuario;
	
	@NotEmpty(message = "Campo nome é obrigatório")
	private String nome;
	
	@NotEmpty(message = "Campo email é obrigatório")
	private String email;
	
	@NotEmpty(message = "Campo celular é obrigatório")
	private String celular;

	@NotEmpty(message = "Campo endereço é obrigatório")
	private String endereco;

	@CPF
	private String cpf;

	@NotEmpty(message = "Campo senha é obrigatório")
	private String senha;

	
	public Long getCodigo() {
		return codigo;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getCelular() {
		return celular;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clientes other = (Clientes) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
