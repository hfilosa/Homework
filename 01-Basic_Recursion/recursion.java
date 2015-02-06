public class recursion {
    // returns the nth fibonacci number
    public int fib(int n){
	if (n == 2 || n == 1){
	    return 1;
	}
	else {
	    return fib(n-1)+fib(n-2);
	}
    }

    // returns the length of a string recursively
    public int len(String s){
	if (s.equals("")){
	    return 0;
	}
	else{
	    return 1+len(s.substring(1));
	}
    }

    //counts the number of times character c occurs in String s.
    public int count(char c,String s){
	if (s.equals("")){
	    return 0;
	}
	else{
	    if (s.charAt(0) == c){
		return 1+count(c,s.substring(1));
	    }
	    else{
		return count(c,s.substring(1));
	    }
	}
    }

    public static void main(String[] args){
	recursion r = new recursion();
	System.out.println(r.fib(4));
	System.out.println(r.fib(6));
	System.out.println(r.len("hello"));
	System.out.println(r.len("Dolphin"));
	System.out.println(r.count('l',"hello"));
	System.out.println(r.count('l',"lollopoloza"));
    }
}



