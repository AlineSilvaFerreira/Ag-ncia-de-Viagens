package Crud;

import java.util.Scanner;

import classes.Pacote;
import classes.Hospedagem;
import classes.Voo;
import dao.PacoteDAO;
import dao.HospedagemDAO;
import dao.VooDAO;

public class PacoteCrud {

	public static void main(String[] args) {
		PacoteDAO pacoteDAO = new PacoteDAO();
		HospedagemDAO hospedagemDAO = new HospedagemDAO();
		VooDAO vooDAO = new VooDAO();

		Scanner entrada = new Scanner(System.in);
		Scanner entrada1 = new Scanner(System.in);

		int opcao = 0;
		int posicao = 0;

		int id = 0;
		double valor = 0;
		int desconto = 0;
		int id_hospedagem = 0;
		int id_voo = 0;

		System.out.println("----------- DONNA ------------");
		System.out.println("        Seja bem-vindo        ");
		System.out.println("------------------------------");
		System.out.println(" ");

		do {
			System.out.println("=== Menu Pacote ===");
			System.out.println("1 - Cadastrar pacotes");
			System.out.println("2 - Consultar pacotes");
			System.out.println("3 - Atualizar pacotess");
			System.out.println("4 - Deletar pacotes");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = entrada.nextInt();
			entrada.nextLine();

			switch (opcao) {
			case 1:
				// Cadastrar
				System.out.println(" ");
				System.out.println("------------- CADASTRO --------------");
				System.out.println("\nDigite o valor do pacote: ");
				valor = entrada1.nextDouble();
				System.out.println("Digite o desconto em porcentagem: ");
				desconto = entrada1.nextInt();
				System.out.println("Digite o id da hospedagem: ");
				id_hospedagem = entrada1.nextInt();
				System.out.println("Digite o id do voo: ");
				id_voo = entrada1.nextInt();

				Hospedagem hospedagem = hospedagemDAO.getHospedagemById(id_hospedagem);
				Voo voo = vooDAO.getVooById(id_voo);

				Pacote p = new Pacote(id, valor, desconto, hospedagem, voo);

				pacoteDAO.save(p);

				System.out.println("\n-- Pacote cadastrado com sucesso! --\n");
				System.out.println(" ");

				break;
				
			case 2:
				//Consultar
				System.out.println(" ");
				System.out.println("---------- CONSULTA ----------\n");
				
				for (Pacote p1 : pacoteDAO.getPacote()) {
				
					System.out.println("- Id: " + p1.getId());
					System.out.println("- Destino: " + p1.getVoo().getDestino());
					System.out.println("- Data Ida: " + p1.getVoo().getDataIda());
					System.out.println("- Quantidade diárias: " + p1.getHospedagem().getDiarias());
					System.out.println("- Incluso: " + p1.getHospedagem().getIncluso());
					System.out.println("- Valor: R$" + p1.getValor());	
					System.out.println("- Desconto: " + p1.getDesconto()+ "%");
					System.out.println("- Valor final: R$" + p1.calcularPromocao());
					System.out.println("  ");
				}
				
				System.out.println("----- Fim da consulta. ------\n");
				break;
				
			case 3:
				//Atualizar
				System.out.println(" ");
				System.out.println("-------- ATUALIZAÇÃO ----------");
				System.out.println("\nDigite o id do pacote: ");
				posicao = entrada.nextInt();
						
				System.out.println("Digite o valor do pacote: ");
				valor = entrada1.nextDouble();
				System.out.println("Digite o desconto em porcentagem: ");
				desconto = entrada1.nextInt();
				System.out.println("Digite o id da hospedagem: ");
				id_hospedagem = entrada1.nextInt();
				System.out.println("Digite o id do voo: ");
				id_voo = entrada1.nextInt();
				
				Hospedagem hospedagem1 = hospedagemDAO.getHospedagemById(id_hospedagem);
				Voo voo1 = vooDAO.getVooById(id_voo);
								
				Pacote p1 = new Pacote(posicao, valor, desconto, hospedagem1, voo1);
			
				pacoteDAO.update(p1);
	
				System.out.println("\n---- Pacote atualizado! ----\n");
				break;
				
			case 4:
				// Deletar
				System.out.println(" ");
				System.out.println("----------------- DELETAR -----------------");
				System.out.println("\nDigite o id do pacote que deseja deletar: ");
				posicao = entrada.nextInt();

				pacoteDAO.deleteById(posicao);
				System.out.println("\n------ Pacote deletado com sucesso! -----\n");
				break;
				
			case 5:
				//Buscar por id
				System.out.println(" ");
				System.out.println("------------ BUSCA ------------");
				System.out.println("\nDigite o id do pacote: ");
				posicao = entrada.nextInt();

				Pacote p2 = pacoteDAO.getPacoteById(posicao);

				System.out.println("- Id: " + p2.getId());
				System.out.println("- Destino: " + p2.getVoo().getDestino());
				System.out.println("- Data Ida: " + p2.getVoo().getDataIda());
				System.out.println("- Quantidade diárias: " + p2.getHospedagem().getDiarias());
				System.out.println("- Incluso: " + p2.getHospedagem().getIncluso());
				System.out.println("- Valor: R$" + p2.getValor());	
				System.out.println("- Desconto: "  + p2.getDesconto() + "%");
				System.out.println("- Valor final: R$" + p2.calcularPromocao());
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