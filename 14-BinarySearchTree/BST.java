//Binary search tree
public class BST<E extends Comparable<E>>{
    private node<E> root;

    public BST(E data){
	root = new node(data);
    }

    //Returns the node with data E
    public node<E> search(E data){
	node<E> T=root;
	int c;
	while (T != null){
	    c=T.getData().compareTo(data);
	    if (c==0) return T;
	    else if (c>0) T=T.getRight();
	    else T=T.getLeft();
	}
	return null;
    }

    //Returns the node that would be the parent of the node with data E
    public node<E> parentSearch(E data){
	node<E> T=root;
	node<E> T2=null;
	int c;
	while (T != null){
	    T2=T;
	    c=T.getData().compareTo(data);
	    if (c==0) return T;
	    else if (c>0) T=T.getRight();
	    else T=T.getLeft();
	}
	return T2;
    }

    public void insert(E data){
	node<E> parent = parentSearch(data);
	node<E> leaf = new node(data);
	int c=parent.getData().compareTo(data);
	if (c>0) parent.setRight(leaf);
	else if (c<0) parent.setLeft(leaf);
    }
    
     public static void main(String[] args){
	BST<Integer> t = new BST<Integer>(10);
	t.insert(20);
	t.insert(5);
	System.out.println(t.search(5));
	System.out.println(t.search(4));
    }
}
