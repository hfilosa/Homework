public class tree{
    private BST<Integer> graph;

    public tree(int data){
	graph = new BST<Integer>(data);
    }

    public void insert(int data){
	graph.insert(data);
    }


    public int maxValue(node<Integer> T, int max){
	if (T==null){
	    return max;
	}
	else {
	    int left;
	    int right;
	    int submax;
	    left=maxValue(T.getLeft(),T.getData());
	    right=maxValue(T.getRight(),T.getData());
	    if (left>right) submax=left;
	    else submax=right;
	    if (T.getData()>submax){
		if (T.getData()>max) return T.getData();
		else return max;
	    }
	    else {
		if (max>submax) return max;
		else return submax;
	    }
	}
    }
    
    //returns the maxValue in the binary tree
    public int maxValue(){
	return maxValue(graph.getRoot(),Integer.MIN_VALUE);
    }

    public int numNodes(node<Integer> T){
	if (T==null) return 0;
	else return 1 + numNodes(T.getLeft()) + numNodes(T.getRight());
    }

    //returns the number of nodes in the binary tree 
    public int numNodes(){
	return numNodes(graph.getRoot());
    }

    public int height(node<Integer> T){
	if (T==null) return 0;
	else {
	    int left=height(T.getLeft());
	    int right=height(T.getRight());
	    int maxLength;
	    if (left>right) maxLength=left;
	    else maxLength=right;
	    return maxLength+1;
	}
    }

    //returns length of longest root to leaf path
    public int height(){
	return height(graph.getRoot());
    }

    public int longest(node<Integer> T){
	if (T==null) return 0;
	else{
	    //The throughPath length is the length of the longest path through this node
	    int throughPath=1+height(T.getLeft())+height(T.getRight());
	    int left=longest(T.getLeft());
	    int right=longest(T.getRight());
	    if (throughPath>left && throughPath>right) return throughPath;
	    else {
		if (left>right) return left;
		else return right;
	    }
	}
    }

    //returns length of longest leaf to leaf path
    public int longest(){
	return longest(graph.getRoot());
    }
    
    public String toString(){
	return graph.toString();
    }

    public static void main(String[] args){
	tree t = new tree(10);
	t.insert(2);
	t.insert(1);
	t.insert(-1);
	t.insert(3);
	t.insert(4);
	System.out.println(t);
	System.out.println(t.maxValue());
	System.out.println(t.numNodes());
	System.out.println(t.height());
	System.out.println(t.longest());
    }
}
    
