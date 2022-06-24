package br.edu.ifms.aluguel.dto;

import java.io.Serializable;

import br.edu.ifms.aluguel.entities.Carro;
import br.edu.ifms.aluguel.entities.Vendedor;

public class CarroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String carro;
	private String patrimonio;
	private VendedorDTO vendedor;
	
	public CarroDTO() {
		
	}

	public CarroDTO(Long id, String carro, String patrimonio, VendedorDTO vendedor) {
		this.id = id;
		this.carro = carro;
		this.patrimonio = patrimonio;
		this.vendedor = vendedor;
	}
	
	public CarroDTO(Carro entity) {
		this.id = entity.getId();
		this.carro = entity.getCarro();
		this.patrimonio = entity.getPatrimonio();
		this.vendedor = getVendedor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarro() {
		return carro;
	}

	public void setCarro(String carro) {
		this.carro = carro;
	}

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public VendedorDTO getVendedor() {
		return vendedor;
	}

	public void setSetor(VendedorDTO vendedor) {
		this.vendedor = vendedor;
	}
	
	
	
}

