import java.io.*;
import java.util.*;

public class Maze 
{
    private char[][] board;
    private int maxX;
    private int maxY;
    private int exitX,exitY;

    private char path='#';
    private char wall=' ';
    private char me='z';
    private char exit='$';
    private char visited = '.';
    private boolean solved = false;

    private Frontier f;
		
    public static void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }
		
    public Maze(){
	maxX=40;
	maxY=20;
	board = new char[maxX][maxY];
				
	try {
						
	    Scanner sc = new Scanner(new File("maze2.dat"));
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
	catch (Exception e)
	    {
	    }
	for(int r=0;r<board.length;r++){
	    for (int c=0;c<board[0].length;c++){
		if (board[r][c]==exit){
		    exitX=r;
		    exitY=c;
		}
	    }
	}
				
    }
		
    public String toString()
    {
	String s = "[2J\n";
				
	for (int y=0;y<maxY;y++)
	    {
		for (int x=0;x<maxX;x++)
		    s = s +board[x][y];
		s=s+"\n";
	    }
	return s;
    }

    /*
      Only adds if the tx,ty spot is available path or exit
    */
    public void addToFront(int tx,int ty, Node current, int cost){
	Node tmp = null;
	if (board[tx][ty]=='#' || board[tx][ty]=='$'){
	    tmp = new Node(tx,ty,manhattanDistance(tx,ty),cost);
	    tmp.setPrev(current);
	    f.add(tmp);
	}
						
    }

    public int manhattanDistance(int x, int y){
	return Math.abs(x-exitX) + Math.abs(y-exitY);
    }

    //Best Fisrt Search. Does not take into account travel cost
    public void bfs(int x, int y){
	f = new Frontier();
	f.add(new Node(x,y,manhattanDistance(x,y),0));
	int tx=0,ty=0;
	Node current = null;
	while (!f.isEmpty()){
	    current = f.remove();
	    int cx = current.getX();
	    int cy = current.getY();

	    if (board[cx][cy]=='$')
		break;
						
	    board[cx][cy]='z';
		
	    addToFront(cx+1,cy,current,0);
	    addToFront(cx-1,cy,current,0);
	    addToFront(cx,cy+1,current,0);
	    addToFront(cx,cy-1,current,0);

	    delay(100);
	    System.out.println(this);
	}

	    // path recovery
	for (Node p = current.getPrev(); p != null ; p = p.getPrev()){
	    board[p.getX()][p.getY()] = 'P';
	    delay(100);
	    System.out.println(this);
	}
    }
 
    public void AStar(int x, int y){
	f = new Frontier();
	f.add(new Node(x,y,manhattanDistance(x,y),0));
	int tx=0,ty=0;
	Node current = null;
	while (!f.isEmpty()){
	    current = f.remove();
	    int cx = current.getX();
	    int cy = current.getY();
	    int cost = current.getCost();

	    if (board[cx][cy]=='$')
		break;
						
	    board[cx][cy]='z';
		
	    addToFront(cx+1,cy,current,cost+1);
	    addToFront(cx-1,cy,current,cost+1);
	    addToFront(cx,cy+1,current,cost+1);
	    addToFront(cx,cy-1,current,cost+1);

	    delay(70);
	    System.out.println(this);
	}

	    // path recovery
	for (Node p = current.getPrev(); p != null ; p = p.getPrev()){
	    board[p.getX()][p.getY()] = 'P';
	    delay(80);
	    System.out.println(this);
	}
    }

		
    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
	System.out.println("Begining Best First Search");
	delay(1000);
	m.bfs(1,1);
	System.out.println(m);
	Maze n = new Maze();
	System.out.println(n);
	System.out.println("Begining A* Search");
	delay(1000);
	n.AStar(1,1);
	System.out.println(n);
    }
}

