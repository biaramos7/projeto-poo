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
	// Esse scanner leitor está declarado como se fosse um atributo(caractéristica de conta), o ideal é que
	// ele fosse declarado em outro lugar, tipo menu, e depois só passado como parâmetro para as funções que o usassem
	Scanner leitor = new Scanner(System.in);
	protected String cpfTitular;
	private String nomeTitular;
	protected int numeroConta;
	protected Agencia idAgencia;
	private TipoConta tipo;
	private double saldo;

	public Conta(String cpfTitular, String nomeTitular, int numeroConta, Agencia idAgencia, TipoConta tipo) {
		this.cpfTitular = cpfTitular;
		this.nomeTitular = nomeTitular;
		this.numeroConta = numeroConta;
		this.idAgencia = idAgencia;
		this.tipo = tipo;
	}

	// É bom isolar responsabilidade. Seria melhor que essa função só aumentasse/diminuisse o saldo da conta
	// As perguntas e leituras deveriam ser feitos nos menus
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

	// Mesma sugestão do saque
	public void depositar() throws ValorNegativoException {
		System.out.println("Quanto deseja depositar?");
		double valorDeposito = leitor.nextDouble();
		if (valorDeposito < 0) {
			throw new ValorNegativoException("Deposito não realizado valor negativo.");
		} else {
			this.saldo += valorDeposito;
			System.out.println("Deposito de R$ "+valorDeposito+" realizado com sucesso.");
		}
	}

	// Mesma sugestão do saque
	public void transferir() throws ContaNaoEncontradaException {
		System.out.println("Digite a conta para transferência:");
		int numeroConta = leitor.nextInt();
		
		Conta conta = MainSistemaInterno.getConta(numeroConta);
		if(conta == null) {
			throw new ContaNaoEncontradaException("Conta Não encontrada.");
		}
		System.out.println("-------------------");
		System.out.println("Quem vai receber");
		System.out.println("-------------------");
		System.out.println("Nome: " + conta.getNomeTitular());
		System.out.println("Conta: " + numeroConta);
		System.out.println("Agencia: " + conta.getIdAgencia());
		System.out.println("-------------------");
		System.out.println("Deseja continuar?");
		System.out.println("1. Sim");
		System.out.println("2. Não");
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
		
		if(this.cpfTitular != null) {

			// Talvez fosse melhor começar aqui com false e só setar true no default do switch
			// Assim evitaria a repetição dentro dos cases do switch
			boolean continuaMenu = true;
			int opcao;

			do {
				System.out.println("-------------------");
				System.out.println("Bem vindo(a) " + this.nomeTitular);
				
				System.out.println("1. Movimentações na Conta");
				System.out.println("2. Relatórios");
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
					System.out.println("Ate mais " + this.nomeTitular + "\n\n");
					continuaMenu = false;
					break;
				default:
					System.out.println("Opção invalida!");
					break;
				}
				
			} while (continuaMenu);

			// Não é uma boa prática chamar login de dentro da conta já que para excutá-lo
			// você já estaria dentro de uma conta. A melhor saída aqui, seria fazer o programa parar
			if(opcao == 3) {
				System.exit(1);
			}
		
		}
	
	}
	
	
	public void menuMovimentacaoConta() throws ValorNegativoException, SaqueException {
		
		boolean continuaMenu = true;
		int opcao;
		
		do {
			System.out.println("-------------------");
			System.out.println("1. Saque");
			System.out.println("2. Depósito");
			System.out.println("3. Transferência para outra conta");
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
				System.out.println("Opção invalida!");
				break;
			}
		} while (continuaMenu);
		
		if(opcao != 4) {
			menuMovimentacaoConta();
		}
	}
	
	
	private void getConsultaSaldo() {
		System.out.println("-------------------");
		System.out.println("Seu saldo é de: R$ " + this.saldo);
	}
	
	
	public void menuRelatorio() throws ValorNegativoException, SaqueException {
		
		boolean continuaMenu = true;
		int opcao;
		
		do {
			
			System.out.println("-------------------");
			System.out.println("1. Saldo");
			if(TipoConta.CONTA_CORRENTE.equals(this.tipo)) {
				System.out.println("2. Relatório de tributação da conta corrente");
			} else if(TipoConta.CONTA_POUPANCA.equals(this.tipo)) {
				System.out.println("2. Relatório de Rendimento da poupança");
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
					System.out.println("CHAMADA SERVICO: Relatório de tributação da conta corrente");
				} else if(TipoConta.CONTA_POUPANCA.equals(this.tipo)) {
					//CRIAR METODO
					System.out.println("CHAMADA SERVICO: Relatório de Rendimento da poupança");
				}
				break;
			case 3:
				continuaMenu = false;
				menuInicial();
				break;
			default:
				System.out.println("Opção invalida!");
				break;
			}
			
		} while (continuaMenu);
		
		if(opcao != 3) {
			menuRelatorio();
		}

	}	

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getCpfTitular() {
		return cpfTitular;
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