public class node<E>{
    private E data;
    private node<E> right,left;

    public node(){
	data = null;
	right = null;
	left = null;
    }
    public node(E s){
	data = s;
	right = null;
	left =null;
    }
    public void setData(E s){
	data = s;
    }
    public E getData(){
	return data;
    }
    public void setLeft(Node<E> n){
	left = n;
    }
    public void setRight(Node<E> n){
	right = n;
    }
    public Node<E> getLeft(){
	return left;
    }
    public Node<E> getRight(){
	return right;
    }
    public String toString(){
	return ""+data;
    }
}
