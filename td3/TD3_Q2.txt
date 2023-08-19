package td3;

import java.util.Scanner;
public class App{
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		int n;
		float valorTotal = 0;
		System.out.println("Digite quantos DVDs deseja armazenar: ");
	    n = scan.nextInt();
	    scan.nextLine();
	    DVD[] vet = new DVD[n];
	    for(int i = 0; i < vet.length; i++){
	    	vet[i] = new DVD();
	    	vet[i].autor = new Autor();
	    	vet[i].codigo = i+1;
	    	System.out.println("\n---------- DVD NOVO ----------\n");
	    	System.out.println("Digite o título do DVD: ");
	    	vet[i].titulo = scan.nextLine();
	    	
	    	System.out.println("Digite o nome do autor do DVD: ");
	    	vet[i].autor.nome = scan.nextLine();
	    	
	    	System.out.println("De que forma o ator atua: Digite 1 para Solo ou 2 para Dupla/Grupo.");
	    	vet[i].autor.atuaSolo = scan.nextInt();
	    	scan.nextLine();
	    	
	    	System.out.println("Digite o gênero musical do DVD: ");
	    	vet[i].genero = scan.nextLine();
	    	
	    	System.out.println("Digite a gravadora responsável pelo DVD: ");
	    	vet[i].gravadora = scan.nextLine();
	    	
	    	System.out.println("Digite o ano de lançamento do DVD: ");
	    	vet[i].ano = scan.nextInt();
	    	
	    	System.out.println("Digite o valor pago:");
	    	vet[i].valor = scan.nextFloat();
	    	valorTotal += vet[i].valor;
	    	scan.nextLine();
	    }
	    System.out.println("\n---------- Informações Registradas ----------");
	    for(int i = 0; i < vet.length; i++) {
	    vet[i].imprimir();
	    }
	    vet[0].contarAno(vet);
	    vet[0].contarGenero(vet);
	    vet[0].caroBarato(vet);
	    vet[0].verificaSolo(vet);
	    System.out.println("\nValor total: R$"+valorTotal);
	}
}





package td3;

public class DVD {
	int codigo, ano;
	String titulo, genero, gravadora;
	float valor;
	Autor autor;
	
	void imprimir() {
		System.out.println("\nCódigo: "+this.codigo);
		System.out.println("Título: "+this.titulo);
		System.out.println("Autor: "+this.autor.nome);
		if(this.autor.atuaSolo == 1) {
			System.out.println("Atua solo: Sim");
		} else {
			System.out.println("Atua solo: Não");
		}
		System.out.println("Gênero: "+this.genero);
		System.out.println("Ano de Lançamento: "+this.ano);
		System.out.println("Gravadora: "+this.gravadora);
		System.out.println("Valor pago: "+this.valor);
	}
	
	void contarAno(DVD vet[]) {
		int cont = 0, anoMais = 0, aux = 0;
		for(int i = 0; i < vet.length; i++) {
			cont = 1;
			for(int j = i+1; j < vet.length; j++) {
				if(vet[i].ano == vet[j].ano) {
					cont++;
				}
			}
			if(cont > aux) {
				aux = cont ;
				anoMais = vet[i].ano;
			}
		}
		System.out.println("\n"+anoMais+" é o ano com mais lançamentos, com "+aux+" DVD's lançados!");
	}
	
	void contarGenero(DVD vet[]) {
		int cont = 0, aux = 0;
		String generoMais = "Null";
		for(int i = 0; i < vet.length; i++) {
			cont = 1;
			for(int j = i+1; j < vet.length; j++) {
				if(vet[i].genero.equals(vet[j].genero)) {
					cont++;
				}
			}
			if(cont > aux) {
				aux = cont ;
				generoMais = vet[i].genero;
			}
		}
		System.out.println("\n"+generoMais+" é o gênero favorito do usuário, com "+aux+" DVD's cadastrados!");
	}
	
	void caroBarato(DVD vet[]) {
		float maisCaro = vet[0].valor, maisBarato = vet[0].valor;
		int auxCaro = 1, auxBarato = 1;
		for(int i = 1; i < vet.length; i++) {
			if(vet[i].valor > maisCaro) {
				maisCaro = vet[i].valor;
				auxCaro = vet[i].codigo;
			}
			if(vet[i].valor < maisBarato) {
				maisBarato = vet[i].valor;
				auxBarato = vet[i].codigo;
			}
		}
		System.out.println("\nO DVD mais caro é o DVD "+auxCaro+" que custou: R$"+maisCaro);
		System.out.println("O DVD mais barato é o DVD "+auxBarato+" que custou: R$"+maisBarato);
	}
	
	void verificaSolo(DVD vet[]) {
		System.out.println("\nDVD's de autor solo: ");
		for(int i = 0; i < vet.length; i++) {
			if(vet[i].autor.atuaSolo == 1) {
				System.out.println(vet[i].titulo);
			}
		}
	}
}




package td3;

public class Autor {
	String nome;
	int atuaSolo;
}
