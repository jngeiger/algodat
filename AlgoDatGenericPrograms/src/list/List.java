 package list;

import java.util.function.Function;

public class List<T> extends OurList<T> {

	private Node head = null;
	
	public void insert(T ele) {
		// list is empty
		if (head == null)
		{
			head = new Node(ele);
		}
		else
		{
			Node temp = head;
			head = new Node(ele);
			head.next = temp;
		}
	}

	public void insert(T ele, int pos) {
		if (pos == 0 || head == null)
		{
			insert(ele);
		}
		else {
			int idx = 1;
			Node current = head;
			while ((current.next != null) && (idx++ < pos))
			{
				current = current.next;
			}
			// Insert Node
			Node temp = new Node(ele);
			temp.next = current.next;
			current.next = temp;
		}
	}

	public boolean delete(Function<T, Boolean> func) {
		Node current = head;
		// Test whether first node has to be deleted
		if (func.apply(current.data))
		{
			head = current.next;
			return true;
		}
		
		// Check rest of list
		Node prev = current;
		current = current.next;
		while (current != null)
		{
			if (func.apply(current.data))
			{
				// node to be deleted has been found
				prev.next = current.next;
				return true;
			}
			// Update of current and previous
			prev = prev.next;
			current = current.next;
		}
		
		return false;
	}

	public String toString() {
		String retStr = "";
		Node current = head;
		while (current != null)
		{
			retStr += current.data;
			current = current.next;
			if (current != null)
			{
				retStr += " ";
			}
		}
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
	
}
