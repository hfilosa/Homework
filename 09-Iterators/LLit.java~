public class LLit<E>{
		private Node<E> t;
		public LLit(Node<E> n){
				t=n;
		}

		public boolean hasNext(){
				return t!=null;
		}

		public E next(){
				E retval = t.getData();
				t=t.getNext();
				return retval;
		}
}
