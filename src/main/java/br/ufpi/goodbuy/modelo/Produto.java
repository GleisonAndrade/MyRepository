package br.ufpi.goodbuy.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author Gleison
 *
 */
@Entity
public class Produto{
	@Id
	@GeneratedValue
	private Long id;
	@NotNull @Length(min = 3)
	private String nome;
	@NotNull @Length(max=40)
	private String descricao;
	@Min(0) 
	private Double preco;

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + ", preco=" + preco + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
