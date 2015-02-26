public class knightsTour{
    private String[][] board;
    private int maxX;
    private int maxY;

    private String space = "#";
    private String divider = " ";
    private int move = 0;
    private boolean solved = false;

    //If no inputs are given a 5x5 board  is generated
    public knightsTour(){
	this(5);
    }

    //n specifies the length of the sides
    public knightsTour(int n){
	maxX=n;
	maxY=n;
	board = new String[maxX][maxY];
	for (int x=0;x<maxX;x++){
	    for (int y =0;y<maxY;y++){
		board[x][y] = space;
	    }
	    divider+="----";
	}
    }

    public String toString(){
	String s = "";
	for (int x=0;x<maxX;x++){
	    s+=divider+"\n";
	    for (int y =0;y<maxY;y++){
		if (board[x][y].equals("N") || board[x][y].equals("#")){
		    s+="| "+board[x][y]+" ";
		}
		else {
		    if (Integer.parseInt(board[x][y])>9 && Integer.parseInt(board[x][y])<99){
			s+="| "+board[x][y];
		    }
		    else{
			s+="| "+board[x][y]+" ";
		    }
		}
	    }
	    s+="|\n";
	}
	s+=divider;
	return s;
    }

    public void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }

    public boolean finished(){
	for (int x=0;x<maxX;x++){
	    for (int y =0;y<maxY;y++){
		if (board[x][y].equals("#")){
		    return false;
		}
	    }
	}
	return true;
    }

    public void solve(int x,int y){
	if (finished()){
	    solved = true;
	}
	if (x>=maxX || x<0 ||y>=maxY || y<0 || solved){
	    return;
	}
	if (!board[x][y].equals("#")){
	    return;
	}
	System.out.println(this);
	delay(1);
	board[x][y]=Integer.toString(move);
	move+=1;
	solve(x+2,y+1);
	solve(x+2,y-1);
	solve(x-2,y+1);
	solve(x-2,y-1);
	solve(x+1,y+2);
	solve(x+1,y-2);
	solve(x-1,y+2);
	solve(x-1,y-2);
	if (!solved){
	    board[x][y] = space;
	    move-=1;
	}
    }


    public static void main(String[] args) {
	knightsTour t;
        if (args.length == 0){
	    t = new knightsTour();
	}
	else {
	    t = new knightsTour(Integer.parseInt(args[0]));
	}
	System.out.println(t);
	t.solve(0,0);
	System.out.println(t);
    }
}
