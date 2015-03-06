public class selection{
    /*returns an integer array with the value at si(startIndex) placed in its proper 
      location relative to ei(endIndex). For example, calling pivot (l,0,l.length) will return 
      an array with the value at l[0] in its proper position if the entire list were sorted.
    */

    public int[] pivot(int[] l, int si, int ei){
	int[] d = new int[l.length];
	for (int i=0;i<l.length;i++){
	    d[i]=l[i];
	}
	int pivot = l[si];
	for (int i=0;i<l.length+1;i++){
	    if (si==ei){
		d[si]=pivot;
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
	return d;
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


