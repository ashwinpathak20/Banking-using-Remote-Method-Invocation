import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;  

public class Client {  
   private Client() {}  
   public static void main(String[] args) {  
      try {  
         // Getting the registry 
         Registry registry = LocateRegistry.getRegistry(null); 
    
         // Looking up the registry for the remote object 
         Hello stub = (Hello) registry.lookup("Hello"); 
    
         // Calling the remote method using the obtained object
         System.out.println(stub.deposit(100,50));
         System.out.println(stub.deposit(100,50));
         double[] get = stub.withdraw(100,10);
         if(get[0]==0)
         {
            System.out.println("Sorry! you don't seem to have enough balance");
            System.out.println("Your balance :" + get[1]);
         }
         else
         {
            System.out.println("Transcation successful");
            System.out.println("Your balance :" + get[1]);
         }
         System.out.println(stub.balance(100));
         System.out.println(stub.gettypeofop(100));
         System.out.println(stub.gettranamount(100));
         System.out.println(stub.gettrantime(100));
         // System.out.println("Remote method invoked"); 
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}