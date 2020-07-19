package br.com.poc.springbootmetrics.dto;

import java.io.Serializable;

public class ClientDTO implements Serializable {

	private static final long serialVersionUID = 4518499979158404191L;
	private String id;
    private String cpf;
    private String nome;
    private String email;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
    

}
