package Crud;

import java.util.Scanner;

import dao.ClienteDAO;
import classes.Cliente;

public class ClienteCrud {

	public static void main(String[] args) {
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Scanner entrada = new Scanner(System.in);
		Scanner entrada1 = new Scanner(System.in);
		
		int opcao = 0;
		int posicao = 0;
		int id = 0, numero = 0;
		String nome = "", telefone = "", cpf = "", email = "", estado = "", cidade = "", bairro = "", rua = "", cep = "";
		
		System.out.println("------------- DONNA --------------");
		System.out.println("          Seja bem-vindo          ");
		System.out.println("----------------------------------");
		System.out.println(" ");
		
		do {
			System.out.println("====== Menu Clientes =======");
			System.out.println(" ");
			System.out.println("    Selecione uma opção:    ");
			System.out.println("1 - Cadastrar clientes");
			System.out.println("2 - Consultar clientes");
			System.out.println("3 - Atualizar clientes");
			System.out.println("4 - Deletar clientes");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = entrada.nextInt();
			
			switch(opcao) {
			case 1:
				//Cadastrar
				System.out.println(" ");
				System.out.println("Digite o nome do cliente: ");
				nome = entrada1.nextLine();				
				System.out.println("Digite o telefone do cliente ");
				telefone = entrada1.nextLine();				
				System.out.println("Digite o CPF do cliente: ");
				cpf = entrada1.nextLine();
				System.out.println("Digite o email do cliente: ");
				email = entrada1.nextLine();
				System.out.println("---- Endereço ----");
				System.out.println("Digite o estado: ");
				estado = entrada1.nextLine();
				System.out.println("Digite a cidade: ");
				cidade = entrada1.nextLine();
				System.out.println("Digite o bairro: ");
				bairro = entrada1.nextLine();
				System.out.println("Digite a rua: ");
				rua = entrada1.nextLine();
				System.out.println("Digite o número: ");
				numero = entrada.nextInt();
				System.out.println("Digite o CEP: ");
				cep = entrada1.nextLine();				
				
				Cliente c1 = new Cliente(id, nome, telefone, cpf, email, estado, cidade, bairro, rua, numero, cep);
				
				clienteDAO.save(c1);
				
				System.out.println("\nCliente cadastrado com sucesso!\n");
				System.out.println(" ");
				break;
				
			case 2:
				//Consultar
				for (Cliente c : clienteDAO.getCliente()) {
					System.out.println(" ");
					System.out.println("Id: " + c.getId());
					System.out.println("Nome: " + c.getNome());
					System.out.println("Telefone: " + c.getTelefone()); 
					System.out.println("CPF: " + c.getCpf());
					System.out.println("Email: " + c.getEmail());
					System.out.println("Estado: " + c.getEstado());
					System.out.println("Cidade: " + c.getCidade());
					System.out.println("Bairro: " + c.getBairro());
					System.out.println("Rua: " + c.getRua());
					System.out.println("Número: " + c.getNumero());
					System.out.println("CEP: " + c.getCep());					
					System.out.println("----------------------------------- ");
				}
				
				System.out.println("\nFim da consulta.\n");
				break;
				
			case 3:
				//Atualizar
				System.out.println("Digite o id do cliente: ");
				posicao = entrada.nextInt();
				entrada.nextLine();
				
				System.out.println("Digite o nome do cliente: ");
				nome = entrada1.nextLine();
				System.out.println("Digite o telefone do cliente ");
				telefone = entrada1.nextLine();				
				System.out.println("Digite o CPF do cliente: ");
				cpf = entrada1.nextLine();
				System.out.println("Digite o email do cliente: ");
				email = entrada1.nextLine();
				System.out.println("---- Endereço ----");
				System.out.println("Digite o estado: ");
				estado = entrada1.nextLine();
				System.out.println("Digite a cidade: ");
				cidade = entrada1.nextLine();
				System.out.println("Digite o bairro: ");
				bairro = entrada1.nextLine();
				System.out.println("Digite a rua: ");
				rua = entrada1.nextLine();
				System.out.println("Digite o número: ");
				numero = entrada.nextInt();
				System.out.println("Digite o CEP: ");
				cep = entrada1.nextLine();
				
				Cliente c2 = new Cliente(posicao, nome, telefone, cpf, email, estado, cidade, bairro, rua, numero, cep);
			
				clienteDAO.update(c2);
	
				System.out.println("\nDados do cliente atualizados!\n");
				break;
				
			case 4:
				//Deletar
				System.out.println("Digite o id do cliente que deseja deletar: ");
				posicao = entrada.nextInt();
				
				clienteDAO.deleteById(posicao);
				System.out.println("\nCliente deletado com sucesso!\n");
				break;
				
			case 5:
				//Buscar por id
				System.out.println("Digite o id do cliente: ");
				posicao = entrada.nextInt();
				
				Cliente c3 = clienteDAO.getClienteById(posicao);
				
				System.out.println("Id: " + c3.getId());
				System.out.println("Nome: " + c3.getNome());
				System.out.println("Telefone: " + c3.getTelefone()); 
				System.out.println("CPF: " + c3.getCpf());
				System.out.println("Email: " + c3.getEmail());
				System.out.println("Estado: " + c3.getEstado());
				System.out.println("Cidade: " + c3.getCidade());
				System.out.println("Bairro: " + c3.getBairro());
				System.out.println("Rua: " + c3.getRua());
				System.out.println("Número: " + c3.getNumero());
				System.out.println("CEP: " + c3.getCep());
				System.out.println(" ");				
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
