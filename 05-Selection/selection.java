public class selection{
 
    public int select(int[] A, int k, int low, int high){
	int pivot = A[k];
	int pivotIndex;
	int high2 = high;
	A[k]=A[high];
	A[high]=pivot;
	high-=1;
	//	System.out.println("Before entering while loop "+print(A));
	while (high>low){
	    if (A[low]<pivot){
		low+=1;
		//	System.out.println(print(A));
		//	System.out.println("Low+=1 " +low);
	    }
	    else if (A[low]>pivot){
		int temp = A[high];
		A[high]=A[low];
		A[low]=temp;
		high-=1;
		//System.out.println(print(A));
		//	System.out.println("High-=1 " +high);
	    }
	}
	if (pivot>A[low]){
	    pivotIndex=low+1;
	}
	else {pivotIndex=low;}
	//	System.out.println("PivotIndex= "+pivotIndex);
	int i=high2;
	while (i>pivotIndex){
	    A[i]=A[i-1];
	    i--;
	}
	A[pivotIndex]=pivot;
	//	System.out.println("After shifting array "+print(A));
	if (pivotIndex>k){
	    return select(A,k,0,pivotIndex);
	}
	else if (pivotIndex<k){
	    //	    System.out.println("wtf");
	    return select(A,k,pivotIndex+1,A.length-1);
	}
	else if (pivotIndex==k){
	    return A[k];
	}
	return -1;
    }


    public String print(int[] s){
	String ans = "";
	for (int i=0;i<s.length;i++){
	    ans+=s[i]+" ";
	}
	return ans;
    }

    public static void main(String Args[]){
	selection s = new selection();
	int[] t = {3,8,2,7,5,12,1};
	System.out.println(s.print(t));
	int x;
       	x = s.select(t,0,0,t.length-1);
	System.out.println("First int: "+x);
       	x = s.select(t,1,0,t.length-1);
	System.out.println("Second int: "+x);
	x = s.select(t,2,0,t.length-1);
	System.out.println("Third int: "+x);
	x = s.select(t,3,0,t.length-1);
	System.out.println("Fourth int: "+x);
	x = s.select(t,4,0,t.length-1);
	System.out.println("Fifth int: "+x);
	x = s.select(t,5,0,t.length-1);
	System.out.println("Sixth int: "+x);
	x = s.select(t,6,0,t.length-1);
	System.out.println("Seventh int: "+x);
    }
}


