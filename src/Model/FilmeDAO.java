package Model;

import java.util.ArrayList;
import java.util.List;

import Exceptions.FilmeNaoEncontradoException;

public class FilmeDAO {
	private static FilmeDAO uniqueInstance;
	private List<Filme> listaFilmes = new ArrayList<Filme>();
	
	private FilmeDAO(){
	}
	
	public static synchronized FilmeDAO getInstance() {
		
		if (uniqueInstance == null){
			uniqueInstance = new FilmeDAO();
		}
		return uniqueInstance;
	}
	
	
	public void insert(Filme filme) {
		listaFilmes.add(filme);
		
	}
	public boolean remove(Filme filme) {
		return listaFilmes.remove(filme);
		
	}
	public void update(Filme filmeAntes, Filme filmeAtualizado) throws FilmeNaoEncontradoException {
		boolean removido = this.remove(filmeAntes);
		if (removido) {
			this.insert(filmeAtualizado);
		}
		else {
			throw new FilmeNaoEncontradoException("Titulo não encontrado.");
		}
	}
	
	public List<Filme> getList(){
		return listaFilmes;
	}
	
	public Filme getByName(String nomeFilme) throws FilmeNaoEncontradoException{
		for(Filme f: listaFilmes) {
			if (f.getNomeFilme().equals(nomeFilme)) {
				return f;
			}
		}
		throw new FilmeNaoEncontradoException("Nenhum filme encontrado com esse titulo.");
	}
	
	public List<Filme> getByCategoria(List<String> categorias) throws FilmeNaoEncontradoException{
		List<Filme> response = new ArrayList<Filme>();
		for (Filme f: listaFilmes) {
			for (String categoria: categorias) {
				if(f.getCategorias().contains(categoria)){
					if(!response.contains(f)) {
					response.add(f);
					}
				}
			}
		}
		if (response.size()>0) {
			return response;
		}
		else {
			throw new FilmeNaoEncontradoException("Nenhum filme com as categorias selecionadas foi encontrado.");
		}
	}
	public List<Filme> getBySubCategoria(List<String> subCategorias) throws FilmeNaoEncontradoException{
		List<Filme> response = new ArrayList<Filme>();
		for (Filme f: listaFilmes) {
			for (String subCategoria: subCategorias){
				if(f.getSubcategorias().contains(subCategoria)) {	
					if(!response.contains(f)) {
						response.add(f);
					}
				}
			}
		}
		if (response.size()>0) {
			return response;
		}
		else {
			throw new FilmeNaoEncontradoException("Nenhum filme com as sub categorias selecionadas foi encontrado.");
		}
	}
	
	public List<Filme> getByPessoa(List<String> pessoas)throws FilmeNaoEncontradoException{
		List<Filme> response = new ArrayList<Filme>();
		for (Filme f: listaFilmes) {
			for (String pessoa: pessoas){
				if(f.getParticipantesFilme().contains(pessoa)) {
					if(!response.contains(f)) {
						response.add(f);
					}
				}
			}
		}
		if (response.size()>0) {
			return response;
		}
		else {
			throw new FilmeNaoEncontradoException("Nenhum filme com os atores e/ou diretores selecionados foi encontrado.");
		}
	}
}
