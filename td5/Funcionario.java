package empresa;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Funcionario{
		protected String cpf;
		protected String nome;
		protected char sexo;
		protected float salarioBruto;
		protected GregorianCalendar dataAdmissao;
		protected GregorianCalendar dataNascimento;
		protected int dia, mes, ano;
		
		
		public Funcionario() {
			this.dataAdmissao = new GregorianCalendar();
		}
		
		public Funcionario(String cpf, String nome, GregorianCalendar dataNascimento) {
			this.cpf = cpf;
			this.setNome(nome);
			this.dataNascimento = dataNascimento;
		}
		
		public Funcionario(String cpf, String nome, char sexo, float salarioBruto, GregorianCalendar dataAdmissao,
				GregorianCalendar dataNascimento, int dia, int mes, int ano) {
			this.cpf = cpf;
			this.nome = nome;
			this.sexo = sexo;
			this.salarioBruto = salarioBruto;
			this.dataAdmissao = dataAdmissao;
			this.dataNascimento = dataNascimento;
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}

		public int CalculaIdade (Funcionario vet[], Calendar hoje) {
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
		
		int ValidaCpf(Funcionario vet[]) {
				if(this.cpf.length() == 14) {
					System.out.println("CPF do funcionário "+this.getNome()+" válido!");
					return 1;
				} else {
					System.out.println("CPF do funcionário "+this.getNome()+" inválido.");
					return 0;
				}
		}
		
		public int ValidaNascimento(Funcionario vet[]) {
				if(this.ano < 1920) {
					System.out.println("\nData de nascimento do funcionário "+this.getNome()+" inválida.");
					return 0;
				} else {
					System.out.println("\nData de nascimento do funcionário "+this.getNome()+" válida!");
					return 1;
				}
		}
		
		public int ValidaAdmissao(Funcionario vet[], Calendar hoje) {
			if(hoje.get(Calendar.YEAR) < 1995) {
				System.out.println("Data de admissão inválida.");
				return 0;
			} else {
				System.out.println("Data de admissão válida!");
				return 1;
			}
		}
		
		public double SalarioLiquido(float salarioBruto) {
			double sLiquido;
			if (salarioBruto <= 3000) {
				sLiquido = salarioBruto - (salarioBruto * 0.17);
			} else {
				sLiquido = salarioBruto - (salarioBruto * 0.27);
			}
			return sLiquido;
		}
		
		public int FuncionarioIgual(Funcionario vet[]) {
			for(int i = 0; i < vet.length; i++) {
				for(int j = 1; j < vet.length;j++) {
					if(vet[i].getNome().equals(vet[j].getNome()) && vet[i].cpf.equals(vet[j].cpf) && vet[i].sexo == vet[j].sexo) {
							return 1;
					} else {
						return 2;
					}
				}
			}
			return 0;
		}

		public String toString() {
			System.out.println("Lalissa");
			return ("Nome: "+this.getNome()+", CPF: "+this.cpf+", Data de Nascimento: "+this.dia+"/"+this.mes+"/"+this.ano+", Salario Bruto: "+this.salarioBruto+", Sexo: "+this.sexo+"\n");
	 }
		
		public double getBonificacao(Funcionario vet[]) {
			double bonificacao = (this.salarioBruto * 12);
			bonificacao = bonificacao * 0.02;
			System.out.println("A bonificação do funcionario "+this.getNome()+" é "+bonificacao);
			return bonificacao;
		}
		
		public void dataAposentadoria(Funcionario vet[], Calendar hoje) {
			int anoAposenta = 0;
			if(this.sexo == 'm' || this.sexo =='M') {
				anoAposenta = hoje.get(Calendar.YEAR) + 35; 
			} else if(this.sexo == 'f' || this.sexo =='F') {
				anoAposenta = hoje.get(Calendar.YEAR) + 30;
			}
			System.out.println("Data de Aposentadoria prevista do funcionário " +this.getNome()+ ": "+hoje.get(Calendar.DAY_OF_MONTH)+"/"+hoje.get(Calendar.MONTH)+"/"+anoAposenta);
		}
		
		public void eMaisVelho(Funcionario vet[], int x, Calendar hoje) {
			if(vet[x].CalculaIdade(vet, hoje) > this.CalculaIdade(vet, hoje)){
				System.out.println(vet[x].getNome()+" é mais velho do que "+this.getNome());
			} else if (vet[x].CalculaIdade(vet, hoje) < this.CalculaIdade(vet, hoje)) {
				System.out.println(this.getNome()+" é mais velho do que "+vet[x].getNome());
			}
		}
	
		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public char getSexo() {
			return sexo;
		}

		public void setSexo(char sexo) {
			this.sexo = sexo;
		}

		public float getSalarioBruto() {
			return salarioBruto;
		}

		public void setSalarioBruto(float salarioBruto) {
			this.salarioBruto = salarioBruto;
		}

		public GregorianCalendar getDataAdmissao() {
			return dataAdmissao;
		}

		public void setDataAdmissao(GregorianCalendar dataAdmissao) {
			this.dataAdmissao = dataAdmissao;
		}

		public GregorianCalendar getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(GregorianCalendar dataNascimento) {
			this.dataNascimento = dataNascimento;
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
}
		




