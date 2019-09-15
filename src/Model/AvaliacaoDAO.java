package Model;

import java.util.HashMap;
import java.util.List;

public class AvaliacaoDAO {
	private static AvaliacaoDAO uniqueInstance;
	private Avaliacao avaliacao;
	
	private AvaliacaoDAO(){
		this.avaliacao = new Avaliacao();
	}
	
	public static synchronized AvaliacaoDAO getInstance() {
		
		if (uniqueInstance == null){
			uniqueInstance = new AvaliacaoDAO();
		}
		return uniqueInstance;
	}	
	
	public Avaliacao get() {
		return avaliacao;
	}
	
	public List<Filme> getFilmes(Integer notaMinima) {
		HashMap<Integer, List<Filme>> response = this.avaliacao.getListaAvaliacao(); 
		return response.get(notaMinima);
	}
}
