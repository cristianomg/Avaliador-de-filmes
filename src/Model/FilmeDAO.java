package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Exceptions.FilmeNaoEncontradoException;

public class FilmeDAO {
	private static FilmeDAO uniqueInstance;
	private List<Filme> listaFilmes;
	
	private FilmeDAO(){
		this.listaFilmes = this.loadFilmes();
	}
	
	public static synchronized FilmeDAO getInstance() {
		
		if (uniqueInstance == null){
			uniqueInstance = new FilmeDAO();
		}
		return uniqueInstance;
	}
	
	
	public void insert(Filme filme) {
		boolean contem = false;
		for(Filme f: listaFilmes) {
			if(f.getNomeFilme().equals(filme.getNomeFilme())) {
				contem = true;
			}
		}
		if (!contem) {
			listaFilmes.add(filme);
			this.saveFilmes();
		}
		else {
			System.out.println("Filme já cadastrado.");
		}
		
	}
	public boolean remove(Filme filme) {
		for (Filme f: listaFilmes) {
			if (f.getNomeFilme().equals(filme.getNomeFilme())) {
				listaFilmes.remove(filme);
				this.saveFilmes();
				return true;
			}
		}
		return false;
	}
	public void update(Filme filmeAntes, Filme filmeAtualizado) throws FilmeNaoEncontradoException {
		boolean removido = false;
		for(Filme filme: listaFilmes) {
			if (filmeAntes.getNomeFilme().equals(filme.getNomeFilme())) {
				this.remove(filmeAntes);
				this.insert(filmeAtualizado);
				this.saveFilmes();
				removido = true;
				break;
				}
			}
			if(!removido){
				throw new FilmeNaoEncontradoException("Titulo n�o encontrado.");
			}	
		}

	
	public boolean contains(String nome) {
		for(Filme f: listaFilmes) {
			if(f.getNomeFilme().equals(nome)) {
				return true;
			}
		}
		return false;
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
	public void saveFilmes() {
		try {
			FileOutputStream out = new FileOutputStream("filmes");
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			
			objOut.writeObject(this.listaFilmes);
			objOut.close();
		}
		catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Filme> loadFilmes() {
		if(new File("filmes").canRead() == true) {
			try {
				FileInputStream input = new FileInputStream("filmes");
				ObjectInputStream objIn = new ObjectInputStream(input);
				List<Filme> listaFilmes =  (List<Filme>) objIn.readObject();
				objIn.close();
				return listaFilmes;
			}
			catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			catch(ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
			catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return new ArrayList<Filme>();
		
	}
}
