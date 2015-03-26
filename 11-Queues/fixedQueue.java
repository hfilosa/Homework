public class fixedQueue{
    private Object[] array;
    private int head,tail;
   
    public fixedQueue(Object data, int length){
        array = new Object[length];
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

    //Adds a new item to the tail of the queue
    public void enqueue(Object data){
	if (tail==array.length-1){
	    if (head==0) throw new IllegalArgumentException("Queue is full, remove from front before adding another item"); 
	    adjustment();
	}
	array[tail+1]=data;
	tail+=1;
    }

    //removes head item from queue and returns that item's data
    public Object dequeue(){
        Object ans=array[head];
	head+=1;
	return ans;
    }

    //returns true if queue is empty
    public boolean empty(){
	return head>tail;
    }

    //returns data of head item on queue
    public Object top(){
        return array[head];
    }

    public String toString(){
	String ans = "";
	for (int i=head;i<=tail;i++){
	    if (i==tail) ans=array[i]+ans;
	    else ans="--->"+array[i]+ans;
	}
	return ans;
    }
}
