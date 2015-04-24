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

    //A wrapper for the recursive search method
    public node<E> rSearch(E data){
	return search(root,data);
    }

    //Recursive version of search
    public node<E> search(node<E> T,E data){
	if (T==null) return null;
	int c=T.getData().compareTo(data);
	if (c==0) return T;
	if (c>0) search(T.getRight(),data);
	else search(T.getLeft(),data);
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
	    if (c==0) return null;
	    else if (c>0) T=T.getRight();
	    else T=T.getLeft();
	}
	return T2;
    }

    //Wrapper for recursive version of parentSearch
    public node<E> rParentSearch(E data){
	return parentSearch(root,data);
    }

    //Recurive version of parentSearch
    public node<E> parentSearch(node<E> T,E data){
	int c=T.getData().compareTo(data);
	if (c==0) return null;
	if (c>0 && T.getRight()==null || c<0 && T.getLeft()==null) return T;
	if (c>0) parentSearch(T.getRight(),data);
	else parentSearch(T.getLeft(),data);
	return null;
    }

    //Recursive version of insertion method using recursive parent search
   public void rInsert(E data){
	node<E> parent = rParentSearch(data);
	node<E> leaf = new node(data);
	int c=parent.getData().compareTo(data);
	if (c>0) parent.setRight(leaf);
	else if (c<0) parent.setLeft(leaf);
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
	t.rInsert(20);
	t.rInsert(5);
	System.out.println(t.rSearch(5));
	System.out.println(t.rSearch(4));
    }
}
