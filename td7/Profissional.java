package td7;

public class Profissional extends Contato{
	String profissao, linkedin;
	public Profissional() {
		super();
	}
	
	public Profissional(String nome, String telefone, String genero, String email, String observacoes, int dia, int mes, int ano, String profissao, String linkedin, int aux) {
		super(nome, telefone, genero, email, observacoes, dia, mes, ano, aux);
		this.profissao = profissao;
		this.linkedin = linkedin;
		aux = 2;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	@Override
	public String toString() {
		return "Profissional: [Nome: " + getNome() + ", Telefone: " + getTelefone() + ", Gênero: " + getGenero() + ", Email: " + getEmail() + 
		", Nascimento: " + getDia() + "/" + getMes() + "/" + getAno() + ", Profissão: " + profissao + ", LinkedIn: @" + linkedin + ", Observações: " + getObservacoes() + "]";
	}

	

	
}

