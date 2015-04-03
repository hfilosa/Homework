public class nodeStack{
    private Object[] array;
    private int head,tail;

    //Creates the stack with the first Node
    public nodeStack(Object data){
	array = new Object[100];
	array[0]=data;
	head = 0;
	tail = 0;
    }

    //Shifts items down in array
    private void adjustment(){
	int j=0;
	for (int i=head;i<=tail;i++){
	    array[j]=array[i];
	    j++;
	}
	head=0;
	tail=j-1;
    }

    //Puts the values in a new array larger by a factor of ten
    private void increaseLength(){
	Object[] tmp = new Object[array.length*10];
	int j=0;
	for (int i=head;i<=tail;i++){
	    tmp[j]=array[i];
	    j++;
	}
	array=tmp;
    }
   
    //Adds a new item to the top of the stack
    public void push(Object data){
	if (tail==array.length-1){
	    if (head==0) increaseLength();
	    else adjustment();
	}
	array[tail+1]=data;
	tail+=1;
    }

    //removes first item from stack and returns that item's data
    public Object pop(){
	Object ans = array[tail];
	tail-=1;
	return ans;
    }

    //returns true if stack is empty
    public boolean empty(){
	return head>tail;
    }

    //returns data of top item on stack
    public Object top() {
        if (empty()) throw new IllegalArgumentException("Stack is empty");
        return array[head];
    }

    public String toString(){
	String ans = "";
	for (int i=tail;i>=head;i--){
	    if (i==head) ans=array[i]+ans;
	    else ans="--->"+array[i]+ans;
	}
	return ans;
    }
}
