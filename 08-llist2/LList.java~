public class LList{
    private Node l=null;

    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(l);
	l = tmp;
    }
		
    public String toString(){
	String s = "";
	Node tmp;;
	for (tmp=l ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }

   //Traces links until i is equal to nth item needed and returns that node.
    public Node findNode(int n){
        int i=0;
	for (Node tmp=l;tmp!=null;tmp=tmp.getNext()){
	    if (i==n){
		return tmp;
	    }
	    i++;
	}
	return null;
    }
  
    //Returns data at node found with findNode.
    public String find(int n){
	if (findNode(n)!=null){
	    return findNode(n).getData();
	}
	else return "Passed end of links";
    }

    public void insert(int n, String s){
	if (n==0){
	    add(s);
	}
	else if (findNode(n)!=null){
	    Node newNode = new Node(s);
	    newNode.setNext(findNode(n+1));
	    findNode(n-1).setNext(newNode);
	}
    }
}
