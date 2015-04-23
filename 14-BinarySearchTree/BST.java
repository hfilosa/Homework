//Binary search tree
public class BST<E>{
    private node<E> root;

    public BST(E data){
	root = new node(data);
    }

    public Node<E> search(E data){
	Node<E> T=root;
	Node<E> T2;
	int c;
	while (T != null){
	    c=T.getData().compareTo(data);
	    if (c==0) return T;
	    else if (C>0) T=T.getRight();
	    else T=T.getLeft();
	    T2=T;
	}
	return T2;
    }

    public void insert(E data){
	Node<E> parent = search(data);
	Node<E> leaf = new node(data);
	int c=parent.getData.compareTo(data);
	if (c>0) parent.setRight(leaf);
	else if (c<0) parent.setLeft(leaf);
    }
}
