package td7;

public class FaltaDados extends Exception {
	
	public String erro;
	
	FaltaDados(){
		this.erro = "Nome obrigatório!";
	}
}
