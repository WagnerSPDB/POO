package td7;
import javax.swing.JOptionPane; // API Java utilizada

public class App{
	public static void main(String[] args) {
		int op = 0;
		String leitura;
		AgendaDados chama = new AgendaDados();
		do {
			leitura = JOptionPane.showInputDialog("---------- MENU ----------\nDigite a opção: \n1 - Inserir Contato\n2 - Imprimir Agenda\n3 - Imprimir Mais Velha e Mais Nova\n4 - Busca por nome\n5 - Busca por aniversário\n6 - Sair");
			try {
				op = Integer.parseInt(leitura);
			} catch (Exception e) {
				op = 6;
			}
			
			switch(op) {
			case 1:
				chama.inserir();
				break;
			case 2:
				chama.imprimir();
				break;
			case 3:
				chama.maisVelhoeNovo();
				break;
			case 4:
				chama.buscaNome();
				break;
			case 5:
				chama.buscaData();
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "Obrigado por usar nosso sistema :D");
				break;
			default:
				JOptionPane.showMessageDialog(null, "A opção selecionada é inválida.");
				break;
			}
			
		}while(op == 1 || op == 2 || op == 3 || op == 4 || op == 5);
	}
}
