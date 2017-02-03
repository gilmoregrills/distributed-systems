import java.rmi.*;
import java.lang.Exception.*;
import java.net.MalformedURLException;
import java.io.*;

public abstract class HelloClient implements HelloInterface, Serializable {


	public static void main(String[] args) {
		try {
			HelloInterface hello = (HelloInterface)
				Naming.lookup("//192.168.1.237:1099/Hello");
			System.out.println(hello.say());
		} catch (NotBoundException|RemoteException|MalformedURLException e) {
			e.printStackTrace(System.out);
		}

	}
}
