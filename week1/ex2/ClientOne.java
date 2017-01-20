import java.net.*;
import java.io.*;

public class ClientOne {
	public static void main(String[] args) {
		startClient(args[0], args[1]);
	}

	public static void startClient(String msg, String hostname) {
		try {
			Socket client = new Socket(hostname, 20009);
			System.out.println(client.getLocalPort());
			//PrintWriter output = new PrintWriter(client.getOutputStream(), true);
			DataOutputStream output = new DataOutputStream(client.getOutputStream());
			output.writeUTF(msg);
			output.flush();
			output.close();

		} catch (IOException e) {
			System.out.println("ioexception");
		}
	}
}
