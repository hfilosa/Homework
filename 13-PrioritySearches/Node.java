public class Node {
    //the node with the lowest priority is placed at the front of the queue
    //priority is based off the number of steps away from the exit plus the stimated distance to the exit
    //cost is the number of steps away from the start of the maze this node is
    private int x,y,priority,cost;
    private Node prev;
		
    public Node(int x, int y, int priority, int cost){
	this.x = x;
	this.y = y;
	this.priority = priority;
	this.cost = cost;
    }

    public Node getPrev() {
	return prev;
    }

    public void setPrev(Node n){
	prev = n;
    }
		
    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public int getPriority(){
	return priority+cost;
    }

    public int getCost(){
	return cost;
    }
		
}










