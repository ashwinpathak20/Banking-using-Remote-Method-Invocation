import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.*;  
import java.rmi.server.*;
import java.util.*;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ImplExample implements Hello
{  
	public HashMap<Integer,String> mapName = new HashMap<Integer,String>();
	public HashMap<Integer,String> mapType = new HashMap<Integer,String>();
	public HashMap<Integer,Double> mapBalance = new HashMap<Integer,Double>();
	public HashMap<Integer,String> mapInfo = new HashMap<Integer,String>();
	public HashMap<Integer,ArrayList<String> > typeofop = new HashMap<Integer,ArrayList<String> >();
	public HashMap<Integer,ArrayList<Double> > tranamount = new HashMap<Integer,ArrayList<Double> >();
	public HashMap<Integer,ArrayList<String> > trantime = new HashMap<Integer,ArrayList<String> >();

	public String getName(int acc_no)
	{
  		return mapName.get(acc_no);
	}
	public void setName(int acc_no, String name)
	{
		mapName.put(acc_no, name);
	}
	public String getType(int acc_no)
	{
  		return mapType.get(acc_no);
	}
	public void setType(int acc_no, String type)
	{
		mapName.put(acc_no, type);
	}
	public Double getBalance(int acc_no)
	{
  		return mapBalance.get(acc_no);
	}
	public void setBalance(int acc_no, double val)
	{
		double base = getBalance(acc_no);
		mapBalance.put(acc_no, base+val);
	}
	public void getBalanceinit(int acc_no)
	{
  		mapBalance.put(acc_no,0.0);
	}
	public String getInfo(int acc_no)
	{
  		return mapName.get(acc_no);
	}
	public void setInfo(int acc_no, String info)
	{
		mapName.put(acc_no, info);
	}
	public void settypeofop(int acc_no)
	{
		ArrayList<String> al=new ArrayList<String>();
		typeofop.put(acc_no, al);
	}
	public ArrayList<String> gettypeofop(int acc_no)
	{
		return typeofop.get(acc_no);
	}
	public void settranamount(int acc_no)
	{
		ArrayList<Double> al=new ArrayList<Double>();
		tranamount.put(acc_no, al);
	}
	public ArrayList<Double> gettranamount(int acc_no)
	{
		return tranamount.get(acc_no);
	}
	public void settrantime(int acc_no)
	{
		ArrayList<String> al=new ArrayList<String>();
		trantime.put(acc_no, al);
	}
	public ArrayList<String> gettrantime(int acc_no)
	{
		return trantime.get(acc_no);
	}

	public double balance(int acc_no)
	{
		return getBalance(acc_no);
	}

	public double deposit(int acc_no, double x)
	{
		setBalance(acc_no,x);
		ArrayList<String> al = gettypeofop(acc_no);
		ArrayList<Double> al1 = gettranamount(acc_no);
		String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		ArrayList<String> al2 = gettrantime(acc_no);
		al.add("deposit");
		typeofop.put(acc_no, al);
		al1.add(x);
		al2.add(time);
		tranamount.put(acc_no, al1);
		trantime.put(acc_no, al2);
		return getBalance(acc_no);
	}

	public double[] withdraw(int acc_no, double x)
	{
		double curr = getBalance(acc_no);
		double bal;
		String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		//System.out.println(time);
		if(curr<x)
		{
			double[] ans = {0,curr};
			return ans;
		}
		else
		{
			setBalance(acc_no,-x);
			ArrayList<String> al = gettypeofop(acc_no);
			ArrayList<Double> al1 = gettranamount(acc_no);
			al.add("withdraw");
			ArrayList<String> al2 = gettrantime(acc_no);
			typeofop.put(acc_no, al);
			al1.add(x);
			tranamount.put(acc_no, al1);
			al2.add(time);
			trantime.put(acc_no, al2);
			bal = getBalance(acc_no);
			double[] ans = {1,bal};
			return ans;
		}
	}

	public void populate()
	{
		String[] namearr = {"Ashwin","Pathak","Ash","Pat"};
		String[] typearr = {"Premium","Type","Type","Premium"};
		String[] infoarr = {"idk","idk","idk","idk"};
		Integer[] accarr = {100,101,102,103};
		//ImplExample im = new ImplExample();
		for(int i=0;i<4;i++)
		{
			setName(accarr[i],namearr[i]);
			setType(accarr[i],typearr[i]);
			setInfo(accarr[i],infoarr[i]);
			getBalanceinit(accarr[i]);
			settypeofop(accarr[i]);
			settranamount(accarr[i]);
			settrantime(accarr[i]);
		}
	}
} 