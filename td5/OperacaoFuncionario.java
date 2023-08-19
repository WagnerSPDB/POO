
package empresa;

import java.util.Calendar;

public class OperacaoFuncionario {
	
	public static void ValidaFuncionario(Funcionario vet[], Calendar hoje) {
		for(int i = 0; i < vet.length; i++) {
			if(vet[i].ValidaNascimento(vet) + vet[i].ValidaAdmissao(vet, hoje) + vet[i].ValidaCpf(vet) == 3) {
				System.out.println("Dados do funcionário "+vet[i].getNome()+" válidos!");
			} else {
				System.out.println("Dados do funcionário "+vet[i].getNome()+" inválidos.");			}
		}
	}
	
	public static void ContaSexo(Funcionario vet[]) {
		int contM = 0, contF = 0;
		for(int i = 0; i < vet.length; i++) {
			if(vet[i].sexo == 'm' || vet[i].sexo == 'M') {
				contM++;
			} else if(vet[i].sexo == 'f' || vet[i].sexo == 'F') {
				contF++;
			}
		}
		System.out.println("\nHá "+contM+" funcionários homens e "+contF+" funcionárias mulheres!");
	}
	
	public static void MaiorMenorSalario(Funcionario vet[]) {
		double maior = vet[0].SalarioLiquido(vet[0].salarioBruto);
		double menor = vet[0].SalarioLiquido(vet[0].salarioBruto);
		String maiorSalario = "NULL", menorSalario = "NULL";
		for(int i = 0; i < vet.length; i++) {
			if(maior <= vet[i].SalarioLiquido(vet[i].salarioBruto)) {
				maior = vet[i].SalarioLiquido(vet[i].salarioBruto);
				maiorSalario = vet[i].getNome();
			}
			if (menor >= vet[i].SalarioLiquido(vet[i].salarioBruto)) {
				menor = vet[i].SalarioLiquido(vet[i].salarioBruto);
				menorSalario = vet[i].getNome();
			}
		}
		System.out.println("\nO maior salário liquido é de "+maiorSalario+" e o menor salário liquido é de "+menorSalario);
	}
	
	public static void MaisVelhoNovo(Funcionario vet[], Calendar hoje) {
		int novo = 200, velho = 0;
		String nomeVelho = "NULL", nomeNovo = "NULL";
		for(int i = 0; i < vet.length; i++) {
			if(vet[i].CalculaIdade(vet, hoje) < novo) {
				novo = vet[i].CalculaIdade(vet, hoje);
				nomeNovo = vet[i].getNome();
			}
			if(vet[i].CalculaIdade(vet, hoje) > velho) {
				velho = vet[i].CalculaIdade(vet, hoje);
				nomeVelho = vet[i].getNome();
			}
		}
		System.out.println("O funcionário mais velho é o "+nomeVelho+" com "+velho+" anos. E o funcionário mais novo é o "+nomeNovo+" com "+novo+" anos.");
	}
	
	
	public static void TotalBonificacoes(Analista vet[]) {
		double total = 0;
		for(int i = 0; i < vet.length; i++) {
			total += vet[i].getBonificacao(vet);
		}
		System.out.println("Soma das bonificações de todos os funcionarios: "+total);
	}
	
	public static void AposentaFuncionarios(Funcionario vet[], Calendar hoje) {
		for(int i = 0; i < vet.length; i++) {
			vet[i].dataAposentadoria(vet, hoje);
		}
	}
}



