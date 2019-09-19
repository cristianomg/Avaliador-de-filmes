package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exceptions.FilmeNaoEncontradoException;
import Model.Avaliacao;
import Model.AvaliacaoDAO;
import Model.Filme;
import Model.FilmeDAO;
import View.AtualizacaoView;
import View.CadastroView;
import View.ConsultaView;
import View.MenuView;

public class ControllerPrincipal {
	private static FilmeDAO filmes = FilmeDAO.getInstance();
	private static AvaliacaoDAO avaliacao = AvaliacaoDAO.getInstance();
	private Scanner sc = new Scanner(System.in);
	private CadastroView cadastroView = new CadastroView();
	private AtualizacaoView atualizacaoView = new AtualizacaoView();
	private ConsultaView consultaView = new ConsultaView();
	
	
	public void cadastrarFilme() {
		System.out.printf("%-20s%s%-20s", "--------------------","Cadastrar Filme" ,"--------------------");
		System.out.println();
		String [] filme = cadastroView.cadastroFilme();
		String nomeFilme = filme[0];
		String descricao= filme[1];
		if(!filmes.contains(nomeFilme)) {
			List<String> categoria = cadastroView.cadastroCategorias();
			List<String> subcategoria = cadastroView.cadastroSubCategorias();
			List<String> participantesFilme = cadastroView.cadastroParticipantesFilme();
			Filme newFilme = new Filme(nomeFilme, descricao, categoria, subcategoria, participantesFilme);
			filmes.insert(newFilme);
			System.out.println("Cadastro realizado com sucesso.");
		}
		else {
			System.out.println("O titulo já está cadastrado.");
		}
		voltarMenu();
	}
	
	public void atualizarFilme() {
		System.out.printf("%-20s%s%-20s", "--------------------","Atualizar Filme" ,"--------------------");
		System.out.println();
		String Filme = atualizacaoView.solicitarNomeFilme();
		try {
			Filme filmeAnterior = filmes.getByName(Filme);
			System.out.println("Informe os novos dados");
			String [] filme = cadastroView.cadastroFilme();
			String nomeFilme = filme[0];
			String descricao= filme[1];
			List<String> categoria = cadastroView.cadastroCategorias();
			List<String> subcategoria = cadastroView.cadastroSubCategorias();
			List<String> participantesFilme = cadastroView.cadastroParticipantesFilme();
			Filme newFilme = new Filme(nomeFilme, descricao, categoria, subcategoria, participantesFilme);
			filmes.update(filmeAnterior, newFilme);
			System.out.println("Atualização realizada com sucesso.");
			voltarMenu();
		} catch (FilmeNaoEncontradoException e) {
			System.out.println(e.getMessage());
			voltarMenu();
		}

	}
	
	public void removerFilme() {
		System.out.printf("%-20s%s%-20s", "--------------------","Remover Filme" ,"--------------------");
		System.out.println();
		String nomeFilme = atualizacaoView.solicitarNomeFilme();
		try {
			Filme filme = filmes.getByName(nomeFilme);
			filmes.remove(filme);
			System.out.println("Remção realizada com sucesso.");
			voltarMenu();
		} catch (FilmeNaoEncontradoException e) {
			System.out.println(e.getMessage());
			voltarMenu();
		}
	}
	
	public void consultar() {
		Integer opc;
		try {
			opc = consultaView.consultaMenu();
			switch(opc) {
			case 1:
				try {
					String nomeFilme = consultaView.solicitarNomeFilme();
					Filme filme = filmes.getByName(nomeFilme);
					List<Filme> listFilmes = new ArrayList<Filme>();
					listFilmes.add(filme);
					consultaView.listarFilmes(listFilmes);
				} catch (FilmeNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				List<String> categorias = consultaView.cadastroCategorias();
				try {
					List<Filme> listFilmes = filmes.getByCategoria(categorias);
					consultaView.listarFilmes(listFilmes);
				} catch (FilmeNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				List<String> subCategoria = consultaView.cadastroSubCategorias();
				try {
					List<Filme> listFilmes = filmes.getBySubCategoria(subCategoria);
					consultaView.listarFilmes(listFilmes);
				} catch (FilmeNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				List<String> participantes = consultaView.cadastroParticipantesFilme();
				try {
					List<Filme> listFilmes = filmes.getByPessoa(participantes);
					consultaView.listarFilmes(listFilmes);
				} catch (FilmeNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				System.out.print("Informe a nota de avaliação minima para a busca: ");
				Integer nota = sc.nextInt();
				for(Integer i = 5; i>= nota; i--) {
					List<Filme> listFilmes = avaliacao.getFilmes(i);  // solicitar o nome do filme para a view
					if(listFilmes.size() > 0) {
						consultaView.listarFilmes(listFilmes);
					}
				}
				break;
			}
			voltarMenu();
		} catch (IOException e1) {
			opc = null;
			System.out.println(e1.getMessage());
			voltarMenu();
		}
	}
	public void voltarMenu() {
		MenuView menu = new MenuView();
		System.out.print("Digite '1' para voltar para o menu: ");
		String opc = sc.next();
		if (opc.equals("1")) {
		menu.menuPrincipal();
		}
		else {
			System.out.println("Opção invalida");
			voltarMenu();
			}
		}

	public void avaliar() {
		Filme filme;
		try {
			filme = filmes.getByName(consultaView.solicitarNomeFilme());
			Filme filmeAntes = filme;
			Avaliacao newAvaliacao = avaliacao.get();
			System.out.print("Qual a nota do filme: ");
			Integer nota = sc.nextInt();
			newAvaliacao.avaliar(nota, filmeAntes);
			filmeAntes.setClassificacao(nota);
			avaliacao.saveAvaliacao();
			System.out.println("Avaliação realizada com sucesso.");
			voltarMenu();
		} catch (FilmeNaoEncontradoException e) {
			System.out.println(e.getMessage());
			voltarMenu();
		}
		

	}
}
	

