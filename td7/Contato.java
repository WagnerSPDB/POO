package td7;

import java.util.Calendar;

public abstract class Contato { // Classe Abstrata
		private String nome, telefone, email, genero, observacoes;
		private int dia, mes, ano, idade, aux;
		
		public Contato() {
			
		}
		
		public Contato(String nome, String telefone, String genero, String email, String observacoes, int dia, int mes, int ano, int aux) {
			super();
			this.nome = nome;
			this.telefone = telefone;
			this.genero = genero;
			this.email = email;
			this.observacoes = observacoes;
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
			this.aux = aux;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) throws FaltaDados { // Usando Exception própria
			if(nome.isEmpty()) {
				throw new FaltaDados();
			} else {
			this.nome = nome;
			}
		}
		
		public String getGenero() {
			return genero;
		}

		public void setGenero(String genero) {
			this.genero = genero;
		}
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getObservacoes() {
			return observacoes;
		}

		public void setObservacoes(String observacoes) {
			this.observacoes = observacoes;
		}

		public int getAux() {
			return aux;
		}

		public void setAux(int aux) {
			this.aux = aux;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
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

		public int getIdade() {
			return idade;
		}

		public int setIdade(int idade) {
			return this.idade = idade;
		}

		@Override
		public String toString() {
			return "Contato [nome=" + nome + ", observacoes=" + observacoes + ", nascimento= " + dia +"/"+mes+"/"+ano+ ", genero=" + genero + "]";
		}

		public int CalculaIdade (Contato agenda[], Calendar hoje) {
			int idade = 0;
			if(this.mes < hoje.get(Calendar.MONTH)) {
				idade =  hoje.get(Calendar.YEAR)  - this.ano;
			} else if(this.mes > hoje.get(Calendar.MONTH)) {
				idade =  (hoje.get(Calendar.YEAR)  - this.ano) - 1;
			} else if(this.mes == hoje.get(Calendar.MONTH)) {
				if(this.dia > hoje.get(Calendar.DAY_OF_MONTH)) {
					idade =  (hoje.get(Calendar.YEAR)  - this.ano) - 1;
				} else {
					idade =  hoje.get(Calendar.YEAR)  - this.ano;
				}
			}
			return idade;
		}
		
}
