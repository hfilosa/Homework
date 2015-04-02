import java.io.*;
import java.util.*;

public class Maze 
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
		
    public Maze(){
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

    public myQueue addQueue(myQueue frontier,int x,int y){
	if (x>=0 && x<maxX && y>=0 && y<maxY){
	    if (board[x][y]==path){
		frontier.enqueue(x,y);
	    }
	}
	return frontier;
    }
    public void solve(int x, int y){
        myQueue frontier = new myQueue(x,y);
	int[] current;
	int x2, y2;
	while (!frontier.empty()){
	    current = frontier.top();
	    x2=current[0];
	    y2=current[1];
	    if (board[x2][y2] == exit) break;
	    frontier=addQueue(frontier,x2+1,y2);
	    frontier=addQueue(frontier,x2,y2+1);
	    frontier=addQueue(frontier,x2-1,y2);
	    frontier=addQueue(frontier,x2,y2-1);
	    System.out.println(frontier);
	    board[x2][y2]=visited;
	    frontier.dequeue();
	    delay(5000);
	    System.out.println(this);
	}
    }
		
    public static void main(String[] args){
	Maze m = new Maze();
	//System.out.println(m);
	m.solve(1,1);
	//	System.out.println(m);
    }
}

