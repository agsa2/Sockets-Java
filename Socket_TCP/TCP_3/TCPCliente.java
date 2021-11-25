package servidor_encerra_reinicia_conexao_com_timeout;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class TCPCliente {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int port = 28886;
		String address = "localhost";
		
		try 
		{
			Socket socket = new Socket(address,port);
			
			while(true)
			{
				
				System.out.println("Escreva uma mensagem: ");
				String msg = in.nextLine();
				DataOutputStream saida = new  DataOutputStream(socket.getOutputStream());
				saida.writeUTF(msg);
				System.out.println("Mensagem enviada");
			}
		}
		catch (ConnectException e)
		{
			System.out.println("erro de conexão");
		}
		catch (IOException e)
		{
			System.out.println("erro "+ e);
		}
	}
}
