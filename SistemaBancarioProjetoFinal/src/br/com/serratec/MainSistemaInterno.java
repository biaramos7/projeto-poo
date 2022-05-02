package br.com.serratec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.serratec.conta.Conta;
import br.com.serratec.conta.ContaCorrente;
import br.com.serratec.conta.ContaPoupanca;
import br.com.serratec.enums.Agencia;
import br.com.serratec.usuario.Cliente;
import br.com.serratec.usuario.Usuario;

public class MainSistemaInterno {
	
	private static Usuario usuarioLogado = null;
	private static Conta contaLogado = null;
	
	private static List<Usuario> listaClientes = new ArrayList<Usuario>();
	private static List<Conta> listaContas = new ArrayList<Conta>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		carregarUsuarios();

		login();
	}
	
	public static void login() {
		
		Scanner leitor = new Scanner(System.in);
		
		String cpf;
		String senha;
		
		do {
			
			System.out.println("-------------------");
			System.out.println("Login");
			System.out.println("-------------------");
			System.out.print("CPF: ");
			cpf = leitor.next();
			System.out.print("Senha: ");
			senha = leitor.next();
			
			for (Usuario usuario : listaClientes) {
				//autenticar usuario pela lista de clientes carregada no inicio
				if(usuario.Autenticar(cpf, senha)) {
					usuarioLogado = usuario;
				}
			}
			
			if(usuarioLogado == null) {
				System.out.println("-------------------");
				System.out.println("Senha incorreta digite novamente!");
			}
			System.out.println("-------------------\n\n");
			
		} while (usuarioLogado == null);
		
		
		if(usuarioLogado != null) {
			//pegar conta do usuario da lista de contas carregada no inicio
			for (Conta conta : listaContas) {
				if(conta.getCpfTitular().equals(usuarioLogado.getCpf())) {
					contaLogado = conta;
				}
			}
			
			contaLogado.menuInicial();
		}
		
	}
	
	public static Conta getConta(int numeroConta) {
		Conta contaReturno = null;
		for(Conta conta : listaContas) {
			if(conta.getNumeroConta() == numeroConta) {
				contaReturno = conta;
			}
			
		}
		return contaReturno;
	}
	
	public static void carregarUsuarios() {
		
		Cliente cliente1 = new Cliente("Amanda", "111", "123");
		listaClientes.add(cliente1);
		Conta c1 = new ContaCorrente(cliente1, 1111, Agencia.A01);
		c1.setSaldo(5000D);
		listaContas.add(c1);
		
		Cliente cliente2 = new Cliente("Matheus", "222", "321");
		listaClientes.add(cliente2);
		Conta c2 = new ContaPoupanca(cliente2, 2222, Agencia.A01);
		c2.setSaldo(2000D);
		listaContas.add(c2);
		
	}
	
	
}
