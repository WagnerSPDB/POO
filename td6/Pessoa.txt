package td6;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public abstract class Pessoa{
	private String nome;
	private Calendar hoje = Calendar.getInstance();
	
	Scanner scan = new Scanner(System.in);
	
	public Pessoa() {
		super();
		this.nome = nome;
		this.hoje = hoje;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean validarDocumento() {
		return true;
	}
	public int calcularIdade() {
		return 1;
	}
	public Calendar getHoje() {
		return hoje;
	}
	public void setHoje(Calendar hoje) {
		this.hoje = hoje;
	}
	
}

