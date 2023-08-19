package empresa;

import java.util.GregorianCalendar;

public class Programador extends Funcionario{
	public String linguagem;
	public Programador() {
		super();
		String[] linguagem = new String[5];
	}
	
	public Programador(String cpf, String nome, char sexo, float salarioBruto, GregorianCalendar dataAdmissao, GregorianCalendar dataNascimento, int dia, int mes, int ano) {
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.salarioBruto = salarioBruto;
		this.dataAdmissao = dataAdmissao;
		this.dataNascimento = dataNascimento;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		//this.linguagem = linguagem;
	}
		
		
	public String getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}

	public void programaMesmasLinguagens(Programador vet[], int x) {
		int cont = 0;
		for(int i = 0; i < vet.length; i++) {
			if(vet[x].linguagem.equals(this.linguagem)) {
				cont++;
			}
			if(cont == 5) {
				System.out.println("O funcionário "+this.getNome()+"e o funcionario "+vet[x].getNome()+" programam as mesmas linguagens!");
			}
		}
	}

	public String toString() {
		return "Programador: nome=" + nome + ", CPF=" + cpf + ", sexo=" + sexo + ", salarioBruto=" + salarioBruto + ", dataNascimento: "+ dia +"/"+ mes +"/" + ano;
	}
	
}
