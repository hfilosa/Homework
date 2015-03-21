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
	while (i.hasNext())
	    System.out.println(i.next());
				
        Iterator<Integer> i2 = l2.iterator();
	int num;
	while (i2.hasNext()){
	    num=i2.next();
	    if ((num/2)==0){i2.remove();}
	    else {System.out.println(num);}
	}
	System.out.println(l2);
    }
}
