package br.com.serratec;

import br.com.serratec.conta.Conta;
import br.com.serratec.conta.ContaCorrente;
import br.com.serratec.enums.Agencia;
import br.com.serratec.enums.Cargo;
import br.com.serratec.enums.TipoConta;
import br.com.serratec.usuario.Funcionario;
import br.com.serratec.usuario.Gerente;

public class MainSistemaInterno {
    public static void main(String[] args) {

<<<<<<< HEAD
//        //teste criacao objeto gerente
//        Funcionario g1 = new Gerente("Bia", "17222255598", "123456", Cargo.GERENTE, Agencia.A01);
//        System.out.println(g1.toString());
//
//        Conta c1 = new ContaCorrente("17222255598", "12345", Agencia.A01, TipoConta.CONTA_CORRENTE);
//        Conta c2 = new ContaCorrente("17222255500", "54321", Agencia.A01, TipoConta.CONTA_CORRENTE);
//
//        c1.depositar(1000);
//        System.out.println();
//
//        c1.transferir(500, 54321);

    }
=======
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
				if(conta.getCliente().getCpf().equals(usuarioLogado.getCpf())) {
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
	
	
>>>>>>> 68be095a6f39d17008c9ac4d8f0c05d46de7e0cd
}
