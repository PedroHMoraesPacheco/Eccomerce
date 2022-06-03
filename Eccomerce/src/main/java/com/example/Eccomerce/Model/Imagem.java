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
	
	 @Lob
	 private byte[] imagem;
	
	 @OneToOne
	 @JoinColumn(name = "id_produto")
	 private Produto nome;

	public Imagem() {
		super();
	}

	public Imagem(Long id, byte[] imagem, Produto nome) {
		super();
		this.id = id;
		this.imagem = imagem;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Produto getNome() {
		return nome;
	}

	public void setNome(Produto nome) {
		this.nome = nome;
	}
	 	 
	
	    
}
