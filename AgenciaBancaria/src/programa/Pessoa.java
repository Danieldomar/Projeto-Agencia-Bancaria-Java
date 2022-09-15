package programa;

public class Pessoa {
	
	private static int counter = 0;
	
	private String nome; 
	private String cpf;
	private String email;
	
	
	
	
	public Pessoa(String nome, String cpf, String email) {
		
		
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		
		//Todas as vezes que uma pessoa for adcionada, será contado +1
		
		counter += 1;
	}
	
	//Gerando os construtores ...
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		
		return "\nNome: " + this.getNome() +
				"\nCPF: " + this.getCPF() +
				"\nEmail: " + this.getEmail();
	}
	

}
