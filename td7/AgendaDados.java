package td7;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class AgendaDados implements Agenda {
	private Contato agenda[] = new Contato[100];
	private int pos;
	Calendar hoje = Calendar.getInstance();
	
	public AgendaDados() {
		super();
	}
	public Contato[] getAgenda() {
		return agenda;
	}
	public void setAgenda(Contato[] agenda) {
		this.agenda = agenda;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	public void inserir() {
		int op = 0;
		String leitura = JOptionPane.showInputDialog("Deseja inserir um contato Pessoal ou Profissional? Digite 1 para Pessoal ou 2 para Profissional");
		try {
			op = Integer.parseInt(leitura);
		} catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Você não inseriu um número inteiro.");
		}
		
		switch(op) { // Polimorfismo de Contato podendo ser Pessoal ou Profissional
		case 1:
			agenda[pos] = new Pessoal();
			try {
				agenda[pos].setNome(JOptionPane.showInputDialog("Digite o nome:"));
			} catch (FaltaDados e) {
				JOptionPane.showMessageDialog(null, e.erro);
				break;
			}
			agenda[pos].setTelefone(JOptionPane.showInputDialog("Digite o telefone:"));
			agenda[pos].setGenero(JOptionPane.showInputDialog("Digite o gênero: "));
			agenda[pos].setEmail(JOptionPane.showInputDialog("Digite o email: "));
			leitura = (JOptionPane.showInputDialog(("Digite o dia do nascimento:")));
			agenda[pos].setDia(Integer.parseInt(leitura));
			leitura = (JOptionPane.showInputDialog(("Digite o mês do nascimento:")));
			agenda[pos].setMes(Integer.parseInt(leitura));
			leitura = (JOptionPane.showInputDialog(("Digite o ano do nascimento:")));
			agenda[pos].setAno(Integer.parseInt(leitura));
			agenda[pos].setObservacoes(JOptionPane.showInputDialog("Digite as observações:"));
			((Pessoal) agenda[pos]).setCidade(JOptionPane.showInputDialog("Digite a cidade:"));
			((Pessoal) agenda[pos]).setInstagram(JOptionPane.showInputDialog("Digite o Instagram:"));
			JOptionPane.showMessageDialog(null, "Contato salvo com sucesso! ");
			agenda[pos].setAux(1);
			break;
		case 2:
			agenda[pos] = new Profissional();
			try {
				agenda[pos].setNome(JOptionPane.showInputDialog("Digite o nome:"));
			} catch (FaltaDados e) {
				JOptionPane.showMessageDialog(null, e.erro);
			}
			agenda[pos].setTelefone(JOptionPane.showInputDialog("Digite o telefone:"));
			agenda[pos].setGenero(JOptionPane.showInputDialog("Digite o gênero: "));
			agenda[pos].setEmail(JOptionPane.showInputDialog("Digite o email: "));
			leitura = (JOptionPane.showInputDialog(("Digite o dia do nascimento:")));
			agenda[pos].setDia(Integer.parseInt(leitura));
			leitura = (JOptionPane.showInputDialog(("Digite o mês do nascimento:")));
			agenda[pos].setMes(Integer.parseInt(leitura));
			leitura = (JOptionPane.showInputDialog(("Digite o ano do nascimento:")));
			agenda[pos].setAno(Integer.parseInt(leitura));
			((Profissional) agenda[pos]).setProfissao(JOptionPane.showInputDialog("Digite a profissão:"));
			((Profissional) agenda[pos]).setLinkedin(JOptionPane.showInputDialog("Digite o LinkedIn:"));
			JOptionPane.showMessageDialog(null, "Contato salvo com sucesso!");
			agenda[pos].setAux(2);
			break;
		default:
			JOptionPane.showMessageDialog(null, "O número inserido não corresponde a nenhuma opção!");
		}
		
		try { 
			if(agenda[pos].getNome() != null) { // Só aumenta o índice se o nome recebido não for null
				pos++;
			}
		} catch (NullPointerException e){} // Trata a exceção, pois se o nome não for recebido, o índice estará vazio
		
	}

	public void imprimir() {
		String leitura = (JOptionPane.showInputDialog(("Deseja imprimir todas as informações ou apenas as principais?\nDigite 1 para todas e 2 para principais: ")));
		int op = (Integer.parseInt(leitura));
		System.out.println("---------- AGENDA ----------");
		switch(op) {
		case 1:
			for(int i = 0; i < 100; i++) {
				if(agenda[i] != null) {
					System.out.println(agenda[i].toString()); //Ligação Tardia
				} else {
					break;
				}
			}
			break;
		case 2:
			for(int i = 0; i < 100; i++) {
				if(agenda[i] != null) {
					System.out.println("Nome: " + agenda[i].getNome()+ ", Telefone: " + agenda[i].getNome() + ", Email: " + agenda[i].getEmail());
				} else {
					break;
				}
			}
			break;
		}
		
	}


	public void buscaNome() {
		String busca;
		busca = JOptionPane.showInputDialog("Digite o nome que deseja buscar: ");
		for(int i = 0; i < 100; i++) {
			if(agenda[i] == null) {
				break;
			} else {
				if(agenda[i].getNome().equals(busca)) {
					JOptionPane.showMessageDialog(null, agenda[i].toString());
				}
			}
		}
	}
	
	public void buscaData() {
		int buscaDia, buscaMes;
		String leitura;
		leitura = JOptionPane.showInputDialog("Digite o dia que deseja buscar: ");
		buscaDia = Integer.parseInt(leitura);
		leitura = JOptionPane.showInputDialog("Digite o mês que deseja buscar: ");
		buscaMes = Integer.parseInt(leitura);
		for(int i = 0; i < 100; i++) {
			if(agenda[i] == null) {
				break;
			} else if(agenda[i].getDia() == buscaDia && agenda[i].getMes() == buscaMes) {
				JOptionPane.showMessageDialog(null, agenda[i].toString());	
			}
		}
	}
	
	public void maisVelhoeNovo() {
		int novo = 200, velho = 0;
		String nomeVelho = "NULL", nomeNovo = "NULL";
		for(int i = 0; i < agenda.length; i++) {
			if(agenda[i] != null) {
				if(agenda[i].CalculaIdade(agenda, hoje) < novo) {
					novo = agenda[i].CalculaIdade(agenda, hoje);
					nomeNovo = agenda[i].getNome();
				}
				if(agenda[i].CalculaIdade(agenda, hoje) > velho) {
					velho = agenda[i].CalculaIdade(agenda, hoje);
					nomeVelho = agenda[i].getNome();
				}
			} else {
				break;
				
			}
		}
		JOptionPane.showMessageDialog(null, "O funcionário mais velho é o "+nomeVelho+" com "+velho+" anos. E o funcionário mais novo é o "+nomeNovo+" com "+novo+" anos.");
	}
	
	

}
