
import empresa.Funcionario;
import empresa.OperacaoFuncionario;
import empresa.Programador;
import empresa.Analista;
import empresa.Gerente;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class App {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Funcionario vet [] = new Funcionario[12];
		Programador pro[] = new Programador[6];
		Analista ana[] = new Analista[4];
		Gerente ger[] = new Gerente[2];
		int ano, mes, dia, x, op;
		
		Calendar hoje = Calendar.getInstance();
		
		int contPro = 0, contAna = 0, contGer = 0;
		for(int i = 0; i < vet.length; i++) {
			
			System.out.println("Que tipo de funcionário deseja registrar? 1 - Programador // 2 - Analista // 3 - Gerente");
			op = scan.nextInt();
			scan.nextLine();
			if(op == 1) {
				pro[contPro] = new Programador();
				System.out.println("Digite o nome do programador: ");
				pro[contPro].setNome(scan.nextLine());
				pro[contPro].setDataNascimento(new GregorianCalendar());
				System.out.println("Digite a data de nascimento: dd mm aaaa: ");
				pro[contPro].setDia(scan.nextInt());
				pro[contPro].setMes(scan.nextInt());
				pro[contPro].setAno(scan.nextInt());
				scan.nextLine();
				pro[contPro].getDataNascimento().set(pro[contPro].getAno(), pro[contPro].getMes(), pro[contPro].getDia());
				System.out.println("Digite o cpf: ");
				pro[contPro].setCpf(scan.nextLine());
				System.out.println("Digite o sexo do funcionario "+(contPro+1)+" (m pra masculino e f pra feminino): ");
				pro[contPro].setSexo(scan.next().charAt(0));
				scan.nextLine();
				System.out.println("Digite o salario bruto: ");
				pro[contPro].setSalarioBruto(scan.nextFloat());
				scan.nextLine();
				
				contPro++;
	
			} else if(op == 2) {
				ana[contAna] = new Analista();
				System.out.println("Digite o nome do analista: ");
				ana[contAna].setNome(scan.nextLine());
				ana[contAna].setDataNascimento(new GregorianCalendar());
				System.out.println("Digite a data de nascimento: dd mm aaaa: ");
				ana[contAna].setDia(scan.nextInt());
				ana[contAna].setMes(scan.nextInt());
				ana[contAna].setAno(scan.nextInt());
				scan.nextLine();
				ana[contAna].getDataNascimento().set(ana[contAna].getAno(), ana[contAna].getMes(), ana[contAna].getDia());
				System.out.println("Digite o cpf: ");
				ana[contAna].setCpf(scan.nextLine());
				System.out.println("Digite o sexo do funcionario "+(contAna+1)+" (m pra masculino e f pra feminino): ");
				ana[contAna].setSexo(scan.next().charAt(0));
				scan.nextLine();
				System.out.println("Digite o salario bruto: ");
				ana[contAna].setSalarioBruto(scan.nextFloat());
				System.out.println(ana[contAna].toString());
				contAna++;
				
			} else if(op == 3) {
				ger[contGer] = new Gerente();
				System.out.println("Digite o nome do gerente: ");
				ger[contGer].setNome(scan.nextLine());
				ger[contGer].setDataNascimento(new GregorianCalendar());
				System.out.println("Digite a data de nascimento: dd mm aaaa: ");
				ger[contGer].setDia(scan.nextInt());
				ger[contGer].setMes(scan.nextInt());
				ger[contGer].setAno(scan.nextInt());
				scan.nextLine();
				ger[contGer].getDataNascimento().set(ger[contGer].getAno(), ger[contGer].getMes(), ger[contGer].getDia());
				System.out.println("Digite o cpf: ");
				ger[contGer].setCpf(scan.nextLine());
				System.out.println("Digite o sexo do funcionario "+(contGer+1)+" (m pra masculino e f pra feminino): ");
				ger[contGer].setSexo(scan.next().charAt(0));
				scan.nextLine();
				System.out.println("Digite o salario bruto: ");
				ger[contGer].setSalarioBruto(scan.nextFloat());
			}
			
			
		}
		int aux = 0;
		for(int i = 0; i < 6; i++) {
			vet[i] = pro[i];
		}
		aux = 0;
		for(int i = 6; i < 10; i++) {
			vet[i] = ana[aux];
			aux++;
		}
		aux = 0;
		for(int i = 10; i < 12; i++) {
			vet[i] = ger[aux];
			aux++;
		}
		for(int i = 0; i < vet.length; i++) {
			System.out.println(vet[i].toString());
		}
		
		System.out.println("A idade do "+vet[0].getNome()+" é: "+vet[0].CalculaIdade(vet, hoje));
		System.out.println("A idade do "+vet[1].getNome()+" é: "+vet[1].CalculaIdade(vet, hoje));
		
		if(vet[0].FuncionarioIgual(vet) == 1) {
			System.out.println("\nHá Funcionarios iguais!");
		} else {
			System.out.println("\nNão há funcionários iguais.");
		}
		
		OperacaoFuncionario.MaiorMenorSalario(vet);
		OperacaoFuncionario.ContaSexo(vet);
		
		vet[0].ValidaNascimento(vet);
		vet[0].ValidaAdmissao(vet, hoje);
		
		OperacaoFuncionario.MaisVelhoNovo(vet, hoje);
		
		OperacaoFuncionario.ValidaFuncionario(vet, hoje);
		
		for(int i = 0; i < vet.length; i++) {
			System.out.println(vet[i].toString());
			vet[i].dataAposentadoria(vet, hoje);
		}
		System.out.println("Digite qual funcionario deseja comparar: ");
		x = scan.nextInt();
		vet[1].eMaisVelho(vet, x, hoje);
		
		System.out.println(vet[0].getBonificacao(vet));
		
		OperacaoFuncionario.AposentaFuncionarios(vet, hoje);
		
		System.out.println(ana.toString());
		System.out.println(ger.toString());
		System.out.println(pro.toString());
		
		OperacaoFuncionario.TotalBonificacoes(ana);
	}
}

