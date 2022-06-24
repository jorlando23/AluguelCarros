package br.edu.ifms.aluguel.dto;

import java.io.Serializable;

import br.edu.ifms.aluguel.entities.Vendedor;

public class VendedorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String codigo;
	private String nome;
	private String email;
	private String telefone;
	
	public VendedorDTO() {
		
	}

	public VendedorDTO(Long id,String codigo, String nome, String email, String telefone, String coordenador) {
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;

	}
	
	public VendedorDTO(Vendedor entity) {
		this.id = entity.getId();
		this.codigo = entity.getCodigo();
		this.nome = entity.getNome();
		this.telefone = entity.getTelefone();
		this.email = entity.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
