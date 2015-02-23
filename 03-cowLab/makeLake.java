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
	    int j=0;
	    while (sc.hasNext())
		{
		    String line = sc.nextLine();
		    for (int i=0;i<row;i++)
			{
			    field[i][j] = line.charAt(i);
			}
		    j++;
		}
	}
	catch (Exception e)
	    {
	    }			
    }

    public String toString()
    {
	String s = "[2J\n";			
	for (int y=0;y<col;y++)
	    {
		for (int x=0;x<row;x++)
		    s = s +field[x][y];
		s=s+"\n";
	    }
	return s;
    }

    public static void main(String[] args){
	makeLake k = new makeLake();
	System.out.println(k);
    }
}


