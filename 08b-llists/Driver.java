import java.io.*;
import java.util.*;

public class Driver{
    Random rand = new Random();

    public static String timeArrayList(int n){
	ArrayList<Integer> array = new ArrayList<Integer>();
	Long startTime,endTime;
	for (int i=0;i<n;i++){
	    array.add(rand.nextInt(100));
	}
	startTime=System.nanoTime();
	int sum = 0;
	for (int i=0;i<L.size(); i++){
	    sum = sum + L.get(i);
	}
	endTime=System.nanoTime();
	String ans="The time to calculate the sum of an arraylist of size="+n+" ";
	ans+="was "+(endTime-startTime);
	return ans;
    }
    public static void main(String[] args) {
		
	System.out.println(timeArrayList(100000));
		    
	//A test for the remove method
	/*
	  LList l = new LList();
	  for (int i=0;i<5;i++){
	  l.add(i);
	  }
	  System.out.println(l);
	  l.remove(3);
	  System.out.println(l);
	  l.remove(2);
	  System.out.println(l);
	*/
    }
}
