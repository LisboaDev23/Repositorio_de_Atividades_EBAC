package com.gbLisboa.dominio;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_CARRO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Carro {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carro_seq")
	@SequenceGenerator(name="carro_seq", sequenceName="sq_carro", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "codigo", nullable = false, unique = true)
	private String codigo;
	
	@Column(name = "pais_fabricacao", nullable=false)
	private String paisFabricacao;
	
	@Column(name = "modelo", nullable = false)
	private String modelo;
	
	@Column(name = "ano", nullable = false)
	private Integer ano;
	
	@Column(name = "valor",nullable = false)
	private Integer valor;
	
}
