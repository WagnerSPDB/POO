package td7;

public class Pessoal extends Contato{
	private String cidade, instagram;
	public Pessoal() {
		super();
	}

	public Pessoal(String nome, String telefone, String genero, String email, String observacoes, int dia, int mes, int ano, String cidade, String instagram, int aux) {
		super(nome, telefone, genero, email, observacoes, dia, mes, ano, aux);
		this.cidade = cidade;
		this.instagram = instagram;
	}
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	@Override
	public String toString() {
		return "Pessoal: [Nome: " + getNome() + ", Telefone: " + getTelefone() + ", Gênero: " + getGenero() + ", Email: " + getEmail() + 
		", Nascimento: " + getDia() + "/" + getMes() + "/" + getAno() + ", Cidade: " + cidade + ", Instagram: @" + instagram + ", Observações: " + getObservacoes() + "]";
	}

}
