public class myStack<E>{
    //Holds a pointer to the top of the stack
    Node<E> first;

    //Creates the stack with the first element of type E
    public myStack(E data){
	Node<E> tmp = new Node<E>(data);
	first = tmp;
    }
   
    //Adds a new item to the top of the stack
    public void push(E data){
 	Node<E> tmp = new Node<E>(data);
	tmp.setNext(first);
	first=tmp;
    }

    //removes first item from stack and returns that item's data
    public E pop(){
	if (empty()) throw new IllegalArgumentException("Stack is empty");
        E ans = first.getData();
	first = first.getNext();
	return ans;
    }

    //returns true if stack is empty
    public boolean empty(){
	return first==null;
    }

    //returns data of top item on stack
    public E top() {
        if (empty()) throw new IllegalArgumentException("Stack is empty");
        return first.getData();
    }
}
