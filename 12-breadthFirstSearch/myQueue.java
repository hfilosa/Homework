public class myQueue{
    //Holds a pointer to the head & tail of the queue
    private Node head,tail;

    //Creates the stack with the first element of type E
    public myQueue(int x, int y){
	Node tmp = new Node(x,y);
	head = tmp;
	tail = tmp;
    }
   
    //Adds a new item to the tail of the queue
    public void enqueue(int x, int y){
 	Node tmp = new Node(x,y);
	tail.setNext(tmp);
	tail=tmp;
    }

    //removes head item from queue and returns that item's data
    public int[] dequeue(){
	if (empty()) throw new IllegalArgumentException("Queue is empty");
        int[] ans = head.getXY();
	head = head.getNext();
	return ans;
    }

    //returns true if stack is empty
    public boolean empty(){
	return head==null;
    }

    //returns data of top item on stack
    public int[] top() {
        if (empty()) throw new IllegalArgumentException("Queue is empty");
        return head.getXY();
    }

    public String toString(){
	String ans = "";
	for (Node tmp=head;tmp!=null;tmp=tmp.getNext()){
	    if (tmp.getNext()==null) ans=tmp+ans;
	    else ans="--->"+tmp+ans;
	}
	return ans;
    }
}
