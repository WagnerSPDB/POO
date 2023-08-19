package empresa;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Analista extends Funcionario{
	String diagrama;
	public Analista() {
		super();
		String[] diagrama = new String[5];
	}
	
	public Analista(String cpf, String nome, char sexo, float salarioBruto, GregorianCalendar dataAdmissao, GregorianCalendar dataNascimento, int dia, int mes, int ano, String diagrama) {
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.salarioBruto = salarioBruto;
		this.dataAdmissao = dataAdmissao;
		this.dataNascimento = dataNascimento;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.diagrama = diagrama;
	}
		
	public void dominaMesmosDiagramas(Analista vet[], int x) {
		int cont = 0;
		for(int i = 0; i < vet.length; i++) {
			if(vet[x].diagrama.equals(this.diagrama)) {
				cont++;
			}
			if(cont == 5) {
				System.out.println("O analista "+this.getNome()+"e o analista "+vet[x].getNome()+" dominam os mesmos diagramas!");
			}
		}
	}

	public String toString() {
		return "Analista: nome=" + nome + ", CPF=" + cpf + ", sexo=" + sexo + ", salarioBruto=" + salarioBruto + ", dataNascimento: "+ dia +"/"+ mes +"/" + ano;
	}
	
	public double getBonificacao(Analista ana[]) {
		double bonificacao = (this.salarioBruto * 12);
		return (bonificacao * 0.03);
	}
}
