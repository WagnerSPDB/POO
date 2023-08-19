package td6;

public interface Colecao {

	public boolean inserir(Pessoa p); //Pessoa p

	public boolean remover(int indice); //int indice

	public void atualizar(int indice, Pessoa p); //int indice, pessoa p

	public boolean pesquisar(Pessoa p); //Pessoa p

	public boolean colecaoEstaVazia(); // Vazio

	public void imprimirDadosColecao(); //Vazio

	public Pessoa retornarObjeto(int indice); //int indice
}

