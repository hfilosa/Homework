public class node<E extends Comparable<E>>{
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
    public void setLeft(node<E> n){
	left = n;
    }
    public void setRight(node<E> n){
	right = n;
    }
    public node<E> getLeft(){
	return left;
    }
    public node<E> getRight(){
	return right;
    }
    public int compareTo(node<E> other){
	return data.compareTo(other.getData());
    }
    public String toString(){
	return ""+data;
    }
}
