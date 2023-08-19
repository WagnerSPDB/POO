package td6;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PessoaFisica extends Pessoa {
	private int dia;
	private int mes;
	private int ano;
	private String cpf;
	private GregorianCalendar dataNascimento;
	Scanner scan = new Scanner(System.in);

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(int dia, int mes, int ano, String cpf,
			GregorianCalendar dataNascimento) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}	

	public boolean validarDocumento() {
		if(this.cpf.length() == 14) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean equals(String cpf) {
		if(cpf.equals(this.cpf)) {
			return true;
		}
		return false;
	}
	
	
	public int CalculaIdade(Pessoa dados[], Calendar hoje) {
		int idade = 0;
		if(this.mes < hoje.get(Calendar.MONTH) + 1) {
			idade =  hoje.get(Calendar.YEAR)  - this.ano;
		} else if(this.mes > hoje.get(Calendar.MONTH) + 1) {
			idade =  (hoje.get(Calendar.YEAR)  - this.ano) - 1;

		} else if(this.mes == hoje.get(Calendar.MONTH) + 1) {
			if(this.getDia() > hoje.get(Calendar.DAY_OF_MONTH)) {
				idade =  (hoje.get(Calendar.YEAR)  - this.ano) - 1;
	
			} else {
				idade =  hoje.get(Calendar.YEAR)  - this.ano;
	
			}
		}
		return idade;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public GregorianCalendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(GregorianCalendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
