public class myStack{
    //Holds a pointer to the top of the stack
    Node first;

    //Creates the stack with the first coordinate
    public myStack(int x, int y){
	Node tmp = new Node(x,y);
	first = tmp;
    }
   
    //Adds a new item to the top of the stack
    public void push(int x, int y){
 	Node tmp = new Node(x,y);
	tmp.setNext(first);
	first=tmp;
    }

    //removes first item from stack and returns that item's coordinates
    public int[] pop(){
	if (empty()) throw new IllegalArgumentException("Stack is empty");
        int[] ans = first.getXY();
	first = first.getNext();
	return ans;
    }

    //returns true if stack is empty
    public boolean empty(){
	return first==null;
    }

    //returns data of top item on stack
    public int[] top() {
        if (empty()) throw new IllegalArgumentException("Stack is empty");
        return first.getXY();
    }
}
