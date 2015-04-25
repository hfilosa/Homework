import java.util.*;

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
    //returns depth of tree where 0 is a tree with only a root, 1 is a tree with one branch, etc.
    public int rDepth(node<E> T){ 
	if (T.getLeft()==null && T.getRight()==null) return 0;
	if (T.getLeft()!=null) return 1+rDepth(T.getLeft());
	if (T.getRight()!=null) return 1+rDepth(T.getRight());
	return 0;
    }

    //wrapper for recursive depth finder
    public int depth(){
	return rDepth(root);
    }

    public String print(){
	String ans="";
	LinkedList<node<E>> queue = new LinkedList<node<E>>();
	queue.add(root);
	int depth = depth();
	int n=0;
	String spaces="";
	int temp;
	node<E> test;
	while (n<depth+1){
	    spaces="";
	    temp=queue.size();
	    for (int i=0;i<temp;i++){	
		if (queue.get(i).getRight()==null) queue.add(new node<E>(null));
		else queue.add(queue.get(i).getRight());
		if (queue.get(i).getLeft()==null) queue.add(new node<E>(null));
		else queue.add(queue.get(i).getLeft());
	    }
	    for (int c=depth-n;c>0;c--){
		spaces+=" ";
	    }
	    ans+=spaces;
	    for (int c=(int)Math.pow(2,n);c>0;c--){
		test = queue.pop();
		if (test.getData()==null) ans+="  ";
        	else ans+=test.getData()+" ";
	    }
	    ans+="\n";
	    n++;
	}
	return ans;
    }


     public static void main(String[] args){
	BST<Integer> t = new BST<Integer>(10);
	t.insert(20);
	t.insert(5);
	t.insert(40);
	t.insert(21);
	t.insert(22);
	t.insert(4);
	t.insert(6);
	t.insert(19);
	System.out.println(t.search(5));
	System.out.println(t.search(4));
	System.out.println(t.depth());
	System.out.println(t.print());
    }
}
