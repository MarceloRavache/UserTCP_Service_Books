package ufc.com.br;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class livro {
	private String nome;
	private String autor;
	private String conteudo = "";
	Scanner scan = new Scanner(System.in);
	public void cadastrar() {
		String path;
		System.out.println("Digite o nome do livro");
		this.nome = scan.nextLine();
		System.out.println("Digite o path do livro");
		path = scan.nextLine();
		System.out.println("Digite o nome do autor do livro");
		System.out.println("OK1");
		this.autor = scan.nextLine();
		try {
		      FileReader arq = new FileReader(path);
		      BufferedReader lerArq = new BufferedReader(arq);
		  
		      String linha = lerArq.readLine();
		      while (linha != null) {
		        conteudo += linha;
		        linha = lerArq.readLine();
		      }
		      System.out.println("OK");
		      arq.close();
		}catch (IOException e) {
			System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
	}
	public void baixar() {
		System.out.println("Digite o nome do livro");
		this.nome = scan.nextLine();
	}
	public void gravar(String conteudo) throws FileNotFoundException, IOException {
		String path;
		System.out.println("Digite o nome do livro");
		nome = scan.nextLine();
	    FileOutputStream arquivo = new FileOutputStream(nome+".pdf");
	    DataOutputStream gravarArquivo = new DataOutputStream(arquivo);
	    gravarArquivo.writeUTF(conteudo);
	    arquivo.close();
	}
	public String getNome() {
		return this.nome;
	}
	public String getAutor() {
		return this.autor;
	}
	public String getConteudo() {
		return this.conteudo;
	}

}
