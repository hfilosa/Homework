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
	if (n>len-1) return null;
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
	if (n>len-1) return "Passed end of links";
	return getNode(n).getData();
    }

    public void add(int n, String s){
	if (n>len) return;
	Node newNode = new Node(s);
	if (n<len) newNode.setNext(getNode(n));
	if (n>0) getNode(n-1).setNext(newNode);
	else l.setNext(newNode);
	len+=1;	
    }

    public void remove(int n){
	if (n>len) return;
	if (n==0) l.setNext(getNode(1));
        else getNode(n-1).setNext(getNode(n+1));
	len-=1;
    }

}
