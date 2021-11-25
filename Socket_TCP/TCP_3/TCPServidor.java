package servidor_encerra_reinicia_conexao_com_timeout;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TCPServidor {
	public static void main(String[] args) throws IOException {
		int port = 28886;
		
		ServerSocket serverSocket = new ServerSocket(port);
		
		while (true)
		{
			try
			{
				System.out.println("Aguardando conexão");
				Socket socket = serverSocket.accept();	
				System.out.println("Conexão aberta");
				
				long time = System.currentTimeMillis();
				
				while (System.currentTimeMillis() < (time+20000))
				{
					socket.setSoTimeout(20000);
					DataInputStream entrada = new DataInputStream(socket.getInputStream());
					String resposta = entrada.readUTF();
					System.out.println("Cliente: "+ resposta);
				}
				
				System.out.println("Conexão fechada");
						
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
}
