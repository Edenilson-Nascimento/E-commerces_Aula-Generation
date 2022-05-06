package com.generation.farmacia.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message= "O atribulo Medicamento não deve ser preenchido")
	private String medicamento;
	
	@NotNull(message = "O atributo Nome comercialdeve ser preenchido ")
	private String nome_comercial;
	
	
	private String dosagem;
	
	@NotNull
	@Positive
	private BigDecimal preco;
	
	
	private String marca;
	
	
	private int quantidade;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMedicamento() {
		return medicamento;
	}


	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}


	public String getNome_comercial() {
		return nome_comercial;
	}


	public void setNome_comercial(String nome_comercial) {
		this.nome_comercial = nome_comercial;
	}


	public String getDosagem() {
		return dosagem;
	}


	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	

}
