package com.example.Eccomerce.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity

public class Imagem {
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;
	
	 private String nome;
	
	 public String mimetype;
	 
	 @Lob
	 private byte[] data;
	
	 @OneToOne
	 @JoinColumn(name = "imagem")
	 private Produto produto;

	public Imagem() {
		super();
	}

	public Imagem(Long id, String nome, String mimetype, byte[] data, Produto produto) {
		super();
		this.id = id;
		this.nome = nome;
		this.mimetype = mimetype;
		this.data = data;
		this.produto = produto;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	 
	 
	
}