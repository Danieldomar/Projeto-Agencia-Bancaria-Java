package programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {

		contasBancarias = new ArrayList<Conta>();
		operacoes();

	}

	public static void operacoes() {

		System.out.println("--------------------------------------------------");
		System.out.println("-----------BEM VINDO A AGÊNCIA JAVA---------------");
		System.out.println("--------------------------------------------------");
		System.out.println("****SELECIONE A OPERAÇÃO QUE DESEJA REALIZAR****");
		System.out.println("--------------------------------------------------");
		System.out.println("|            OPÇÃO 1 - CRIAR CONTA               |");
		System.out.println("|            OPÇÃO 2 - DEPOSITAR                 |");
		System.out.println("|            OPÇÃO 3 - SACAR                     |");
		System.out.println("|            OPÇÃO 4 - TRANSFERIR                |");
		System.out.println("|            OPÇÃO 5 - LISTAR                    |");
		System.out.println("|            OPÇÃO 6 - SAIR                      |");
		System.out.println("--------------------------------------------------");

		int operacao = input.nextInt();

		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			System.out.println("--------------------------------------------------");
			System.out.println("-----------OBRIGADO E VOLTE SEMPRE----------------");
			System.out.println("--------------------------------------------------");
			System.exit(0);

		default:
			System.out.println("---------------OPÇÂO INVÁLIDA---------------------");
			operacoes();
			break;

		}
	}

	public static void criarConta() {

		System.out.println("\nNome: ");
		String nome = input.next();

		System.out.println("\nCPF: ");
		String cpf = input.next();

		System.out.println("\nEmail: ");
		String email = input.next();

		Pessoa pessoa = new Pessoa(nome, cpf, email);

		Conta conta = new Conta(pessoa);

		contasBancarias.add(conta);
		System.out.println("Sua conta foi criada com sucesso!");

		operacoes();

	}

	private static Conta encontrarConta(int numeroConta) {

		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta)
					;
				conta = c;
			}

		}
		return conta;
	}

	public static void depositar() {

		System.out.println("Número da conta: ");
		int numeroConta = input.nextInt();

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println("Qual valor deseja depositar? ");
			Double valorDeposito = input.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println("Valor depositado com sucesso! ");

		} else {
			System.out.println("---Conta não encontrada!---");
		}
		operacoes();

	}

	public static void sacar() {

		System.out.println("Número da conta: ");
		int numeroConta = input.nextInt();

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println("Qual valor deseja sacar? ");
			Double valorSacar = input.nextDouble();
			conta.depositar(valorSacar);
			System.out.println("Valor sacado com sucesso! ");

		} else {
			System.out.println("---Conta não encontrada!---");
		}
		operacoes();
	}

	public static void transferir() {

		System.out.println("Número da conta do remetente: ");
		int numeroContaRemetente = input.nextInt();

		Conta contaRemetente = encontrarConta(numeroContaRemetente);

		if (contaRemetente != null) {
			System.out.println("Número da conta do Destinatário: ");
			int numeroContaDestinatario = input.nextInt();

			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

			if (contaDestinatario != null) {
				System.out.println("Qual é o valor deseja tranferir?: ");
				Double valor = input.nextDouble();

				contaRemetente.transferir(contaDestinatario, valor);
			}

		}
		operacoes();
	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				System.out.println(conta);
			}
		} else {
			System.out.println("Não há contas cadastradas!");
		}
		operacoes();
	}

}
