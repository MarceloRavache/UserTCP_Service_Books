package ufc.com.br;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UserTCP {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int op = 1000;
		Socket socketCli = new Socket("localhost",9004);
		ClientTCP cli = new ClientTCP();
		livro book = new livro();
		 while(op != 0) {
			 System.out.println("1 - Cadastrar livro(Upload)");
			 System.out.println("2 - baixar livro(Download)");
			 System.out.println("0 - Sair");
			 op = scan.nextInt();
			 switch(op) {
			 	case 1:
			 		cli.doOperation(socketCli, 0, book);
			 		break;
			 	case 2:
			 		cli.doOperation(socketCli, 1, book);
			 		break;
			 	default:
			 		System.out.println("opcao invalida!");
			 		break;
			 }
			 
			 }
		 }

}
