public class LList{
    private Node l=new Node(-1);
    private int len=0;

    public void add(int n){
	Node tmp = new Node(n);
	tmp.setNext(l.getNext());
	l.setNext(tmp);
	len+=1;
    }

    public int size(){
	return len;
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
    private Node getNode(int n){
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
    public int get(int n){
	if (n<0 || n>len-1) throw new IllegalArgumentException("Out of bounds of this linked list");
	return getNode(n).getData();
    }

    public void add(int n,int s){
	if (n>len) return;
	Node newNode = new Node(s);
	if (n<len) newNode.setNext(getNode(n));
	if (n>0) getNode(n-1).setNext(newNode);
	else l.setNext(newNode);
	len+=1;	
    }

    //Removes a node from the list
    private void removeNode(int n){
	if (n<0 || n>len) throw new IllegalArgumentException("Out of bounds of this linked list");
	if (n==0) l.setNext(getNode(1));
        else getNode(n-1).setNext(getNode(n+1));
	len-=1;
    }

    //removes first node in list with value n
    public boolean remove(int n){
	if (n<0 || n>len) throw new IllegalArgumentException("Out of bounds of this linked list");
	Node tmp2=l;
	for (Node tmp=l;tmp!=null;tmp=tmp.getNext()){
	    if (tmp.getData()==n){
		tmp2.setNext(tmp.getNext());
		return true;
	    }
	    tmp2=tmp;
	}
	return false;
    }
		
}
