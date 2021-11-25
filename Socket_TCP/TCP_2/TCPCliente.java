package multiplas_msg_um_esperando_outro;

	import java.io.DataInputStream;
    import java.io.DataOutputStream;
	import java.io.IOException;
	import java.net.ConnectException;
	import java.net.Socket;
	import java.util.Scanner;

	public class TCPCliente {
		
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			int port = 28877;
			String address = "localhost";
			
			try 
			{
				Socket socket = new Socket(address,port);
				
				while(true)
				{
					
					//envia mensagens para o servidor
					System.out.println("Escreva a mensagem para o servidor");
					String msg = in.nextLine();
					DataOutputStream saida = new  DataOutputStream(socket.getOutputStream());
					saida.writeUTF(msg);
					
					//recebe mensagem do servidor
					DataInputStream entrada = new DataInputStream(socket.getInputStream());
					String resposta = entrada.readUTF();
					System.out.println("Resposta do servidor: " + resposta);
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
