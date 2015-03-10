import java.util.*;

public class QuickSort{
    int[] A;

    public QuickSort(int num){
	Random rand = new Random();
        A = new int[num];
	for (int i=0;i<num;i++){
	    A[i]=rand.nextInt(10);
	}
    }

    public QuickSort(){
	this(20);
    }

    public int partition(int[] A, int low, int high){
	int tmp;
	int pivotIndex=low;
	int pivot = A[pivotIndex];
	tmp = A[high];
	A[high] = A[pivotIndex];
	A[pivotIndex]=tmp;
	int wall = low;
        for (int i=low;i<high;i++){
	    if (A[i]<pivot){
		tmp=A[i];
		A[i]=A[wall];
		A[wall]=tmp;
		wall++;
	    }
	}
	int rwall=wall;
	tmp = A[rwall];
	A[wall]=A[high];
	A[high]=tmp;
	rwall++;
	for (int i=rwall+1;i<=high;i++) {
	    if (A[i]==pivot) {
		tmp = A[rwall];
		A[rwall]=A[i];
		A[i]=tmp;
		rwall++;
	    }
	}
	return (wall+rwall)/2;
    }
    
    public int select(int[] A, int k, int low, int high){
	int pivotIndex=partition(A,low,high);
	int pivotValue=A[pivotIndex];
	if (pivotIndex == k){
	    return pivotValue;
	}
	else if (pivotIndex>k){
	    return select(A,k,low,pivotIndex-1);
	}
	else if (pivotIndex<k){
	    return select(A,k,pivotIndex+1,high);
	}
	return -1;
    }

    public int select(int k){
	return select(A,k,0,A.length-1);
    }

    public void Qsort(int low,int high){
	int pivot = select(A,(low+high)/2,low,high);
	int i=low;
	int j=high;
	while (i<=j){
	    while (A[i]<pivot){
		i++;
	    }
	    while (A[j]<pivot){
		j--;
	    }
	    if (i<=j){
	        int tmp=A[i];
		A[i]=A[j];
		A[j]=tmp;
		i++;
		j--;
	    }
	}
	if (low < j)
	    Qsort(low, j);
	if (i < high)
	    Qsort(i, high);
    }

    public void Qsort(){
	Qsort(0,A.length-1);
    }
    public String print(){
	String ans = "";
	for (int i=0;i<A.length;i++){
	    ans+=A[i]+" ";
	}
	return ans;
    }

    public static void main(String Args[]){
	QuickSort s = new QuickSort();
	System.out.println(s.print());
	s.Qsort();
	System.out.println(s.print());
    }
}


