import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.io.*;

public class Hello implements HelloInterface, Serializable {
	
	String phrase = "";

	public Hello(String a) {
		phrase = a;
	}

	public String say() {
		return(phrase);
	}

        public static void main (String[] args) {
    		try {
		         System.setProperty("java.rmi.server.hostname", "192.168.1.237");
			 Hello hello = new Hello("Hello, World!");
			 //hello.setLog(System.out);
			 System.out.println("Hello object: " + hello.toString());
       			 Registry registry = LocateRegistry.getRegistry(1099);
			 System.out.println("registry found");
       			 registry.rebind("Hello", hello);
       			 System.out.println("ComputeEngine bound");
	 		 System.out.println("registry listing " + registry.list());

			 System.out.println ("Hello Server is ready.");
    		} catch (Exception e) {
      			 System.out.println ("Hello Server failed: " + e);
   	        }	
        } 
}
		
