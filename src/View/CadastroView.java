package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroView {
	private Scanner sc = new Scanner(System.in);

	public String[] cadastroFilme(){
		System.out.print("Nome do Filme: ");
		String nomeFilme = sc.nextLine();
		System.out.print("Descri��o do Filme: ");
		String descricao = sc.nextLine();
		String response[] = {nomeFilme, descricao};
		return response;
	}

	public List<String> cadastroCategorias() {
		List<String> response = new ArrayList<String>();
		System.out.println("1- A��o");
		System.out.println("2- Aventura");
		System.out.println("3- Romance");
		System.out.println("4- Drama");
		System.out.println("5- Suspense");
		System.out.println("6- Terror");
		System.out.println("7- finalizar inser��o");
		boolean app = true;
		while (app) {
			System.out.print("Op��o: ");
			String opc = sc.next();
			switch(opc) {
			case "1":
				if(!response.contains("A��o")) {
					response.add("A��o");
				}
				else {
					System.out.println("Categoria j� adicionada.");
				}
				break;
			case "2":
				if(!response.contains("Aventura")){
					response.add("Aventura");
				}
				else {
					System.out.println("Categoria j� adicionada.");
				}
				break;
			case "3":
				if(!response.contains("Romance")) {
					response.add("Romance");
				}
				else {
					System.out.println("Categoria j� adicionada.");
				}
				break;
			case "4":
				if(!response.contains("Drama")) {
					response.add("Drama");
				}
				else {
					System.out.println("Categoria j� adicionada.");
				}
				break;
			case "5":
				if(!response.contains("Suspense")) {
					response.add("Suspense");
				}
				else {
					System.out.println("Categoria j� adicionada.");
				}
				break;
			case "6":
				if(!response.contains("Terror")) {
					response.add("Terror");
				}
				else {
					System.out.println("Categoria j� adicionada.");
				}
				break;
			case "7":
				app = false;
				break;
			default:
				System.out.println("Op��o invalida, tente novamente.");
			}
		}
		return response;
	}
	
	public List<String> cadastroSubCategorias() {
		List<String> response = new ArrayList<String>();
		System.out.println("1- Policial");
		System.out.println("2- Anima��o");
		System.out.println("3- Besteirol");
		System.out.println("4- Brasileiro");
		System.out.println("5- finalizar inser��o");
		boolean app = true;
		while (app) {
			System.out.println("Op��o: ");
			String opc = sc.next();
			switch(opc) {
			case "1":
				if(!response.contains("Policial")) {
					response.add("Policial");
				}
				else {
					System.out.println("Sub Categoria j� adicionada.");
				}
				break;
			case "2":
				if(!response.contains("Anima��o")){
					response.add("Anima��o");
				}
				else {
					System.out.println("Sub Categoria j� adicionada.");
				}
				break;
			case "3":
				if(!response.contains("Besteirol")) {
					response.add("Besteirol");
				}
				else {
					System.out.println("Sub Categoria j� adicionada.");
				}
				break;
			case "4":
				if(!response.contains("Brasileiro")) {
					response.add("Brasileiro");
				}
				else {
					System.out.println("Sub Categoria j� adicionada.");
				}
				break;
			case "5":
				app = false;
				break;
			default:
				System.out.println("Op��o invalida, tente novamente.");
			}
		}
		return response;
	}

	public List<String> cadastroParticipantesFilme() {
		List<String> response = new ArrayList<String>();
		System.out.println("Insira o nome dos participantes do filme [Digite 1 para finalizar]");
		boolean app = true;
		while (app) {
			System.out.print("Nome: ");
			String opc = sc.next();
			if (!opc.equals("1")) {
				response.add(opc);
			}
			else {
				app = false;
			}
		}
		return response;
	}
}
