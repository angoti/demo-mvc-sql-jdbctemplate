package com.example.demo.model;

import java.sql.Date;

import javax.validation.constraints.NotNull;

public class Aluno implements java.io.Serializable {

	private Usuario usuario;
	private String matricula;
	private String nomeMae;
	private String nomePai;
	private Date dataMatricula;
	@NotNull
	private Integer telResponsavel;

	public Aluno() {
	}

	public Aluno(Usuario usuario, String matricula, String nomeMae, String nomePai, Date dataMatricula,
			Integer telResponsavel) {
		this.usuario = usuario;
		this.matricula = matricula;
		this.nomeMae = nomeMae;
		this.nomePai = nomePai;
		this.dataMatricula = dataMatricula;
		this.telResponsavel = telResponsavel;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomeMae() {
		return this.nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return this.nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public Date getDataMatricula() {
		// SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		// return formatter.format(dataMatricula);
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Integer getTelResponsavel() {
		return this.telResponsavel;
	}

	public void setTelResponsavel(Integer telResponsavel) {
		this.telResponsavel = telResponsavel;
	}

}
