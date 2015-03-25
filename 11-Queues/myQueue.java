public class myQueue<E>{
    //Holds a pointer to the head & tail of the queue
    private Node<E> head,tail;

    //Creates the stack with the first element of type E
    public myQueue(E data){
	Node<E> tmp = new Node<E>(data);
	head = tmp;
	tail = tmp;
    }
   
    //Adds a new item to the tail of the queue
    public void enqueue(E data){
 	Node<E> tmp = new Node<E>(data);
	tail.setNext(tmp);
	tail=tmp;
    }

    //removes head item from queue and returns that item's data
    public E dequeue(){
	if (empty()) throw new IllegalArgumentException("Stack is empty");
        E ans = head.getData();
	head = head.getNext();
	return ans;
    }

    //returns true if stack is empty
    public boolean empty(){
	return head==null;
    }

    //returns data of top item on stack
    public E top() {
        if (empty()) throw new IllegalArgumentException("Stack is empty");
        return head.getData();
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
