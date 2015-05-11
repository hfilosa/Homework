public class tree{
    private BST<Integer> graph;

    public tree(int data){
	graph = new BST<Integer>(data);
    }

    public void insert(int data){
	graph.insert(data);
    }


    public int maxValue(Node<Integer> T, int maxValue){
	if (T==null){
	    return maxValue;
	}
	else {
	    if (T.getData()>maxValue){
		int max1 = maxValue(T.getLeft(),T.getData());
		int max2 = maxValue(T.getRight(),T.getData());
		if (max1>max2) return max1;
		else return max2;
	    }
	}
    }

    public int maxValue(){
	return maxValue(graph.getRoot(),Integer.MIN_VALUE);
    }

    public int numNodes(Node<Integer> T){
	if (T==null) return 0;
	else return 1 + numNodes(T.getLeft()) + numNodes(T.getRight());
    }

    public int numNodes(){
	return numNodes(graph.getRoot());
    }
}
    
