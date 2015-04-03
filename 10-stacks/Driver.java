public class Driver{
    public static void main(String[] args){
	myStack<Integer> stack = new myStack<Integer>(10);
	System.out.println("Testing myStack with nodes");
	stack.push(5);
	System.out.println(stack.top());
	System.out.println(stack.pop());
	System.out.println(stack.empty());
	System.out.println(stack.pop());
	System.out.println(stack.empty());
	System.out.println("Testing arrayStack");
	arrayStack<Integer> stack2 = new arrayStack<Integer>(10);
	//stack2.push(5);
	System.out.println(stack2.top());
	System.out.println(stack2.pop());
	System.out.println(stack2.empty());
	System.out.println(stack2.pop());
	System.out.println(stack2.empty());
    }
}
