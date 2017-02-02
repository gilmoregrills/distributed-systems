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
			int redVote = 0;
			int blueVote = 0;
			int greenVote = 0;
			do {
				System.out.println("We made it to the do!");			
				Socket clientSocket = server.accept();
				BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String word = input.readLine();
				System.out.println(word);
				if (word.equals("red")) {
					redVote++;
					System.out.println("+1 for red");
				} else if (word.equals("blue")) {
					blueVote++;
					System.out.println("+1 for blue");
				} else if (word.equals("green")) {
					greenVote++;
					System.out.println("+1 for green");
				} else if (word.equals("count")) {
					System.out.println("Green got: "+greenVote+" votes, red got: "+redVote+" votes, and blue got: "+blueVote+ "votes.");
				}
			} while(!server.isClosed());
	
		}
		catch(IOException e) {
			System.out.println("ioexception");

		}
	}
}	
			
