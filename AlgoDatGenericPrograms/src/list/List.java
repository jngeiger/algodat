package list;

import java.util.function.Function;

public class List<T> extends OurList<T> {

	private Node head = null;
	
	public void insert(T ele) {
	}

	public void insert(T ele, int pos) {
	}

	public boolean delete(Function<T, Boolean> func) {
		return false;
	}

	public String toString() {
		String retStr = "empty";
		return retStr;
	}

	private class Node {
	    Node (T data) {
	      this.data = data;
	      this.next = null;
	    }
	    private Node next;
	    private T data;
	}

	// #####     #####     #####     #####     #####     #####
	
	static public void main(String args[])
	{
		List<Integer> l = new List<Integer>();
		
		l.insert(1);
		l.insert(11);
		l.insert(111);
		l.insert(1111);
		l.insert(2,2);
		
		System.out.println(l);
		
		Function<Integer, Boolean> isEven = a -> {return (a % 2) == 0;};
		l.delete(isEven);
		System.out.println(l);
	}
}
