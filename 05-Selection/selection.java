public class selection{
 
    public int select(int[] A, int k, int low, int high){
	int pivot = l[k];
	int pivotIndex=k;
	l[k]=l[high];
	l[high]=k;
	while (high<low){
	if (si==ei){
	    pivotIndex=si;
	    System.out.println("!");
	    break;
	}
	if (l[i]<pivot){
	    d[si]=l[i];
	    System.out.println("si: "+si);
	    si++;
	}
	if (l[i]>pivot){
	    d[ei]=l[i];
	    System.out.println("ei: "+ei);
	    ei++;
	}
    }


    public String print(int[] s){
	String ans = "";
	for (int i=0;i<s.length;i++){
	    ans+=s[i]+" ";
	}
	return ans;
    }

    public static void main(String Args[]){
	int length = 10;
	selection s = new selection();
	int[] t = new int[length];
	int j=0;
	for (int i=length-1;i>=0;i--){
	    t[i]=j;
	    j++;
	}
	System.out.println(s.print(t));
	t = s.pivot(t,0,9);
	System.out.println(s.print(t));
    }
}


