package io.gitHub.AugustoMello09.helpDesk.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.gitHub.AugustoMello09.helpDesk.entities.enums.StatusChamado;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Entity
@Table(name = "tb_chamado")
public class Chamado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime dataAberto;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	private LocalDateTime dataFechamento;
	private StatusChamado statusChamado;
	
	@ManyToOne
	@JoinColumn(name = "tecnico_id", referencedColumnName = "id")
	private Tecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private Cliente cliente;
	
	public Chamado() {}

	public Chamado(Long id, LocalDateTime dataAberto, String descricao, LocalDateTime dataFechamento,
			StatusChamado statusChamado, Tecnico tecnico, Cliente cliente) {
		super();
		this.id = id;
		this.dataAberto = LocalDateTime.now();
		this.descricao = descricao;
		this.dataFechamento = dataFechamento;
		this.statusChamado = StatusChamado.ABERTO;
		this.cliente = cliente;
		this.tecnico = tecnico;
	}
	
	
	
	
	

}