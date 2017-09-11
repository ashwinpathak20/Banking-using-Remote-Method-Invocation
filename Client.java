import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;
import java.io.*; 
import java.util.ArrayList;

public class Client {  
   private Client() {}

   public static void main(String[] args) {  
      try {  
         // Getting the registry 
         Registry registry = LocateRegistry.getRegistry(null); 
    
         // Looking up the registry for the remote object 
         Hello stub = (Hello) registry.lookup("Hello"); 
    
         // Calling the remote method using the obtained object
         while(true)
         {
            java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String textin = in.readLine();
            String[] splitted = textin.split(" ");
            if(splitted[0].equals("deposit"))
            {
               int acc_no = Integer.parseInt(splitted[1]);
               Double amount = Double.parseDouble(splitted[2]);
               System.out.println("Success!");
               System.out.println("Your balance : " + stub.deposit(acc_no,amount));
            }
            if(splitted[0].equals("withdraw"))
            {
               int acc_no = Integer.parseInt(splitted[1]);
               Double amount = Double.parseDouble(splitted[2]);
               double[] get = stub.withdraw(acc_no,amount);
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
            }
            if(splitted[0].equals("balance"))
            {
               int acc_no = Integer.parseInt(splitted[1]);
               System.out.println("Your balance : " + stub.balance(acc_no));
            }
            if(splitted[0].equals("history"))
            {
               int acc_no = Integer.parseInt(splitted[1]);
               int i=0;
               ArrayList<ArrayList<String> > transact = stub.history(acc_no,splitted[2],splitted[3]);
               System.out.println("___________________________________________");
               System.out.println("|         Date        | Transcation | Amount |");
               System.out.println("___________________________________________");
               while(i<transact.get(0).size())
               {
                  System.out.println("| " + (transact.get(0)).get(i) + " | " + (transact.get(1)).get(i) + " |  " + (transact.get(2)).get(i) +"  |");
                  System.out.println("___________________________________________");
                  i++;
               }
               //System.out.println(stub.history(acc_no,splitted[2],splitted[3]));
            }
            if(splitted[0].equals("exit"))
            {
               break;
            }
         }
 
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}