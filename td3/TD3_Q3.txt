package td3;
import java.util.Scanner;
public class App{
	public static void main(String[] args) {
		Contatos vet[] = new Contatos[100];
		Agenda agenda = new Agenda();
		Scanner scan = new Scanner (System.in);
		int op = 0;
		
		do {
			System.out.println("---------- MENU ----------");
			System.out.println("Digite a opção: \n1 - Inserir\n2 - Atualizar\n3 - Deletar\n4 - Pesquisar\n5 - Imprimir\n6 - Sair");
			op = scan.nextInt();
			
			if(op == 1) {
				agenda.inserir(vet);
			}else if(op == 2) {
				agenda.atualizar(vet);
			}else if(op == 3) {
				agenda.deletar(vet);
			}else if(op == 4) {
				agenda.pesquisar(vet);
			}else if(op == 5) {
				System.out.println("---------- LISTA DE CONTATOS ----------");
				agenda.imprimir(vet);
			}
			
		}while(op == 1 || op == 2 || op == 3 || op == 4 || op == 5);
	}
}





package td3;

import java.util.Scanner;
public class Agenda {
	Scanner scan = new Scanner (System.in);
	Contatos vet[] = new Contatos[100];
	int cont = 0;
	String telaux;
	void inserir(Contatos[] vet) {
			vet[cont] = new Contatos();
			System.out.println("Digite o nome do contato: ");
			vet[cont].nome = scan.nextLine();
			System.out.println("Digite o telefone do contato: ");
			vet[cont].telefone = scan.nextLine();
			System.out.println("Digite o email do contato: ");
			vet[cont].email = scan.nextLine();
			cont++;
	}
	void imprimir(Contatos vet[]) {
		for(int i = 0; i < cont; i++) {
			if(vet[i].nome != "NULL") {
				System.out.println("Nome: "+vet[i].nome);
				System.out.println("Telefone: "+vet[i].telefone);
				System.out.println("Email: "+vet[i].email+"\n");
			}
		}
	}
	
	void pesquisar(Contatos vet[]) {
		System.out.println("Digite o telefone do contato desejado: ");
		telaux = scan.nextLine();
		for(int i = 0; i < cont; i++) {
			if(vet[i].telefone.equals(telaux)) {
				System.out.println("Nome: "+vet[i].nome+"\nTelefone: "+vet[i].telefone+"\nEmail: "+vet[i].email+"\n");
			}	
		}
	}
	
	void deletar(Contatos[] vet) {
		System.out.println("Digite o telefone do contato que deseja apagar: ");
		telaux = scan.nextLine();
		for(int i = 0; i < cont; i++) {
			if(telaux.equals(vet[i].telefone)) {
				vet[i].nome = "NULL";
				vet[i].telefone = "NULL";
				vet[i].email = "NULL";
			}
		}
	}
	
	void atualizar(Contatos[] vet) {
		System.out.println("Digite o telefone do contato que deseja atualizar: ");
		telaux = scan.nextLine();
		for(int i = 0; i < cont; i++) {
			if(vet[i].telefone.equals(telaux)) {
				System.out.println("Digite o novo nome do contato: ");
				vet[i].nome = scan.nextLine();
				System.out.println("Digite o novo telefone do contato: ");
				vet[i].telefone = scan.nextLine();
				System.out.println("Digite o novo email do contato: ");
				vet[i].email = scan.nextLine();
			}
		}
	}
}




package td3;

public class Contatos {
	String nome;
	String telefone;
	String email;
}
