package multiplas_msg_um_esperando_outro;

	import java.io.DataInputStream;
	import java.io.DataOutputStream;
	import java.io.IOException;
	import java.net.BindException;
	import java.net.ServerSocket;
	import java.net.Socket;
	import java.util.Scanner;

	public class TCPServidor {
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			int port = 28877;
			
			try
			{
		
				ServerSocket serverSocket = new ServerSocket(port);
				Socket socket = serverSocket.accept();
				
				
				while(true)
				{
					
					//recebe mensagem do clente
					DataInputStream entrada = new DataInputStream(socket.getInputStream());
					String resposta = entrada.readUTF();
					System.out.println("Mensagem do cliente: "+ resposta);
					
					if (resposta.equals("stop"))
					{
						socket.close();
					}
					else
					{
						//envia mensagem para o cliente
						System.out.println("Responder cliente");
						String msg = in.nextLine();
						DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
						saida.writeUTF(msg);
					}
					
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
