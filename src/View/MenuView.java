package View;


import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.ControllerPrincipal;



public class MenuView {
	private ControllerPrincipal controller = new ControllerPrincipal();
	private Scanner sc = new Scanner(System.in);
	
	
	
	public void menuPrincipal() {
		Integer opc;
		try {
			System.out.println("1- Cadastrar Filme");
			System.out.println("2- Atualizar Filme");
			System.out.println("3- Remover Filme");
			System.out.println("4- Consultar Filme");
			System.out.println("5- Avaliar filme");
			opc = sc.nextInt();
			switch(opc) {
			case 1:
				controller.cadastrarFilme();
				break;
			case 2:
				controller.atualizarFilme();
				break;
			case 3:
				controller.removerFilme();
				break;
			case 4:
				controller.consultar();
				break;
			case 5:
				controller.avaliar();
			}
		}
		catch (InputMismatchException e) {
			System.out.println("Opção invalida, tente novamente.");

			this.menuPrincipal();
		}
	}
	
}
