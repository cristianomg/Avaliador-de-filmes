package View;

import java.util.Scanner;

public class AtualizacaoView extends CadastroView{
	private Scanner sc = new Scanner(System.in);

	public String solicitarNomeFilme() {
		System.out.print("Informe o Titulo do Filme: ");
		String nomeFilme = sc.nextLine();
		return nomeFilme;
		
		
	}
}
