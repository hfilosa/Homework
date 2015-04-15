import java.util.*;

public class Frontier {
    public LinkedList<Node> l = new LinkedList<Node>();

    public void add(Node n){
	if (isEmpty()){
	    l.add(n);
	    return;
	}
	for (int i=0;i<l.size();i++){
	    if (l.get(i).getPriority()>=n.getPriority()){
		l.add(i,n);
		return;
	    }
	}
	l.add(l.size()-1,n);
    }

    public Node remove() {
	return l.remove(0);
    }

    public boolean isEmpty(){
	return l.isEmpty();
    }
}










