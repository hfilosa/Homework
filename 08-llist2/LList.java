public class LList{
    private Node l=new Node("Dummy");
    private int len=0;

    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(l.getNext());
	l.setNext(tmp);
	len+=1;
    }
		
    public String toString(){
	String s = "";
	Node tmp;
	for (tmp=l.getNext() ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	    //system.out.println(s);
	}
	s = s + "null";
	return s;
    }

   //Traces links until i is equal to nth item needed and returns that node.
    public Node getNode(int n){
	if (n==0) return l.getNext();
	if (n>len) return null;
        int i=0;
	for (Node tmp=l.getNext();tmp!=null;tmp=tmp.getNext()){
	    if (i==n){
		return tmp;
	    }
	    i++;
	}
	return null;
    }
  
    //Returns data at node found with findNode.
    public String get(int n){
	if (getNode(n)!=null){
	    return getNode(n).getData();
	}
	else return "Passed end of links";
    }

    public void add(int n, String s){
	if (n>len) return;
	Node newNode = new Node(s);
	newNode.setNext(getNode(n));
	getNode(n-1).setNext(newNode);
	len+=1;	
    }

    public void remove(int n){
        getNode(n-1).setNext(getNode(n+1));
    }

}
