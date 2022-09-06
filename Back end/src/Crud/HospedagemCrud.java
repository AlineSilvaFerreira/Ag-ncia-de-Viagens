package Crud;

import java.util.Scanner;

import classes.Hospedagem;
import dao.HospedagemDAO;

public class HospedagemCrud {

	public static void main(String[] args) {
		HospedagemDAO hospedagemDAO = new HospedagemDAO();

		Scanner entrada = new Scanner(System.in);
		Scanner entrada1 = new Scanner(System.in);

		int opcao = 0;
		int posicao = 0;
		int id = 0;
		String incluso = "";
		int diarias = 0;

		System.out.println("----------- DONNA ------------");
		System.out.println("        Seja bem-vindo!        ");
		System.out.println("------------------------------");
		System.out.println(" ");

		do {
			System.out.println("====== Menu Hospedagem =======");
			System.out.println("    Selecione uma opção:    ");
			System.out.println("1 - Cadastrar hospedagem");
			System.out.println("2 - Consultar hospedagem");
			System.out.println("3 - Atualizar hospedagem");
			System.out.println("4 - Deletar hospedagem");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			System.out.println("==============================");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1:
				// Cadastrar
				System.out.println(" ");
				System.out.println("-------------- CADASTRO --------------");
				System.out.println("\nDigite o item incluso: ");
				incluso = entrada1.nextLine();
				System.out.println("Digite a quantidade de diárias: ");
				diarias = entrada1.nextInt();

				Hospedagem h = new Hospedagem(id, incluso, diarias);

				hospedagemDAO.save(h);

				System.out.println("\n-- Hospedagem cadastrada com sucesso! --\n");
				System.out.println(" ");
				break;
								
			case 2:
				//Consultar
				System.out.println(" ");
				System.out.println("---------- CONSULTA ----------\n");
				for (Hospedagem h1 : hospedagemDAO.getHospedagem()) {
				
					System.out.println("- Id: " + h1.getId());
					System.out.println("- Itens inclusos: " + h1.getIncluso());	
					System.out.println("- Diárias: " + h1.getDiarias());	
					System.out.println(" ");
				}
				
				System.out.println("----- Fim da consulta. ------\n");
				break;
				
			case 3:
				//Atualizar
				System.out.println(" ");
				System.out.println("-------- ATUALIZAÇÃO ----------");
				System.out.println("\nDigite o id da hospedagem: ");
				posicao = entrada.nextInt();
								
				System.out.println("Digite o item incluso: ");
				incluso = entrada1.nextLine();
				System.out.println("Digite a quantidade de diárias: ");
				diarias = entrada.nextInt();
								
				Hospedagem h2 = new Hospedagem(posicao, incluso, diarias);
			
				hospedagemDAO.update(h2);
	
				System.out.println("\n---- Hospedagem atualizada! ----\n");
				break;
				
			case 4:
				//Deletar
				System.out.println(" ");
				System.out.println("----------------- DELETAR -----------------");
				System.out.println("\nDigite o id da hospedagem que deseja deletar: ");
				posicao = entrada.nextInt();
				
				hospedagemDAO.deleteById(posicao);
				System.out.println("\n------ Hospedagem deletada com sucesso! -----\n");
				break;
				
			case 5:
				//Buscar por id
				System.out.println(" ");
				System.out.println("------------ BUSCA ------------");
				System.out.println("\nDigite o id da hospedagem: ");
				posicao = entrada.nextInt();
				
				Hospedagem h3 = hospedagemDAO.getHospedagemById(posicao);
				
				System.out.println("\nId: " + h3.getId());
				System.out.println("Item incluso: " + h3.getIncluso());
				System.out.println("Diárias: " + h3.getDiarias());
				System.out.println("\n-------- Fim da busca. --------\n");	
				
				break;
				
				default:
					if (opcao != 0) {
						System.out.println("\nOpção invalida, digite novamente.\n");
						}
				
			}
		} while (opcao != 0);
		
		System.out.println(" ");
		System.out.println("----------- DONNA ------------");
		System.out.println("     Agradecemos a visita!    ");
		System.out.println("        Até a próxima.        ");
		System.out.println("------------------------------");

		entrada.close();
		entrada1.close();
	}

}
