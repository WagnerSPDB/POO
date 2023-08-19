package td6;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class ColecaoPessoa implements Colecao{
	Scanner scan = new Scanner(System.in);
	public ColecaoPessoa() {
		super();
	}
	private Pessoa dados[] = new Pessoa[100];
	private int posicaoCorrente;
	
	public Pessoa[] getDados() {
		return dados;
	}
	public void setDados(Pessoa[] dados) {
		this.dados = dados;
	}
	public int getPosicaoCorrente() {
		return posicaoCorrente;
	}
	public void setPosicaoCorrente(int posicaoCorrente) {
		this.posicaoCorrente = posicaoCorrente;
	}

	int cont  = 0;
	public boolean inserir(Pessoa p) {
		int op = 0;
		System.out.println("Digite 1 para Pessoa Fisica e 2 para Pessoa Juridica:");
		op = scan.nextInt();
		scan.nextLine();
		if(op == 1) {
			dados[cont] = new PessoaFisica();
			System.out.println("Digite o nome ai: ");
			dados[cont].setNome(scan.nextLine());
			System.out.println("Digite o CPF: ");
			((PessoaFisica) dados[cont]).setCpf(scan.nextLine());
			System.out.println("Digite a data de nascimento: dd mm aaaa: ");
			((PessoaFisica) dados[cont]).setDia(scan.nextInt());
			((PessoaFisica) dados[cont]).setMes(scan.nextInt());
			((PessoaFisica) dados[cont]).setAno(scan.nextInt());
			scan.nextLine();
			((PessoaFisica) dados[cont]).setDataNascimento(new GregorianCalendar());
			((PessoaFisica) dados[cont]).getDataNascimento().set(((PessoaFisica) dados[cont]).getAno(), ((PessoaFisica) dados[cont]).getMes(), ((PessoaFisica) dados[cont]).getDia());
			cont++;
		} else if (op == 2) {
			dados[cont] = new PessoaJuridica();
			System.out.println("Digite o nome da empresa: ");
			dados[cont].setNome(scan.nextLine());
			System.out.println("Digite o CNPJ: ");
			((PessoaJuridica) dados[cont]).setCnpj(scan.nextLine());
			System.out.println("Digite a data de Criacao: dd mm aaaa: ");
			((PessoaJuridica) dados[cont]).setDia(scan.nextInt());
			((PessoaJuridica) dados[cont]).setMes(scan.nextInt());
			((PessoaJuridica) dados[cont]).setAno(scan.nextInt());
			scan.nextLine();
			((PessoaJuridica) dados[cont]).setDataCriacao(new GregorianCalendar());
			((PessoaJuridica) dados[cont]).getDataCriacao().set(((PessoaJuridica) dados[cont]).getAno(), ((PessoaJuridica) dados[cont]).getMes(), ((PessoaJuridica) dados[cont]).getDia());
			cont++;
		}
		return true;
	}
		
	public boolean remover(int indice) {
		dados[indice] = null;
		return true;
	}
	
	public void atualizar(int indice, Pessoa p) {
		System.out.println("");
	}
	
	public boolean pesquisar(Pessoa p) {
		System.out.println("Deseja pesquisar uma Pessoa Fisica ou Juridica? 1 pra Fisica 2 pra Juridica");
		int op = scan.nextInt();
		scan.nextLine();
		if(op == 1) {
			System.out.println("Digite o CPF: ");
			String aux = scan.nextLine();
			for(int i = 0; i < dados.length; i++) {
				if(dados[i] == null) {
					break;
				} else {
					if(aux.equals(((PessoaFisica) dados[i]).getCpf())){
						retornarObjeto(i);
						return true;
					} else {
						System.out.println("Não existe");
						return false;
					}
				}
			}
		}
		return false;
	}
	
	public boolean colecaoEstaVazia() {
		if(dados[0] == null) {
			System.out.println("Coleção está vazia.");
			return true;
		} else {
			System.out.println("Coleção não está vazia.");
			return false;
		}
	}
	
	public void imprimirDadosColecao() {
		for(int i = 0; i < dados.length; i++) {
				if(dados[i] == null) {
					break;
				} else {
					System.out.println("Nome: "+dados[i].getNome() + ", CPF: "+((PessoaFisica) dados[i]).getCpf()+ ", CPF: "+((PessoaFisica) dados[i]).getCpf());
				}
			}
		
	}
	
	public Pessoa retornarObjeto(int indice) {
		if(dados[indice] == null) {
			System.out.println("Esse objeto não existe.\n");
			return null;
		}
		System.out.println("Nome: "+ dados[indice].getNome() +" CPF: "+ ((PessoaFisica) dados[indice]).getCpf());
		return dados[indice];	
	}

}
