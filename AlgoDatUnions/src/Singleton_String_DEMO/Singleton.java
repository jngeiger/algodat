package Singleton_String_DEMO;

public class Singleton {
private String payload = null;
private static Singleton instance = null;


private Singleton(String s) {
	payload = s;
}

public static Singleton getInstance(String s)
{
	if (instance == null)
	instance = new Singleton(s);
	
	return instance;
}

public String getName()
{
	return payload;
}

public static void main(String[] args)
{
	var i1 = Singleton.getInstance("Chris");
	var i2 = Singleton.getInstance("Alex"); 
	//Singleton.getName() // Fehler
	System.out.println(i1.getName());//Chris
	System.out.println(i2.getName());//Chris(nicht Alex!)
	System.out.println(i1 == i2); // true
}
}
