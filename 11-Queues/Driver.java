public class Driver{
    public static void main(String[] args){
	myQueue<Integer> queue = new myQueue<Integer>(0);
	System.out.println(queue);
	for (int i=1;i<10;i++){
	    queue.enqueue(i);
	}
	System.out.println(queue);
	System.out.println(queue.top());
	System.out.println(queue.dequeue());
	System.out.println(queue);
    }
}
