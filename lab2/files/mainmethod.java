  public static void main (String[] argv) {
    try {
		 System.setProperty("java.rmi.server.hostname", "hostname of my server machine");
			 Hello hello = new Hello("Hello, World!");
	//		 hello.setLog(System.out);
//			 System.out.println("Hello object: " + hello.toString());
       Registry registry = LocateRegistry.getRegistry(20005);
       registry.rebind("Hello", hello);
       System.out.println("ComputeEngine bound");
 //      System.out.println("registry listing " + registry.list());

			System.out.println ("Hello Server is ready.");
    } catch (Exception e) {
      System.out.println ("Hello Server failed: " + e);
    }
  }
