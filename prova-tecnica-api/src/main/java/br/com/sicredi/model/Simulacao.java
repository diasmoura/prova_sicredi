package br.com.sicredi.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class Simulacao implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	private String email;
	private int valor;
	private Integer parcelas;
	private Boolean seguro;

	public Simulacao(String nome, String cpf, String email, int valor, int parcelas, boolean seguro) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.valor = valor;
		this.parcelas = parcelas;
		this.seguro = seguro;

	}

}
