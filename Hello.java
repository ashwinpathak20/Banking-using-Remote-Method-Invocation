import java.rmi.Remote; 
import java.rmi.RemoteException;  
import java.util.ArrayList;

// Creating Remote interface for our application 
public interface Hello extends Remote {  
   public String getName(int acc_no) throws RemoteException;
   public void setName(int acc_no, String name) throws RemoteException;
   public String getType(int acc_no) throws RemoteException;
   public void setType(int acc_no, String type) throws RemoteException;
   public Double getBalance(int acc_no) throws RemoteException;
   public void setBalance(int acc_no, double val) throws RemoteException;
   public void getBalanceinit(int acc_no) throws RemoteException;
   public String getInfo(int acc_no) throws RemoteException;
   public void setInfo(int acc_no, String info) throws RemoteException;
   public double deposit(int acc_no, double x) throws RemoteException;
   public double[] withdraw(int acc_no, double x) throws RemoteException;
   public void populate() throws RemoteException;
   public double balance(int acc_no) throws RemoteException;
   public void settypeofop(int acc_no) throws RemoteException;
   public ArrayList<String> gettypeofop(int acc_no) throws RemoteException;
   public void settranamount(int acc_no) throws RemoteException;
   public ArrayList<Double> gettranamount(int acc_no) throws RemoteException;
   public void settrantime(int acc_no) throws RemoteException;
   public ArrayList<String> gettrantime(int acc_no) throws RemoteException;
   public ArrayList<ArrayList<String> > history(int acc_no,String start,String end) throws RemoteException;
}   