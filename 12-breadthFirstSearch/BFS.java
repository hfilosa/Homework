import java.io.*;
import java.util.*;

//Implementation of a Breadth-First search
public class BFS 
{
    private char[][] board;
    private int maxX;
    private int maxY;

    private char path='#';
    private char wall=' ';
    private char me='z';
    private char exit='$';
    private char visited = '.';
    private char processed = '*';
    private boolean solved = false;
		
    public void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }
		
    public BFS(){
	maxX=40;
	maxY=20;
	board = new char[maxX][maxY];			
	try {
	    Scanner sc = new Scanner(new File("maze.dat"));
	    int j=0;
	    while (sc.hasNext())
		{
		    String line = sc.nextLine();
		    for (int i=0;i<maxX;i++)
			{
			    board[i][j] = line.charAt(i);
			}
		    j++;
		}
	}
	catch (Exception e){}	
    }
		
    public String toString()
    {
	String s = "[2J\n";			
	for (int y=0;y<maxY;y++){
		for (int x=0;x<maxX;x++)
		    s = s +board[x][y];
		s=s+"\n";
	    }
	return s;
    }

    public void addQueue(myQueue frontier, arrayQueue solveQueue, int x,int y, Node pointer){
	if (x>=0 && x<maxX && y>=0 && y<maxY){
	    if (board[x][y]==path || board[x][y]==exit){
		frontier.enqueue(x,y);
		Node tmp = new Node(x,y);
		tmp.setNext(pointer);
		solveQueue.enqueue(tmp);
	    }
	}
    }
    /*Fills in the path to the exit by tracing through linked nodes starting with the node at the exit*/
    public void fillPath(Node n){
	int[] current;
	for (Node tmp=n.getNext();tmp!=null;tmp=tmp.getNext()){
	    current = tmp.getXY();
	    board[current[0]][current[1]]=me;
	}
    }

    /*myQueue was used for the frontier because it was well suited for holding coordinates in a queue. The nodes for possible paths were stored using arrayQueue for the simple reason that my  brain could not handle stroing nodes in a queue using linked nodes. I still have a headache from the thought. The rest of the code follows standard breadth first behavior. */
    public void solve(int x, int y){
	boolean solved=false;
        myQueue frontier = new myQueue(x,y);
	arrayQueue solveQueue = new arrayQueue(new Node(x,y));
	Node currentNode;
	int[] current;
	int x2, y2;
	while (!frontier.empty() && !solved){
	    current = frontier.top();
	    currentNode = (Node) solveQueue.dequeue();
	    x2=current[0];
	    y2=current[1];
	    if (board[x2][y2] == exit){ 
		solved=true;
		fillPath(currentNode);
	    }
	    if (!solved){
		addQueue(frontier,solveQueue,x2+1,y2,currentNode);
		addQueue(frontier,solveQueue,x2,y2+1,currentNode);
		addQueue(frontier,solveQueue,x2-1,y2,currentNode);
		addQueue(frontier,solveQueue,x2,y2-1,currentNode);
		board[x2][y2]=visited;
		frontier.dequeue();
	    }
	    delay(20);
	    System.out.println(this);
	}
    }
		
    public static void main(String[] args){
	BFS m = new BFS();
	System.out.println(m);
	m.solve(1,1);
	System.out.println(m);
    }
}

