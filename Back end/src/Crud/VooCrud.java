package Crud;

import java.util.Scanner;

import classes.Voo;
import dao.VooDAO;

public class VooCrud {

	public static void main(String[] args) {
		VooDAO vooDAO = new VooDAO();

		Scanner entrada = new Scanner(System.in);
		Scanner entrada1 = new Scanner(System.in);

		int opcao = 0;
		int posicao = 0;
		int id = 0;
		String origem = "", destino = "";
		String dataIda, dataVolta;
		double valor = 0;

		System.out.println("------------- DONNA --------------");
		System.out.println("          Seja bem-vindo          ");
		System.out.println("----------------------------------");
		System.out.println(" ");

		do {
			System.out.println("====== Menu voos =======");
			System.out.println("  Selecione uma opção:  ");
			System.out.println("1 - Cadastrar voo");
			System.out.println("2 - Consultar voo");
			System.out.println("3 - Atualizar voo");
			System.out.println("4 - Deletar voo");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			System.out.println("========================");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1:
				// Cadastrar
				System.out.println(" ");
				System.out.println("-------------- CADASTRO --------------");
				System.out.println("\nDigite a origem do voo: ");
				origem = entrada1.nextLine();
				System.out.println("Digite o destino do voo: ");
				destino = entrada1.nextLine();
				System.out.println("Digite a data de ida: ");
				dataIda = entrada1.nextLine();
				System.out.println("Digite a data de volta: ");
				dataVolta = entrada1.nextLine();
				System.out.println("Digite o valor do voo: ");
				valor = entrada1.nextDouble();

				Voo v1 = new Voo(id, origem, destino, dataIda, dataVolta, valor);

				vooDAO.save(v1);

				System.out.println("\n-- Voo cadastrado com sucesso! --\n");
				System.out.println(" ");
				break;

			case 2:
				// Consultar
				System.out.println(" ");
				System.out.println("---------- CONSULTA ----------\n");

				for (Voo v : vooDAO.getVoo()) {
					System.out.println("- Id: " + v.getId());
					System.out.println("- Origem: " + v.getOrigem());
					System.out.println("- Destino: " + v.getDestino());
					System.out.println("- Data da ida: " + v.getDataIda());
					System.out.println("- Data da volta: " + v.getDataVolta());
					System.out.println("- Valor: R$" + v.getValor());
					System.out.println(" ");
				}

				System.out.println("----- Fim da consulta. ------\n");
				break;

			case 3:
				// Atualizar
				System.out.println(" ");
				System.out.println("-------- ATUALIZAÇÃO ----------");

				System.out.println("\nDigite o id do voo a ser atualizado:");
				posicao = entrada.nextInt();
				entrada.nextLine();

				System.out.println("Digite a origem do voo: ");
				origem = entrada1.nextLine();
				System.out.println("Digite o destino do voo: ");
				destino = entrada1.nextLine();
				System.out.println("Digite a data de ida: ");
				dataIda = entrada1.nextLine();
				System.out.println("Digite a data de volta: ");
				dataVolta = entrada1.nextLine();
				System.out.println("Digite o valor do voo: ");
				valor = entrada1.nextDouble();

				Voo v2 = new Voo(posicao, origem, destino, dataIda, dataVolta, valor);

				vooDAO.update(v2);

				System.out.println("\n---- Voo atualizada! ----\n");
				break;

			case 4:
				// Deletar
				System.out.println(" ");
				System.out.println("----------------- DELETAR -----------------");
				System.out.println("\nDigite o id do voo que deseja deletar: ");
				posicao = entrada.nextInt();

				vooDAO.deleteById(posicao);
				System.out.println("\n------ Voo deletado com sucesso! -----\n");
				break;

			case 5:
				// Buscar por id
				System.out.println(" ");
				System.out.println("------------ BUSCA ------------");
				System.out.println("\nDigite o id do voo: ");
				posicao = entrada.nextInt();

				Voo v = vooDAO.getVooById(posicao);

				System.out.println("\nId: " + v.getId());
				System.out.println("Origem: " + v.getOrigem());
				System.out.println("Destino: " + v.getDestino());
				System.out.println("Data da ida: " + v.getDataIda());
				System.out.println("Data da volta: " + v.getDataVolta());
				System.out.println("Valor: R$" + v.getValor());
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
		System.out.println("----------- DONNA ------------");
		System.out.println("     Agradecemos a visita!    ");
		System.out.println("        Até a próxima.        ");
		System.out.println("------------------------------");		

		entrada.close();
		entrada1.close();
	}

}
