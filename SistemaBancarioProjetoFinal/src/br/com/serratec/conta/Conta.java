package br.com.serratec.conta;

import java.util.Scanner;

import br.com.serratec.dominio.MainSistemaInterno;
import br.com.serratec.enums.Agencia;
import br.com.serratec.enums.TipoConta;
import br.com.serratec.excecoes.ContaNaoEncontradaException;
import br.com.serratec.excecoes.ValorNegativoException;
import br.com.serratec.excecoes.SaqueException;
import br.com.serratec.usuario.Cliente;

public abstract class Conta {
	Scanner leitor = new Scanner(System.in);
	protected Cliente cliente;
	protected int numeroConta;
	protected Agencia idAgencia;
	private TipoConta tipo;
	private double saldo;

	public Conta(Cliente cliente, int numeroConta, Agencia idAgencia, TipoConta tipo) {
		this.cliente = cliente;
		this.numeroConta = numeroConta;
		this.idAgencia = idAgencia;
		this.tipo = tipo;
	}

	public void sacar() throws SaqueException, ValorNegativoException {
		System.out.println("Digite o valor do saque: ");
		double valorSaque = leitor.nextDouble();
		if(valorSaque > this.saldo) {
			throw new SaqueException("Saldo insuficiente.");
		}else if (valorSaque < 0) {
			throw new ValorNegativoException("Saque não realizado valor negativo.");
		} else {
			saldo -= valorSaque;
			System.out.println("Saque de R$ "+valorSaque+" efetuado com sucesso.");
		}
	}
	
	public void depositar() throws ValorNegativoException {
		System.out.println("Quanto deseja depositar?");
		double valorDeposito = leitor.nextDouble();
		if (valorDeposito < 0) {
<<<<<<< HEAD
			throw new ValorNegativoException("Deposito não realizado valor negativo.");
=======
			throw new DepositoNegativoException("Deposito nao realizado valor negativo.");
>>>>>>> 68be095a6f39d17008c9ac4d8f0c05d46de7e0cd
		} else {
			this.saldo += valorDeposito;
			System.out.println("Deposito de R$ "+valorDeposito+" realizado com sucesso.");
		}
	}

	public void transferir() throws ContaNaoEncontradaException {
		System.out.println("Digite a conta para transferencia:");
		int numeroConta = leitor.nextInt();
		
		Conta conta = MainSistemaInterno.getConta(numeroConta);
		if(conta == null) {
			throw new ContaNaoEncontradaException("Conta Nao encontrada.");
		}
		System.out.println("-------------------");
		System.out.println("Quem vai receber");
		System.out.println("-------------------");
		System.out.println("Nome: " + conta.getCliente().getNome());
		System.out.println("Conta: " + numeroConta);
		System.out.println("Agencia: " + conta.getIdAgencia());
		System.out.println("-------------------");
		System.out.println("Deseja continuar?");
		System.out.println("1. Sim");
		System.out.println("2. Nao");
		int transferir = leitor.nextInt();
		System.out.println("-------------------");
		if(transferir == 1) {
			System.out.println("Quanto voce deseja transferir?");
			double valor = leitor.nextDouble();
			if (valor < this.saldo) {
				this.setSaldo(this.getSaldo() - valor);
				conta.setSaldo(conta.getSaldo() + valor);
				System.out.println("Transferencia realizada de R$ "+ valor);
			} else {
				System.out.println("Nao foi possivel realizar a transferencia");
			}
		}else {
			System.out.println("Transferencia cancelada.");
		}

	}
	
	public void menuInicial() throws ValorNegativoException, SaqueException {
		
		if(this.cliente != null) {
			
			boolean continuaMenu = true;
			int opcao;

			do {
				System.out.println("-------------------");
				System.out.println("Bem vindo(a) " + this.cliente.getNome());
				
				System.out.println("1. Movimentacoes na Conta");
				System.out.println("2. Relatorios");
				System.out.println("3. Sair");
				
				Scanner leitor = new Scanner(System.in);

				opcao = leitor.nextInt();
		    	
				switch (opcao) {
				case 1:
					continuaMenu = false;
					menuMovimentacaoConta();
					break;
				case 2:
					continuaMenu = false;
					menuRelatorio();
					break;
				case 3:
					System.out.println("Ate mais " + this.cliente.getNome() + "\n\n");
					continuaMenu = false;
					break;
				default:
					System.out.println("Opcao invalida!");
					break;
				}
				
			} while (continuaMenu);
			
			if(opcao == 3) {
				MainSistemaInterno.login();
			}
		
		}
	
	}
	
	
	public void menuMovimentacaoConta() throws ValorNegativoException, SaqueException {
		
		boolean continuaMenu = true;
		int opcao;
		
		do {
			System.out.println("-------------------");
			System.out.println("1. Saque");
			System.out.println("2. DepÃ³sito");
			System.out.println("3. Transferencia para outra conta");
			System.out.println("4. Voltar");
			
			Scanner leitor = new Scanner(System.in);
			
			opcao = leitor.nextInt();
			
			switch (opcao) {
			case 1:
				continuaMenu = false;
				try {
					sacar();
				} catch (SaqueException e) {
					System.out.println(e.getMessage());
				} catch (ValorNegativoException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				continuaMenu = false;
				try {
					depositar();
				} catch (ValorNegativoException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				continuaMenu = false;
				try {
					transferir();
				} catch (ContaNaoEncontradaException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				continuaMenu = false;
				menuInicial();
				break;
			default:
				System.out.println("Opcao invalida!");
				break;
			}
		} while (continuaMenu);
		
		if(opcao != 4) {
			menuMovimentacaoConta();
		}
	}
	
	
	private void getConsultaSaldo() {
		System.out.println("-------------------");
		System.out.println("Seu saldo e de: R$ " + this.saldo);
	}
	
	
	public void menuRelatorio() throws ValorNegativoException, SaqueException {
		
		boolean continuaMenu = true;
		int opcao;
		
		do {
			
			System.out.println("-------------------");
			System.out.println("1. Saldo");
			if(TipoConta.CONTA_CORRENTE.equals(this.tipo)) {
				System.out.println("2. Relatorio de tributacao da conta corrente");
			} else if(TipoConta.CONTA_POUPANCA.equals(this.tipo)) {
				System.out.println("2. Relatorio de Rendimento da poupanca");
			}
			System.out.println("3. Voltar");
			
			Scanner leitor = new Scanner(System.in);
			
			opcao = leitor.nextInt();
			
			switch (opcao) {
			case 1:
				continuaMenu = false;
				getConsultaSaldo();
				break;
			case 2:
				continuaMenu = false;
				if(TipoConta.CONTA_CORRENTE.equals(this.tipo)) {
					//CRIAR METODO
					System.out.println("CHAMADA SERVICO: Relatorio de tributacao da conta corrente");
				} else if(TipoConta.CONTA_POUPANCA.equals(this.tipo)) {
					//CRIAR METODO
					System.out.println("CHAMADA SERVICO: Relatorio de Rendimento da poupanca");
				}
				break;
			case 3:
				continuaMenu = false;
				menuInicial();
				break;
			default:
				System.out.println("Opcao invalida!");
				break;
			}
			
		} while (continuaMenu);
		
		if(opcao != 3) {
			menuRelatorio();
		}

	}	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public Agencia getIdAgencia() {
		return idAgencia;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}