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
	    else if (c>0) T=T.getLeft();
	    else T=T.getRight();
	}
	return null;
    }

    //A wrapper for the recursive search method
    public node<E> rSearch(E data){
	return search(root,data);
    }

    //Recursive version of search
    public node<E> search(node<E> T,E data){
	if (T==null || T.getData()==data) return T;
	int c=T.getData().compareTo(data);
	if (c>0) return search(T.getLeft(),data);
	else return search(T.getRight(),data);
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
	    else if (c>0) T=T.getLeft();
	    else T=T.getRight();
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
	if (c>0 && T.getLeft()==null || c<0 && T.getRight()==null) return T;
	if (c>0) parentSearch(T.getLeft(),data);
	else parentSearch(T.getRight(),data);
	return null;
    }

    //Recursive version of insertion method using recursive parent search
   public void rInsert(E data){
	node<E> parent = rParentSearch(data);
	node<E> leaf = new node(data);
	int c=parent.getData().compareTo(data);
	if (c>0) parent.setLeft(leaf);
	else if (c<0) parent.setRight(leaf);
    }

    public void insert(E data){
	node<E> parent = parentSearch(data);
	node<E> leaf = new node(data);
	int c=parent.getData().compareTo(data);
	if (c>0) parent.setLeft(leaf);
	else if (c<0) parent.setRight(leaf);
    }

    public void remove(E data){
        node<E> parent=parentSearch(T.getData());
	if (T.getLeft()==null || T.getRight()==null){
	    parent.setLeft(T.getLeft());
	    parent.setRight(T.getRight());
	}
	else {
	    //node L is the largest node on the left subtree of T
	    node<E> L = T.getLeft();
	    while (L.getRight()!=null){
		L=L.getRight();
	    }
	    E data=L.getData;
	    //remove the node L from the tree
	    remove(data);
	    //put data from L into T
	    T.setData(data);
	}
    }

    //returns depth of tree where 0 is a tree with only a root, 1 is a tree with one branch, etc.
    public int Depth(node<E> T){
	int left=0,right=0; 
	if (T.getLeft()!=null) left= 1+Depth(T.getLeft());
	if (T.getRight()!=null) right= 1+Depth(T.getRight());
	if(left>=right) return left;
	else return right;
    }

    //wrapper for recursive depth finder
    public int depth(){
	return Depth(root);
    }

    //returns a linkedlist of all the nodes in the tree
    //nodes are ordered as if the tree where cut in slices from the top, cutting left to right
    public LinkedList<node<E>> makeQueue(){
	LinkedList<node<E>> ans = new LinkedList<node<E>>();
	ans.add(root);
	int depth=depth();
	int n=0;
	while (n<depth){
	    int size=ans.size();
	    for (int i=(int)Math.pow(2,n)-1;i<size;i++){
		if (ans.get(i).getLeft()==null) ans.add(new node<E>(null));
		else ans.add(ans.get(i).getLeft());
		if (ans.get(i).getRight()==null) ans.add(new node<E>(null));
		else ans.add(ans.get(i).getRight());
	    }
	    n++;
	}
	return ans;
    }
	    
    public String print(){
	String ans="";
	LinkedList<node<E>> queue = makeQueue();
	int n=0;
	int depth=depth();
	String branches;
	String indent;
	node<E> test;
	while (!queue.isEmpty()){
	    branches=" ";
	    indent="";
	    //System.out.println(ans); 
	    //System.out.println(queue);
	    for (int i=n;i>0;i--){
		indent+=" ";
	    }
	    for (int i=(int)Math.pow(2,depth);i>0;i--){
		test=queue.removeLast();
		if (test.getData()==null){
		    ans=" "+ans;
		    branches=" "+branches;
		}
		else {
		    if (i%2==0){ 
			ans=test.getData()+" "+ans;
			branches=" \\"+branches;
		    }
		    else {
			ans=test.getData()+"  "+ans;
			branches=" /"+branches;
			if (i>1) branches=" "+branches;
		    }
		}
	    }
	    branches=indent+branches;
	    ans=indent+ans;
	    if (depth!=0) ans="\n"+branches+"\n"+ans;
	    depth--;
	    n++;
	}
	return ans;
    }


     public static void main(String[] args){
	BST<Integer> t = new BST<Integer>(10);
	System.out.println(t.print());
	System.out.println();
	t.insert(20);
	System.out.println(t.print());
	System.out.println();
	t.insert(5);
	System.out.println(t.print());
	System.out.println();
	t.insert(40);
	System.out.println(t.print());
	System.out.println();
	t.remove(20);
	System.out.println(t.print());
	System.out.println();
	/*t.insert(21);
	System.out.println(t.print());
	System.out.println();
	t.insert(22);
	System.out.println(t.print());
	System.out.println();
	t.insert(4);
	System.out.println(t.print());
	System.out.println();
	t.insert(6);
	System.out.println(t.print());
	System.out.println();
	t.insert(19);
	System.out.println(t.print());
	t.insert(7);
	System.out.println(t.print());
	t.insert(8);
	System.out.println(t.print());
	*/
    }
}
