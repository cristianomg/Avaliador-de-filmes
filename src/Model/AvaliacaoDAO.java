package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;

public class AvaliacaoDAO {
	private static AvaliacaoDAO uniqueInstance;
	private Avaliacao avaliacao;
	
	private AvaliacaoDAO(){
		this.avaliacao = this.loadAvaliação();
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
	
	public void saveAvaliacao() {
		try {
			FileOutputStream out = new FileOutputStream("avaliacao");
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			
			objOut.writeObject(this.avaliacao);
			objOut.close();
		}
		catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Avaliacao loadAvaliação() {
		if(new File("avaliacao").canRead() == true) {
			try {
				FileInputStream input = new FileInputStream("avaliacao");
				ObjectInputStream objIn = new ObjectInputStream(input);
				Avaliacao avaliacao = (Avaliacao) objIn.readObject();
				objIn.close();
				return avaliacao;
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
		return new Avaliacao();
		
	}
}
