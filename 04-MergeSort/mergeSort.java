import java.util.*;

public class mergeSort{

    public ArrayList<Integer> merge(ArrayList<Integer> A, ArrayList<Integer> B){
	ArrayList<Integer> ans = new ArrayList<Integer>();
	while (A.size()>0 || B.size()>0){
	    int a = A.remove(0);
	    int b = A.remove(0);
	    if (a<b){
		ans.add(ans.size()-1,a);
	    }
	    else{
		ans.add(ans.size()-1,b);
	    }
	}
	return ans;
    }

    public static void main(String[] args){
	mergeSort t = new mergeSort();
	ArrayList<Integer> a = new ArrayList<Integer>();
	ArrayList<Integer> b = new ArrayList<Integer>();
	for (int i=0;i<11;i+=2){
	    a.add(i);
	}
	for (int i=1;i<12;i+=2){
	    b.add(i);
	} 
	System.out.println(t.merge(a,b));
    }
}
