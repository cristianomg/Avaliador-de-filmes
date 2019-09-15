package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Avaliacao {

	private HashMap<Integer, List<Filme>> listaAvaliacao = new HashMap<Integer, List<Filme>>();
	
	public Avaliacao() {
		List<Filme> av1 = new ArrayList<Filme>();
		List<Filme> av2 = new ArrayList<Filme>();
		List<Filme> av3 = new ArrayList<Filme>();
		List<Filme> av4 = new ArrayList<Filme>();
		List<Filme> av5 = new ArrayList<Filme>();
		this.listaAvaliacao.put(1, av1);
		this.listaAvaliacao.put(2, av2);
		this.listaAvaliacao.put(3, av3);
		this.listaAvaliacao.put(4, av4);
		this.listaAvaliacao.put(5, av5);
		
	}
	
	public void avaliar(Integer nota, Filme filme) {
		for (Integer i= 1; i<6; i++) {
			if(this.listaAvaliacao.get(i).contains(filme)) {
				listaAvaliacao.get(i).remove(filme);
			}
		}
		List<Filme> avaliacaoLocal = this.listaAvaliacao.get(nota);
		avaliacaoLocal.add(filme);

		
		
	}

	public HashMap<Integer, List<Filme>> getListaAvaliacao() {
		return listaAvaliacao;
	}
}
