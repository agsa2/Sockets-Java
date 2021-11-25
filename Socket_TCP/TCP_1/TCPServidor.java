package envio_de_multiplas_mensagens_com_timeout;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServidor {
	public static void main(String[] args) {
		int port = 3001;
		
		try
		{
			
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Aguardando a conexão de um cliente.");
			//aceitar a conexão que o cliente realiza
			Socket socket = serverSocket.accept();
			socket.setSoTimeout(10000); 
			//Permitir que o servidor receba multiplas mensagens
			while(true)
			{
				System.out.println("Cliente conectado. Aguardando mensagem");
				DataInputStream entrada = new DataInputStream(socket.getInputStream());
				String resposta = entrada.readUTF();
				System.out.println("Cliente: "+ resposta);
				
			}
		
		}
		catch (BindException e)
		{
			System.out.println("Endereço em uso");
		}
		catch (IOException e)
		{
			System.out.println("Erro " + e);
		}
	}
}

