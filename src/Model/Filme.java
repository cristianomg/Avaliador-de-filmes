package Model;

import java.util.ArrayList;
import java.util.List;

public class Filme {
	private String nomeFilme;
	private String descricao;
	private List<String> categorias= new ArrayList<String>();
	private List<String> subcategorias = new ArrayList<String>();
	private List<String> participantesFilme = new ArrayList<String>();
	private Integer classificacao;
	
	public Filme(String nomeFilme, String descricao, List<String> categorias,
			List<String> subcategorias, List<String> participantesFilme) {
	
		this.nomeFilme = nomeFilme;
		this.descricao = descricao;
		this.categorias = categorias;
		this.subcategorias = subcategorias;
		this.participantesFilme = participantesFilme;
	}
	
	

	public Filme(String nomeFilme, String descricao) {
		super();
		this.nomeFilme = nomeFilme;
		this.descricao = descricao;
	}



	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}

	public List<String> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(List<String> subcategorias) {
		this.subcategorias = subcategorias;
	}

	public List<String> getParticipantesFilme() {
		return participantesFilme;
	}

	public void setParticipantesFilme(List<String> participantesFilme) {
		this.participantesFilme = participantesFilme;
	}

	public Integer getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}

}
