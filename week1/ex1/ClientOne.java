import java.net.*;
import java.io.*;

public class ClientOne {
	public static void main(String[] args) {
		startClient(args[0]);
	}

	public static void startClient(String a) {
		try {
			Socket client = new Socket(InetAddress.getLocalHost(), 4444);
			System.out.println(client.getLocalPort());
			//PrintWriter output = new PrintWriter(client.getOutputStream(), true);
			DataOutputStream output = new DataOutputStream(client.getOutputStream());
			output.writeUTF(a);
			output.flush();
			output.close();

		} catch (IOException e) {
			System.out.println("ioexception");
		}
	}
}
