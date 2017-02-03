import java.rmi.*;
import java.lang.Exception.*;
import java.net.MalformedURLException;

public abstract class HelloClient implements HelloInterface {


	public static void main(String[] args) {
		getIt();
	}
	public static void getIt() {
		try {
			HelloInterface hello = (HelloInterface)
				Naming.lookup("//192.168.1.237:400/Hello");
			System.out.println(hello.say());
		} catch (NotBoundException|RemoteException|MalformedURLException e) {
			e.printStackTrace(System.out);
		}
	}
}
