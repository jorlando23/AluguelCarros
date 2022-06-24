package br.edu.ifms.aluguel.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.ifms.aluguel.entities.enums.Prioridade;
import br.edu.ifms.aluguel.entities.enums.Status;

@Entity
@Table(name = "tb_contrato_aluguel")
public class ContratoAluguel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "data_locacao")
	private String dataLocacao;
	
	@Column(name = "data_devolucao")
	private String dataDevolucao;	
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Enumerated(EnumType.STRING)
	private Prioridade prioridade;
	
	@ManyToOne 
	@JoinColumn(name = "id_cliente_fk")
	private Cliente cliente;
	
	@ManyToMany
	@JoinTable(name = "tb_carro_contrato",
				joinColumns = @JoinColumn(name = "id_contrato"),
				inverseJoinColumns = @JoinColumn(name ="id_carro"))
	
	Set<Carro> carros = new HashSet<>(); //Set permite que não haja duplicidade de dados

	public ContratoAluguel() {
		
	}

	
	
	public ContratoAluguel(Long id, String descricaoProblema, String descricaoSolucao, Status status,
			Prioridade prioridade, Cliente cliente) {
		this.id = id;
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataDevolucao;
		this.status = status;
		this.prioridade = prioridade;
		this.cliente = cliente;
	}



	public ContratoAluguel(Long id, String descricaoProblema, String descricaoSolucao, Status status,
			Prioridade prioridade) {
		this.id = id;
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataDevolucao;
		this.status = status;
		this.prioridade = prioridade;
		
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
	
	
	
	public Set<Carro> getCarros() {
		return carros;
	}
	
	



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContratoAluguel other = (ContratoAluguel) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
