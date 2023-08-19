package empresa;

import java.util.GregorianCalendar;

public class Gerente extends Funcionario{
	String metodologiaDesenvolvimento;
	public Gerente() {
		super();
		String[] metodologiaDesenvolvimento = new String[5];
	}
	
	public Gerente(String cpf, String nome, char sexo, float salarioBruto, GregorianCalendar dataAdmissao, GregorianCalendar dataNascimento, int dia, int mes, int ano, String metodologiaDesenvolvimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.salarioBruto = salarioBruto;
		this.dataAdmissao = dataAdmissao;
		this.dataNascimento = dataNascimento;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.metodologiaDesenvolvimento = metodologiaDesenvolvimento;
	}
		
	public void dominaMesmasMetodologias(Gerente vet[], int x) {
		int cont = 0;
		for(int i = 0; i < vet.length; i++) {
			if(vet[x].metodologiaDesenvolvimento.equals(this.metodologiaDesenvolvimento)) {
				cont++;
			}
			if(cont == 5) {
				System.out.println("O Gerente "+this.getNome()+"e o Gerente "+vet[x].getNome()+" dominam os mesmos metodologiaDesenvolvimentos!");
			}
		}
	}

	public String toString() {
		return "Gerente: nome=" + nome + ", CPF=" + cpf + ", sexo=" + sexo + ", salarioBruto=" + salarioBruto + ", dataNascimento: "+ dia +"/"+ mes +"/" + ano;
	}
	
	public double getBonificacao(Gerente vet[]) {
		double bonificacao = (this.salarioBruto * 12);
		return (bonificacao * 0.05);
	}
}
