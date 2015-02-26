import java.util.*;

public class mergeSort{

    public int[] merge(int[] a, int[] b){
        int[] ans = new int[a.length+b.length];
	int indexA = 0;
	int indexB = 0;
	int indexAns = 0;
	while (indexA<a.length && indexB<b.length){    
	    if (a[indexA]<b[indexB]){
		ans[indexAns]=a[indexA];
		indexA+=1;
	    }
	    else{
	        ans[indexAns]=b[indexB];
		indexB+=1;
	    }
	    indexAns+=1;
	}
	if (indexA<a.length){
	    while (indexA<a.length){
		ans[indexAns]=a[indexA];
		indexA+=1;
		indexAns+=1;
	    }
	}
	else{
	    while (indexB<b.length){
		ans[indexAns]=b[indexB];
		indexB+=1;
		indexAns+=1;
	    }
	}
	return ans;
    }

    public String print(int[] s){
	String ans = "";
	for (int i=0;i<s.length;i++){
	    ans+=s[i]+ " ";
	}
	return ans;
    }

    public int[] mergeSort(int[] s){
	if (s.length<2){
	    return s;
	}
	int[] a = new int[s.length/2];
	int[] b = new int[s.length - (s.length/2)];
	for (int i=0;i<s.length/2;i++){
	    a[i]=s[i];
	}
	for (int i=s.length/2;i<s.length;i++){
	    b[i - s.length / 2]=s[i];
	}
	a = mergeSort(a);
	b = mergeSort(b);
	int[] ans = merge(a,b);
	return ans;
    }


    public static void main(String[] args){
	mergeSort t = new mergeSort();
	Random rand = new Random();
	int length = 100;
	int[] a = new int[length];
	while (length>0){
	    a[length-1]=rand.nextInt(100);
	    length-=1;
	}
	System.out.println(t.print(a));
	a = t.mergeSort(a);
	System.out.println(t.print(a));
    }
}
