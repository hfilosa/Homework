public class Node{
		private int data;
		private Node next;

		public Node(int n){
				data = n;
				next = null;
		}
		public void setData(int n){
				data = n;
		}
		public int getData(){
				return data;
		}
		public void setNext(Node n){
				next = n;
		}
		public Node getNext(){
				return next;
		}
		public String toString(){
				return ""+data;
		}
}
