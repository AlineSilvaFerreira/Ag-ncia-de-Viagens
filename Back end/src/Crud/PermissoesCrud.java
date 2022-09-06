package Crud;

import java.util.Scanner;

import classes.Permissoes;
import dao.PermissoesDAO;

public class PermissoesCrud {

	public static void main(String[] args) {
		PermissoesDAO permissoesDAO = new PermissoesDAO();
		
		Scanner entrada = new Scanner(System.in);
		Scanner entrada1 = new Scanner(System.in);
		
		int opcao = 0;
		int posicao = 0;
		int id = 0;
		String tipo = "";
		
		System.out.println("----------- DONNA ------------");
		System.out.println("        Seja bem-vindo        ");
		System.out.println("------------------------------");
		System.out.println(" ");
		
		do {
			System.out.println("====== Menu Permissões =======");
			System.out.println("    Selecione uma opção:    ");
			System.out.println("1 - Cadastrar permissões");
			System.out.println("2 - Consultar permissões");
			System.out.println("3 - Atualizar permissões");
			System.out.println("4 - Deletar permissões");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			System.out.println("==============================");
			opcao = entrada.nextInt();
			
			switch(opcao) {
			case 1:
				//Cadastrar
				System.out.println(" ");
				System.out.println("-------------- CADASTRO --------------");
				System.out.println("\nDigite o tipo de permissão: ");
				tipo = entrada1.nextLine();												
				
				Permissoes p1 = new Permissoes(id, tipo);
				
				permissoesDAO.save(p1);
				
				System.out.println("\n-- Permissão cadastrada com sucesso! --\n");
				System.out.println(" ");
				break;
							
			case 2:
				//Consultar
				System.out.println(" ");
				System.out.println("---------- CONSULTA ----------\n");
				for (Permissoes p : permissoesDAO.getPermissoes()) {
				
					System.out.println("- Id: " + p.getId());
					System.out.println("- Tipo: " + p.getTipo());	
					System.out.println(" ");
				}
				
				System.out.println("----- Fim da consulta. ------\n");
				break;
				
			case 3:
				//Atualizar
				System.out.println(" ");
				System.out.println("-------- ATUALIZAÇÃO ----------");
				System.out.println("\nDigite o id da permissão: ");
				posicao = entrada.nextInt();
				entrada.nextLine();
				
				System.out.println("Digite o tipo da permissão: ");
				tipo = entrada1.nextLine();
								
				Permissoes p2 = new Permissoes(posicao,tipo);
			
				permissoesDAO.update(p2);
	
				System.out.println("\n---- Permissão atualizada! ----\n");
				break;
				
			case 4:
				//Deletar
				System.out.println(" ");
				System.out.println("----------------- DELETAR -----------------");
				System.out.println("\nDigite o id da permissão que deseja deletar: ");
				posicao = entrada.nextInt();
				
				permissoesDAO.deleteById(posicao);
				System.out.println("\n------ Permissão deletada com sucesso! -----\n");
				break;
				
			case 5:
				//Buscar por id
				System.out.println(" ");
				System.out.println("------------ BUSCA ------------");
				System.out.println("\nDigite o id da permissão: ");
				posicao = entrada.nextInt();
				
				Permissoes p3 = permissoesDAO.getPermissoesById(posicao);
				
				System.out.println("\nId: " + p3.getId());
				System.out.println("Tipo: " + p3.getTipo());
				System.out.println("\n-------- Fim da busca. --------\n");	
				
				break;
				
				default:
					if (opcao != 0) {
						System.out.println("\nOpção invalida, digite novamente.\n");
						}
					
					break;			
			} 
		}while (opcao != 0);
		
		System.out.println(" ");
		System.out.println("----------- DONNA ------------");
		System.out.println("     Agradecemos a visita!    ");
		System.out.println("        Até a próxima.        ");
		System.out.println("------------------------------");
		
		entrada.close();
		entrada1.close();
	}
}
