package day_4_work;
import java.util.*;
public class MapExample {

	public static void main(String[] args) {
	Map<String,String> myUser=new TreeMap<>();
	Scanner mySc=new Scanner(System.in);
	for(int i=0;i<5;i++)
	{
		System.out.println("Ënter User name and password");
		myUser.put(mySc.next(), mySc.next());
	}
	System.out.println("****MY LIST*****");
	Set<String> keys=myUser.keySet();
	for(String key:keys)
	{
		System.out.println(key+" "+myUser.get(key));
	}
	System.out.println("Enter User name and password to check");
	String user=mySc.next();
	String pass=mySc.next();
	Set<String> k= myUser.keySet();
	for(String key:k)
	{
		if(key.equals(user))
		{
			if(myUser(key).equals(pass))
				System.out.println("Welcome!!!");
			else
				System.out.println("Invalid password!!");
		}
		else
			System.out.println("Invalid user!!");
		
	}

}

}
