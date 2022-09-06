package Crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import classes.Itens_reserva;
import classes.Reserva;
import classes.Usuario;
import dao.ReservaDAO;
import dao.Itens_reservaDAO;
import dao.UsuarioDAO;

public class ReservaCrud {

	public static void main(String[] args) {
		ReservaDAO reservaDAO = new ReservaDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Itens_reservaDAO itensDAO = new Itens_reservaDAO();
		
		Scanner entrada = new Scanner(System.in);
		Scanner entrada1 = new Scanner(System.in);

		int opcao = 0;
		int posicao = 0;

		int id = 0;
		String tipoPag = "";
		double valor = 0;
		int idUsuario = 0;
		List<Itens_reserva> itens = new ArrayList<>(); 

		System.out.println("----------- DONNA ------------");
		System.out.println("        Seja bem-vindo        ");
		System.out.println("------------------------------");
		System.out.println(" ");

		do {
			System.out.println("=== Menu Reserva ===");
			
			System.out.println("1 - Cadastrar reservas");
			System.out.println("2 - Consultar reservas");
			System.out.println("3 - Atualizar reservas");
			System.out.println("4 - Deletar reservas");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = entrada.nextInt();
			entrada.nextLine();

			switch (opcao) {
			case 1:
				// Cadastrar
				System.out.println(" ");
				System.out.println("------------- CADASTRO --------------");
				System.out.println("\nDigite o tipo de pagamento: ");
				tipoPag = entrada1.nextLine();
				System.out.println("Digite o id do usuário: ");
				idUsuario = entrada1.nextInt();			
				
				Usuario usuario = usuarioDAO.getUsuarioById(idUsuario);

				Reserva r = new Reserva(id, tipoPag, usuario);

				reservaDAO.save(r);

				System.out.println("\n-- Reserva cadastrada com sucesso! --\n");
				System.out.println(" ");

				break;

			case 2:
				// Consultar
				System.out.println(" ");
				System.out.println("---------- CONSULTA ----------\n");

				for(Reserva r1 : reservaDAO.getReserva()) {

					System.out.println("- Id: " + r1.getId());
					
					/*for (int i = 0; i < r1.getItens().size(); i++) {
						System.out.println("- Id do pacote: " + r1.getItens());
					*/
					System.out.println("\n\n");
					for(Itens_reserva itensc : itens){
				
						System.out.println("Nome: " + itensc.getQuantidade());
					}

					System.out.println("- Id usuário: " + r1.getUsuario().getId());
					System.out.println("- Tipo de pagamento: " + r1.getTipoPagamento());
					System.out.println("- Valor total: R$" + r1.valorTotal());
					System.out.println("  ");
					
				}
				System.out.println("----- Fim da consulta. ------\n");
				break;

			case 3:
				// Atualizar
				System.out.println(" ");
				System.out.println("-------- ATUALIZAÇÃO ----------");
				System.out.println("\nDigite o id da reserva: ");
				posicao = entrada.nextInt();

				System.out.println("Digite o tipo de pagamento: ");
				tipoPag = entrada1.nextLine();
				System.out.println("Digite o id do usuário: ");
				idUsuario = entrada1.nextInt();
			
				Usuario usuario1 = usuarioDAO.getUsuarioById(idUsuario);

				Reserva reserva = new Reserva(id, tipoPag, usuario1);

				reservaDAO.update(reserva);

				System.out.println("\n---- Reserva atualizada! ----\n");
				break;

			case 4:
				// Deletar
				System.out.println(" ");
				System.out.println("----------------- DELETAR -----------------");
				System.out.println("\nDigite o id da reserva que deseja deletar: ");
				posicao = entrada.nextInt();

				reservaDAO.deleteById(id);
				System.out.println("\n------ Reserva deletada com sucesso! -----\n");
				break;
				
			case 5:
				//Buscar por id
				System.out.println(" ");
				System.out.println("------------ BUSCA ------------");
				System.out.println("\nDigite o id da reserva: ");
				posicao = entrada.nextInt();

				Reserva r2 = reservaDAO.getReservaById(posicao);

					System.out.println("- Id: " + r2.getId());
				  	for (int i = 0; i < r2.getItens().size(); i++) {
						System.out.println("- Id itens: " + r2.getItens());
						System.out.println("- Id do pacote: " + r2.getItens());
						System.out.println("- Valor: " + r2.getItens());
						System.out.println("- Quantidade: " + r2.getItens());
					}
					System.out.println("- Id usuário: " + r2.getUsuario().getId());
					System.out.println("- Tipo de pagamento: " + r2.getTipoPagamento());
					System.out.println("- Valor total: R$" + r2.valorTotal());
					System.out.println("  ");
				
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
