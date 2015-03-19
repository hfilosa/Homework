import java.io.*;
import java.util.*;

public class Driver{
    static Random rand = new Random();

    public static String timeArrayList(int n){
	ArrayList<Integer> L = new ArrayList<Integer>();
	Long startTime,endTime;
	for (int i=0;i<n;i++){
	    L.add(rand.nextInt(100));
	}
	startTime=System.currentTimeMillis();
	int sum = 0;
	for (int i=0;i<L.size(); i++){
	    sum = sum + L.get(i);
	}
	endTime=System.currentTimeMillis();
	String ans="The time to calculate the sum of an arraylist of size="+n+" ";
	ans+="was "+(endTime-startTime)+" microseconds";
	return ans;
    }
    
    public static String timeMyLinkedList(int n){
        LList L = new LList();
	Long startTime,endTime;
	for (int i=0;i<n;i++){
	    L.add(rand.nextInt(100));
	}
	startTime=System.currentTimeMillis();
	int sum = 0;
	for (int i=0;i<L.size(); i++){
	    sum = sum + L.get(i);
	}
	endTime=System.currentTimeMillis();
	String ans="The time to calculate the sum of my linked list of size="+n+" ";
	ans+="was "+(endTime-startTime)+" microseconds";
	return ans;
    }

    public static String timeJavaLinkedList(int n){
	LinkedList<Integer> L = new LinkedList<Integer>();
	Long startTime,endTime;
	for (int i=0;i<n;i++){
	    L.add(rand.nextInt(100));
	}
	startTime=System.currentTimeMillis();
	int sum = 0;
	for (int i=0;i<L.size(); i++){
	    sum = sum + L.get(i);
	}
	endTime=System.currentTimeMillis();
	String ans="The time to calculate the sum of a java Linked List of size="+n+" ";
	ans+="was "+(endTime-startTime)+" microseconds";
	return ans;
    }
    
    public static void main(String[] args) {
	int n=100000;
	System.out.println(timeArrayList(n));
	System.out.println(timeMyLinkedList(n));
	System.out.println(timeJavaLinkedList(n));
		    
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
