public class Node<E>{
    private E data;
    private Node<E> next;

    public Node(E n){
	data = n;
	next = null;
    }
    public void setData(E n){
	data = n;
    }
    public E getData(){
	return data;
    }
    public void setNext(Node<E> n){
	next = n;
    }
    public Node<E> getNext(){
	return next;
    }
    public String toString(){
	return ""+data;
    }
}
