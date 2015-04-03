import java.io.*;
import java.util.*;

public class DFS
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
		
    public DFS(){
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

    public void addQueue(myStack frontier, nodeStack  solveStack, int x,int y, Node pointer){
	if (x>=0 && x<maxX && y>=0 && y<maxY){
	    if (board[x][y]==path || board[x][y]==exit){
		frontier.push(x,y);
		Node tmp = new Node(x,y);
		tmp.setNext(pointer);
		solveStack.push(tmp);
	    }
	}
    }
 
    public void fillPath(Node n){
	int[] current;
	for (Node tmp=n.getNext();tmp!=null;tmp=tmp.getNext()){
	    current = tmp.getXY();
	    board[current[0]][current[1]]=me;
	}
    }

    //To implement a deapth first search I simply changed the queues to stacks for both the frontier and the links of paths.
    public void solve(int x, int y){
	boolean solved=false;
        myStack frontier = new myStack(x,y);
	nodeStack solveStack = new nodeStack(new Node(x,y));
	Node currentNode;
	int[] current;
	int x2, y2;
	while (!frontier.empty() && !solved){
	    current = frontier.pop();
	    currentNode = (Node) solveStack.pop();
	    x2=current[0];
	    y2=current[1];
	    if (board[x2][y2] == exit){ 
		solved=true;
		fillPath(currentNode);
	    }
	    if (!solved){
		addQueue(frontier,solveStack,x2+1,y2,currentNode);
		addQueue(frontier,solveStack,x2,y2+1,currentNode);
		addQueue(frontier,solveStack,x2-1,y2,currentNode);
		addQueue(frontier,solveStack,x2,y2-1,currentNode);
		board[x2][y2]=visited;
	    }
	    delay(20);
	    System.out.println(this);
	}
    }
		
    public static void main(String[] args){
	DFS m = new DFS();
	System.out.println(m);
	m.solve(1,1);
	System.out.println(m);
    }
}
