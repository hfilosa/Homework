public class Node{
    private int x,y;
    private Node next;

    public Node(){
	next = null;
    }
    public Node(int xtmp, int ytmp){
	x = xtmp;
	ytmp = y;
	next = null;
    }
    public void setX(int xtmp){
	x = xtmp;
    }
    public void setY(int ytmp){
	y = ytmp;
    }
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public int[] getXY(){
	int[] ans = new int[2];
	ans[0]=x;
	ans[1]=y;
	return ans;
    }
    public void setNext(Node n){
	next = n;
    }
    public Node getNext(){
	return next;
    }
    public String toString(){
	return x+":"+y;
    }
}
