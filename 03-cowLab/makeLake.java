import java.util.*;
import java.io.*;

public class makeLake{
    private int row,col;
    private int[][] field;
    
    public makeLake(){
	row=4;
	col=6;
	field = new int[row][col];			
	try {		
	    Scanner sc = new Scanner(new File("field.dat"));
	    for (int i=0;i<row;i++){
		for (int j=0;j<col;j++){
		    int line = sc.nextInt();
		    field[i][j] = line;
		}
	    }
	}
	catch (Exception e)
	    {
	    }			
    }

    public String toString(){
	String s = "";  //"[2J\n";			
	for (int x=0;x<row;x++){
	    for (int y=0;y<col;y++){
		s = s +field[x][y]+" ";
	    }
	    s=s+"\n";
	}
	return s;
    }

    public void level(int rowStart, int colStart, int depth){
	int max=field[rowStart][colStart];
	rowStart-=1;
	colStart-=1;
	for (int r=rowStart;r<rowStart+3;r++){
	    for (int c=colStart;c<colStart+3;c++){
		if (field[r][c]>max){
		    max=field[r][c];
		}
	    }
	}
	int newDepth = max-depth;
	for (int r=rowStart;r<rowStart+3;r++){
	    for (int c=colStart;c<colStart+3;c++){
		if (field[r][c]>newDepth){
		    field[r][c]=newDepth;
		}
	    }
	}
    }

    public int calcVolume(int depth){
	int diff = 0;
	for (int r=0;r<row;r++){
	    for (int c=0;c<col;c++){
		if (field[r][c]<depth){
		    diff+=(depth-field[r][c]);
		}
	    }
	}
	return diff*72*72;
    }

    public static void main(String[] args){
	makeLake k = new makeLake();
	System.out.println(k);
	k.level(1,4,4);
	System.out.println(k);
	k.level(1,1,10);
	System.out.println(k);
	System.out.println(k.calcVolume(22));
    }
}


