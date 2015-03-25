public class arrayStack<E>{
    private Object[] array;

    //Creates the stack with the first element of type E
    public arrayStack(Object data){
	Object[] array = new Object[1];
	array[0] = data;
    }
   
    //Adds a new item to the top of the stack
    public void push(Object data){
	Object[] tmp =new Object[array.length+1];
	for (int i=1;i<tmp.length;i++){
	    tmp[i]=array[i-1];
	}
	tmp[0]=data;
	array=tmp;
    }

    //removes first item from stack and returns that item's data
    public Object pop(){
	if (empty()) throw new IllegalArgumentException("Stack is empty");
	Object ans = array[0];
      	Object[] tmp = new Object[array.length-1];
	for (int i=0;i<array.length;i++){
	    tmp[i]=array[i+1];
	}
	array=tmp;
	return ans;
    }

    //returns true if stack is empty
    public boolean empty(){
	return array.length==0;
    }

    //returns data of top item on stack
    public Object top() {
        if (empty()) throw new IllegalArgumentException("Stack is empty");
        return array[0];
    }
}
