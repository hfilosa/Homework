public class Driver{
		public static void main(String[] args) {
		    LList l = new LList();
		    l.add("hello");
		    l.add("world");
		    for (int i=0;i<5;i++){
			l.add(""+i);
		    }
		    System.out.println(l);
		    System.out.println("Zeroth Link: "+l.get(0));
		    System.out.println("Third Link: "+l.get(3));
		    System.out.println("Tenth link: "+l.get(10));
		    System.out.println("\n---------------\n");
		    l.add(0,"a");
		    System.out.println("'a' inserted as zeroth link");
		    System.out.println(l+"\n");
		    l.add(5,"b");
		    System.out.println("'b' inserted as fifth link");
		    System.out.println(l+"\n");
		    l.add(10,"c");
		    System.out.println("'c' inserted as ninth link");
		    System.out.println("Method will not go past the end of the links");
		    System.out.println(l.getNode(9));
		    System.out.println(l.getNode(9).getNext());
		    System.out.println(l);


		}
}
