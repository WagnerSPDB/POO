package td6;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import td6.Pessoa;
import td6.PessoaFisica;
import td6.PessoaJuridica;
import td6.ColecaoPessoa;
import td6.Colecao;

public class App {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Calendar hoje = Calendar.getInstance();
		int op = 0, i = 0;
			Pessoa[] dados = new Pessoa[100];
			ColecaoPessoa[] cPessoa = new ColecaoPessoa[1];
			cPessoa[0] = new ColecaoPessoa();
			do {
				System.out.println("---------- MENU ----------");
				System.out.println("Digite a opção: \n1 - Inserir\n2 - Remover\n3 - Atualizar\n4 - Pesquisar\n5 - Coleção vazia\n6 - Imprimir\n7 - Retornar Objeto");
				op = scan.nextInt();
				
				if(op == 1) {
					cPessoa[0].inserir(dados[0]);
				} else if(op == 2) {
					System.out.println("Digite qual indice deseja remover: ");
					int x = scan.nextInt();
					cPessoa[0].remover(x);
				} else if(op == 3) {
					cPessoa[0].atualizar(op ,dados[0]);
				} else if(op == 4) {
					cPessoa[0].pesquisar(dados[0]);
				} else if(op == 5) {
					cPessoa[0].colecaoEstaVazia();
				} else if(op == 6) {
					cPessoa[0].imprimirDadosColecao();
				} else if(op == 7) {
					System.out.println("Digite qual indice deseja receber: ");
					int x = scan.nextInt();
					cPessoa[0].retornarObjeto(x);
				}
				
				
			}while(op == 1 || op == 2 || op == 3 || op == 4 || op == 5 || op == 6 || op == 7);
			
			for(int  x = 0; x < dados.length; x++) {
				if(dados[x] == null) {
					break;
				} else {
					System.out.println("Nome: "+dados[x].getNome() + ", CPF: "+((PessoaFisica) dados[x]).getCpf());
				}
			}
	}
}



