import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args) {
	LList<String> l = new LList<String>();

	l.add("Hello");
	l.add("world");
	l.add("abc");
	l.add("something");
	l.add("else");

	System.out.println(l);

	LList<Integer> l2 = new LList<Integer>();
	for (int i=0;i < 5; i++){
	    l2.add(i);
	}

	System.out.println(l2);

	Iterator<String> i = l.iterator();	        
        Iterator<Integer> i2 = l2.iterator();

	System.out.println(i.next());
	System.out.println(i2.next());
	
	//i.remove();
	i2.remove();

	System.out.println(i.next());
	System.out.println(i2.next());

	System.out.println(l);
	System.out.println(l2);
        
    }
}
