package day_4_work;
import java.util.*;
public class ArrayListDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<String> myString=new ArrayList<String>();
		System.out.println("Enter 5 names:");
		for(int i=0;i<5;i++)
		{
			myString.add(sc.next());
		}
		for(String a:myString)
		{
			System.out.println(a);
		}
		myString.add(3,"adding");
		System.out.println("Äfter adding");
		for(String a:myString)
		{
			System.out.println(a);
		}
	}
	

}
