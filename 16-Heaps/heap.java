public class heap{
    private int[] heap;
    private int size;

    public heap(int root){
	heap=new int[7];
	size=1;
    }

    public int findMin(){
	return heap[0];
    }

    public int removeMin(){
	int ans = heap[0];
	heap[0]=heap[size-1];
	size--;
	pushdown(0);
	return ans;
    }

    public void insert(int val){
	heap[size]=val;
	size++;
	pushup(size-1);
    }

    private void pushdown(int index){
	int left=(index*2)+1;
	int right=(index*2)+2;
	if (heap[index]>heap[left] || heap[index]>heap[right]){
	    int temp=heap[index];
	    if (heap[left]<heap[right]){
		heap[index]=heap[left];
		heap[left]=temp;
		pushdown(left);
	    }
	    else {
		heap[index]=heap[right];
		heap[right]=temp;
		pushdown(right);
	    }
	}
    }

   private void pushup(int index){
       int parent;
       if (index%2==0) parent = (index/2)-1;
       else parent = (index/2);
       if (heap[index]<heap[parent]){
	   int temp=heap[index];
	   heap[index]=heap[parent];
	   heap[parent]=temp;
	   pushup(parent);
	    
       }
   }

    public String toString(){
	String ans = "";
	for (int i=1;i<size;i=(int)Math.pow(2,i)){
	    for (int n=i-1;i>=0;n--){
		ans=heap[n]+ans;
	    }
	    ans+="\n";
	}
	return ans;
    }

    public static void main(String[] args){
	heap h=new heap(5);
	System.out.println(h);
        h.insert(7);
	System.out.println(h);
	h.insert(2);
	System.out.println(h);
    }
}
