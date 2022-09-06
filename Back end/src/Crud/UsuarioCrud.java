package Crud;

import java.util.Scanner;

import classes.Cliente;
import classes.Permissoes;
import classes.Usuario;
import dao.ClienteDAO;
import dao.PermissoesDAO;
import dao.UsuarioDAO;

public class UsuarioCrud {

	public static void main(String[] args) {		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		PermissoesDAO permissoesDAO = new PermissoesDAO();

		Scanner entrada = new Scanner(System.in);
		Scanner entrada1 = new Scanner(System.in);
		
		int opcao = 0;
		int posicao = 0;
	
		int id = 0;
		String login = "";
		String login1 = "";
		String senha = "";
		int id_cliente = 0;
		int id_permissoes = 0;
	
		System.out.println("----------- DONNA ------------");
		System.out.println("        Seja bem-vindo        ");
		System.out.println("------------------------------");
		System.out.println(" ");
		
		do {
			System.out.println("=== Menu Usuários ===");
			System.out.println("1 - Cadastrar usuários");
			System.out.println("2 - Consultar usuários");
			System.out.println("3 - Atualizar usuários");
			System.out.println("4 - Deletar usuários");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = entrada.nextInt();
			entrada.nextLine();
	
			switch (opcao) {
			case 1:
				//Cadastrar
				System.out.println(" ");
				System.out.println("------------- CADASTRO --------------");
				System.out.println("\nDigite o login do usuário: ");
				login = entrada1.nextLine();
				System.out.println("Digite a senha do usuário: ");
				senha = entrada1.nextLine();
				System.out.println("Digite o id do cliente: ");
				id_cliente = entrada1.nextInt();
				System.out.println("Digite o id da permissão: ");
				id_permissoes = entrada1.nextInt();
						
				Cliente cliente = clienteDAO.getClienteById(id_cliente);
				Permissoes permissoes = permissoesDAO.getPermissoesById(id_permissoes);
	
				Usuario u1 = new Usuario(id, login, senha, cliente, permissoes);
	
				usuarioDAO.save(u1);
	
				System.out.println("\n-- Usuário cadastrado com sucesso! --\n");
				System.out.println(" ");
	
			break;
			
			case 2:
				//Consultar
				System.out.println(" ");
				System.out.println("---------- CONSULTA ----------\n");
				
				for (Usuario u : usuarioDAO.getUsuario()) {
				
					System.out.println("- Id: " + u.getId());
					System.out.println("- Login: " + u.getLogin());	
					System.out.println("- Senha: " + u.getSenha());
					System.out.println("- Id Cliente: " + u.getCliente().getId());
					System.out.println("- Cliente: " + u.getCliente().getNome());	
					System.out.println("- Permissão: " + u.getPermissoes().getTipo());	
					System.out.println("  ");
					System.out.println("  ");
				}
				
				System.out.println("----- Fim da consulta. ------\n");
				break;
				
			case 3:
				//Atualizar
				System.out.println(" ");
				System.out.println("-------- ATUALIZAÇÃO ----------");
				System.out.println("\nDigite o id do usuário: ");
				posicao = entrada.nextInt();
						
				System.out.println("Digite o login do usuário: ");
				login1 = entrada1.nextLine();
				System.out.println("Digite a senha do usuário: ");
				senha = entrada1.nextLine();
				System.out.println("Digite o id do cliente: ");
				id_cliente = entrada1.nextInt();
				System.out.println("Digite o id da permissão: ");
				id_permissoes = entrada1.nextInt();
				
				Cliente cliente1 = clienteDAO.getClienteById(id_cliente);
				Permissoes permissoes1 = permissoesDAO.getPermissoesById(id_permissoes);
								
				Usuario u2 = new Usuario(posicao, login1, senha, cliente1, permissoes1);
			
				usuarioDAO.update(u2);
	
				System.out.println("\n---- Usuário atualizado! ----\n");
				break;
				
			case 4:
				//Deletar
				System.out.println(" ");
				System.out.println("----------------- DELETAR -----------------");
				System.out.println("\nDigite o id do usuário que deseja deletar: ");
				posicao = entrada.nextInt();

				usuarioDAO.deleteById(posicao);
				System.out.println("\n------ Usuário deletado com sucesso! -----\n");
				
				break;
				
			case 5:
				//Buscar por id
				System.out.println(" ");
				System.out.println("------------ BUSCA ------------");
				System.out.println("\nDigite o id do usuário: ");
				posicao = entrada.nextInt();

				Usuario u3 = usuarioDAO.getUsuarioById(posicao);

				System.out.println("- Id: " + u3.getId());
				System.out.println("- Login: " + u3.getLogin());	
				System.out.println("- Senha: " + u3.getSenha());
				System.out.println("- Cliente: " + u3.getCliente().getNome());	
				System.out.println("- Permissão: " + u3.getPermissoes().getTipo());	
				System.out.println("\n-------- Fim da busca. --------\n");

				break;
			default:
				if (opcao != 0) {
					System.out.println("\nOpção invalida, digite novamente.\n");
					}
				break;
			}
		}while(opcao != 0);
		
		System.out.println(" ");
		System.out.println("---------------- DONNA -----------------");
		System.out.println("          Agradecemos a visita!         ");
		System.out.println("             Até a próxima.             ");
		System.out.println("-----------------------------------------");
		
		entrada.close();
		entrada1.close();
	}
}
