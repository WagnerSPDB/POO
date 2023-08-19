package td6;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PessoaJuridica extends Pessoa{
	
	private int dia;
	private int mes;
	private int ano;
	private String cnpj;
	private GregorianCalendar dataCriacao;
	
	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(int dia, int mes, int ano, String cnpj, GregorianCalendar dataCriacao) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.cnpj = cnpj;
		this.dataCriacao = dataCriacao;
	}

	boolean equals() {
		return true;
	} 
	
	public boolean validarDocumento() {
		if(this.cnpj.length() == 18) {
			return true;
		} else {
			return false;
		}	
	}
	
	public int CalculaIdade(Pessoa dados[], Calendar hoje) {
		int idade = 0;
		if(this.mes < hoje.get(Calendar.MONTH) + 1) {
			idade =  hoje.get(Calendar.YEAR)  - this.ano;
		} else if(this.mes > hoje.get(Calendar.MONTH) + 1) {
			idade =  (hoje.get(Calendar.YEAR)  - this.ano) - 1;

		} else if(this.mes == hoje.get(Calendar.MONTH) + 1) {
			if(this.dia > hoje.get(Calendar.DAY_OF_MONTH)) {
				idade =  (hoje.get(Calendar.YEAR)  - this.ano) - 1;
	
			} else {
				idade =  hoje.get(Calendar.YEAR)  - this.ano;
	
			}
		}
		return idade;
	}
	
	boolean equals(String cnpj) {
		if(cnpj.equals(this.cnpj)) {
			return true;
		}
		return false;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public GregorianCalendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(GregorianCalendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
	
	
}

