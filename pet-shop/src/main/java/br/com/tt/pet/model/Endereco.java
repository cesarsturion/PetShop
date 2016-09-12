package br.com.tt.pet.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(generator = "endereco_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "endereco_seq", sequenceName = "endereco_seq", allocationSize = 1, initialValue = 10)

	@Column(name = "id_endereco")
	private Long id;

	@Column(length = 60)
	private String rua;

	@Column(length = 10)
	private String cep;

	@Column(length = 60)
	private String bairro;

	@Column(length = 60)
	private String cidade;

	@OneToOne(mappedBy = "endereco", cascade = { CascadeType.ALL })
	private Proprietario proprietario_end;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_fornecedor")
	private Fornecedor fornecedor_end;

	public Endereco() {
		super();
	}

	public Endereco(String rua, String bairro, String cidade, String cep) {

		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Proprietario getProprietario_end() {
		return proprietario_end;
	}

	public void setProprietario_end(Proprietario proprietario_end) {
		this.proprietario_end = proprietario_end;
	}

	public Fornecedor getFornecedor_end() {
		return fornecedor_end;
	}

	public void setFornecedor_end(Fornecedor fornecedor_end) {
		this.fornecedor_end = fornecedor_end;
	}

}