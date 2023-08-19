QUESTAO 1

import java.util.Scanner;
public class Main {
	public static float soma(float a, float b) {
		return a + b;
	}

	public static float sub(float a, float b) {
		return a - b;
	}

	public static float mult(float a, float b) {
		return a * b;
	}

	public static float div(float a, float b) {
		return a / b;
	}

	public static void main(String[] args) {
		float x = 0, y = 0;
		String z;
		float resultado = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o primeiro número: ");
		x = scan.nextFloat();
		System.out.println("Digite o segundo número: ");
		y = scan.nextFloat();
		System.out.println("Digite o símbolo da operação desejada: Soma + ; Subtração - ; Multiplicação * ; Divisão /.");
		z = scan.next();
		if (z.equals("+")) {
			resultado = soma(x, y);
		} else if (z.equals("-")) {
			resultado = sub(x, y);
		} else if (z.equals("*")) {
			resultado = mult(x, y);
		} else if (z.equals("/") && y!=0) {
			resultado = div(x, y);
		} else {
			System.out.println("Código inválido!");
			System.exit(0);
		}
		System.out.println("O resultado é: " +resultado);

	}
}


QUESTAO 2 

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = 0, contPar = 0, contImpar = 0, contPos = 0, contNeg = 0, contNeut = 0;
		System.out.println("Digite o tamanho desejado para o vetor: ");
		n = scan.nextInt();
		int[] vet = new int[n];
		for (int i = 0; i < vet.length; i++) {
			System.out.println("Digite a posicao " + i + " do vetor: ");
			vet[i] = scan.nextInt();
		}
		for (int i : vet) {
			if (i % 2 == 0) {
				contPar++;
			} else {
				contImpar++;
			}
			if (i > 0) {
				contPos++;
			} else if (i < 0) {
				contNeg++;
			} else {
				contNeut++;
			}
		}
		System.out.println("PARES: " + contPar);
		System.out.println("IMPARES: " + contImpar);
		System.out.println("POSITIVOS: " + contPos);
		System.out.println("NEGATIVOS: " + contNeg);
		System.out.println("NEUTROS: " + contNeut);

	}
}


QUESTAO 3

import java.util.Scanner;
import java.util.Random;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int n = 0, maior = -1;
		System.out.print("Digite o tamanho desejado para o vetor: ");
		n = scan.nextInt();
		if(n <= 0){
		    System.out.println("Tamanho do vetor inválido!");
		    System.exit(0);
		}
		int[] vet = new int[n];
		for (int i = 0; i < vet.length; i++) {
			vet[i] = rand.nextInt(1000);
		}
		for (int i = 0; i < vet.length; i++) {
		    System.out.println(vet[i]);
			if(maior < vet[i]){
			    maior = vet[i];
			}
		}
		System.out.println("\nO maior elemento do vetor é: "+maior);
	}
}


QUESTAO 4

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
	    Scanner scan = new Scanner (System.in);
	    String senha;
	    int resultado;
	    do{
	    	System.out.println("Digite a senha: ");
	    	senha = scan.nextLine();
	    	resultado = senha.compareTo("a76dk09");
	    	if (resultado != 0){
	       		System.out.println("SENHA INVÁLIDA\n");
	    	} 
	    }while(resultado != 0);
	    System.out.println("ACESSO PERMITIDO");
	}
}


QUESTAO 5

import java.util.Scanner;
public class Main {
	public static float media(float vet[], int n){
        	float soma = 0, media = 0;
        	for (int i = 0; i < vet.length; i++){
            		soma += vet[i];
		}
        	media = soma/n;
        	return media;
	}
    
    	public static double desvio(float vet[], int n){
       		double desvio = 0, variancia = 0;
        	float m = media(vet, n);
        	for(int i = 0; i < vet.length; i++){
            		variancia += Math.pow((vet[i] - m), 2)/n;
        	}
        	desvio = Math.sqrt(variancia);
        	return desvio;
	}
    
	public static void main(String[] args) {
	    Scanner scan = new Scanner (System.in);
	    int n = 0;
	    System.out.println("Digite o tamanho do vetor: ");
	    n = scan.nextInt();
	    float[] vet = new float[n];
	    for(int i = 0; i < vet.length; i++){
	        System.out.println("Digite a posição "+i+" do vetor: ");
	        vet[i] = scan.nextFloat();
	    }
	    System.out.println("A média é: "+media(vet, n));
	    System.out.println("O desvio padrão é: "+desvio(vet, n));
	}
}


QUESTAO 6

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int h1 = 0, m1 = 0, h2 = 0, m2 = 0, dh = 0, dm = 0;
		System.out.println("Digite a hora e minuto que voce dormiu e a hora e minuto que voce acordou:");
		h1 = scan.nextInt();
		m1 = scan.nextInt();
		h2 = scan.nextInt();
		m2 = scan.nextInt();
		if(h1 >= 0 && h1 <= 23 && m1 >= 0 && m1 <= 59 && h2 >= 0 && h2 <= 23 && m2 >= 0 && m2 <= 59) {
			if(h1 == h2 && m1 > m2) {
				dh = 23 * 60;
				dm = (60 - m1) + m2;
			}else if(h1 <= h2 && m1 <= m2) {
				dh = (h2 - h1) * 60;
				dm = (m2 - m1);
			}else if(h1 <= h2 && m1 >= m2) {
				dh = (h2 - h1) * 60;
				dm = (60 - m1) + m2;
			}else if(h1 >= h2 && m1 <= m2) {
				dh = ((23 - h1) + h2) * 60;
				dm = (m2 - m1);
			}else if(h1 >= h2 && m1 >= m2) {
				System.out.println("Bora Bill");
				dh = ((23 - h1) + h2) * 60;
				dm = (60 - m1) + m2;
			}
		}
			System.out.println(dh + dm);	
	}
}
