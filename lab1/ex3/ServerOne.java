import java.net.*;
import java.io.*;

public class ServerOne {
	public static void main(String[] args) {
		startServer();
	}

	public static void startServer() {
		try {
			ServerSocket server = new ServerSocket(20009, 50);
			System.out.println("port: "+server.getLocalPort()+"\nhost: "+InetAddress.getLocalHost());
			do {
				//System.out.println("We made it to the do!");			
				Socket clientSocket = server.accept();
				BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				System.out.println(input.readLine());
			} while(!server.isClosed());
	
		}
		catch(IOException e) {
			System.out.println("ioexception");

		}
	}
}	
			
