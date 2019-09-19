package View;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Model.Filme;

public class ConsultaView extends AtualizacaoView {
	public Scanner sc = new Scanner(System.in);
	
	public int consultaMenu() throws IOException{
		System.out.println("1- Consultar por Nome");
		System.out.println("2- Consultar por Categoria");
		System.out.println("3- Consultar por Sub Categoria");
		System.out.println("4- Consultar por Participantes do Filme");
		System.out.println("5- Consultar por avaliação");
		int opc = sc.nextInt();
		if (opc > 0  && opc < 6) {
			return opc;
		}
		else {
			throw new IOException("Opção invalida!");
		}
	}
	public void listarFilmes(List<Filme> filmes) {
		System.out.println("----------------------------------------------------");
		for(Filme f: filmes) {
			System.out.println("Nome do Filme: " + f.getNomeFilme());
			System.out.println("Avaliação: "+ f.getClassificacao());
			System.out.print("Categorias: ");
			String categorias = String.join(", ", f.getCategorias());
			System.out.print(categorias);
			System.out.println();
			System.out.print("SubCategorias: ");
			String subCategorias = String.join(", ", f.getSubcategorias());
			System.out.print(subCategorias);
			System.out.println();
			System.out.print("Elenco: ");
			String elenco = String.join(", ", f.getParticipantesFilme());
			System.out.print(elenco);
			System.out.println();
			System.out.print("Descrição: ");
			System.out.print(f.getDescricao());
			System.out.println();
			System.out.println("----------------------------------------------------");
		}
	}
	
}
