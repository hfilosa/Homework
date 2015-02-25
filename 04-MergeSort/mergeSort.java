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
}
