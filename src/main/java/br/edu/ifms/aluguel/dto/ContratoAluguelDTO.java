package br.edu.ifms.aluguel.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.edu.ifms.aluguel.entities.Carro;
import br.edu.ifms.aluguel.entities.ContratoAluguel;
import br.edu.ifms.aluguel.entities.Cliente;
import br.edu.ifms.aluguel.entities.enums.Prioridade;
import br.edu.ifms.aluguel.entities.enums.Status;

public class ContratoAluguelDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Long id;
	

	private String dataLocacao;
	private String dataDevolucao;
	private Status status;
	private Prioridade prioridade;
	private Cliente cliente;
	private List<CarroDTO> carros = new ArrayList<>();
	
	public ContratoAluguelDTO() {
		
	}

	public ContratoAluguelDTO(ContratoAluguel entity) {
		this.id = entity.getId();
		this.dataLocacao = entity.getDataLocacao();
		this.dataDevolucao = entity.getDataDevolucao();
		this.status = entity.getStatus();
		this.prioridade = entity.getPrioridade();
		this.cliente = entity.getCliente();
	}
	
	public ContratoAluguelDTO(ContratoAluguel entity, Set<Carro> carros) {
		this(entity);
		carros.forEach(carro -> new CarroDTO(carro));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<CarroDTO> getCarros() {
		return carros;
	}
	
	
}
