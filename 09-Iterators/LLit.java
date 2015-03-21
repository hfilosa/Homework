import java.io.*;
import java.util.*;

public class LLit<E> implements Iterator<E>{
    //a is the node that will next be returned
    //b is the node just returned by next 
    //c is the node behind b
    private Node<E> a,b,c;
    public LLit(Node<E> n){
	a=n;
    }

    public boolean hasNext(){
	return a!=null;
    }

    public E next(){
	E retval = a.getData();
	c=b;
	b=a;
	a=a.getNext();
	return retval;
    }

    public void remove(){
	c.setNext(a);
	b = a;
	a=a.getNext();
    }
}
