package Crud;

import java.util.Scanner;

import classes.Reserva;
import classes.Pacote;
import classes.Itens_reserva;
import dao.Itens_reservaDAO;
import dao.PacoteDAO;
import dao.ReservaDAO;

public class Itens_reservaCrud {

	public static void main(String[] args) {
		Itens_reservaDAO itens_reservaDAO = new Itens_reservaDAO();

		PacoteDAO pacoteDAO = new PacoteDAO();
		ReservaDAO reservaDAO = new ReservaDAO();

		Scanner entrada = new Scanner(System.in);
		Scanner entrada1 = new Scanner(System.in);

		int opcao = 0;
		int posicao = 0;

		int id = 0;
		int qtd = 0;
		int id_pacote = 0;
		int id_reserva = 0;

		System.out.println("----------- DONNA ------------");
		System.out.println("        Seja bem-vindo        ");
		System.out.println("------------------------------");
		System.out.println(" ");

		do {
			System.out.println("=== Menu itens da reserva ===");
			System.out.println("1 - Cadastrar itens");
			System.out.println("2 - Consultar itens");
			System.out.println("3 - Atualizar itens");
			System.out.println("4 - Deletar itens");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = entrada.nextInt();
			entrada.nextLine();

			switch (opcao) {
			case 1:
				// Cadastrar
				System.out.println(" ");
				System.out.println("------------- CADASTRO --------------");
				System.out.println("\nDigite a quantidade: ");
				qtd = entrada1.nextInt();
				System.out.println("Digite o id do pacote: ");
				id_pacote = entrada1.nextInt();
				System.out.println("Digite o id da reserva: ");
				id_reserva = entrada1.nextInt();

				Pacote pacote = pacoteDAO.getPacoteById(id_pacote);
				Reserva reserva = reservaDAO.getReservaById(id_reserva);

				Itens_reserva i = new Itens_reserva(id, qtd, pacote, reserva);

				itens_reservaDAO.save(i);

				System.out.println("\n-- Item cadastrado com sucesso! --\n");
				System.out.println(" ");

				break;

			case 2:
				// Consultar
				System.out.println(" ");
				System.out.println("---------- CONSULTA ----------\n");

				for (Itens_reserva i1 : itens_reservaDAO.getItens_reserva()) {

					System.out.println("- Id: " + i1.getId());
					System.out.println("- Id pacote: " + i1.getPacote().getId());
					System.out.println("- Quantidade: " + i1.getQuantidade());
					System.out.println("- Valor total: R$" + i1.getValor());
					System.out.println("  ");
				}

				System.out.println("----- Fim da consulta. ------\n");
				break;
				
			case 3:
				//Atualizar
				System.out.println(" ");
				System.out.println("-------- ATUALIZAÇÃO ----------");
				System.out.println("\nDigite o id do item: ");
				posicao = entrada.nextInt();
				
				System.out.println("Digite a quantidade: ");
				qtd = entrada1.nextInt();
				System.out.println("Digite o id do pacote: ");
				id_pacote = entrada1.nextInt();
				System.out.println("Digite o id da reserva: ");
				id_reserva = entrada1.nextInt();

				Pacote pacote1 = pacoteDAO.getPacoteById(id_pacote);
				Reserva reserva1 = reservaDAO.getReservaById(id_reserva);
								
				Itens_reserva i1 = new Itens_reserva(posicao, qtd, pacote1, reserva1);
			
				itens_reservaDAO.update(i1);
	
				System.out.println("\n---- Item atualizado! ----\n");
				break;
				
			case 4:
				//Deletar
				System.out.println(" ");
				System.out.println("----------------- DELETAR -----------------");
				System.out.println("\nDigite o id do item que deseja deletar: ");
				posicao = entrada.nextInt();

				itens_reservaDAO.deleteById(posicao);
				System.out.println("\n------ Item deletado com sucesso! -----\n");
				
				break;
				
			case 5:
				//Buscar por id
				System.out.println(" ");
				System.out.println("------------ BUSCA ------------");
				System.out.println("\nDigite o id do item: ");
				posicao = entrada.nextInt();

				Itens_reserva i2 = itens_reservaDAO.getItensById(posicao);

					System.out.println("- Id: " + i2.getId());
					System.out.println("- Id reserva: " + i2.getReserva().getId());
					System.out.println("- Id pacote: " + i2.getPacote().getId());
					System.out.println("- Quantidade: " + i2.getQuantidade());
					System.out.println("- Valor total: R$" + i2.getValor());
				
				System.out.println("\n-------- Fim da busca. --------\n");

				break;
			default:
				if (opcao != 0) {
					System.out.println("\nOpção invalida, digite novamente.\n");
					}
				break;
			}
		} while (opcao != 0);
		
		System.out.println(" ");
		System.out.println("---------------- DONNA -----------------");
		System.out.println("          Agradecemos a visita!         ");
		System.out.println("             Até a próxima.             ");
		System.out.println("-----------------------------------------");
		
		entrada.close();
		entrada1.close();		
	}

}
