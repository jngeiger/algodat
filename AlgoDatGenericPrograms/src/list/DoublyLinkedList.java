package list;

import java.util.function.Function;


public class DoublyLinkedList<T> extends OurList<T> {
Node head = null;
Node tail = null;

@Override
public void insert(T ele) {
	// TODO Auto-generated method stub
	if (head == null)
	{
		tail = new Node(ele);
		head = tail;
	}
	else {
	Node temp = head;
	head = new Node(ele);
	head.next = temp;
	temp.prev = head;
	
	}
}

@Override
public void insert(T ele, int pos) {
	// TODO Auto-generated method stub
	if (pos == 0 || head == null)
		insert(ele);
	else {
		int idx = 1;
		Node current = head;
		while (idx++ < pos && current.next != null)
		{
			current = current.next;
		}
		Node temp = new Node(ele);
		temp.next = current.next;
		current.next = temp;
		temp.prev = current;
		temp.next.prev = temp;
	}
	
}

@Override
public boolean delete(Function<T, Boolean> func) {
	// TODO Auto-generated method stub
	Node current = head;
	Node previous = null;
	if (func.apply(current.data))
	{
		head = current.next;
		return true;
	}
	previous = current;
	current = current.next;
	while (current.next != null)
	{
		if (func.apply(current.data))
		{
			previous.next = current.next;
			current.next.prev = previous;
			return true;
		}
		previous = current;
		current = current.next;
	}
	return false;
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	Node current = head;
	String str = "";
	while (current != null)
	{
		str += current.data;
		current = current.next;
		if (current != null)
		{
			str += " ";
		}
	}
	return str;
}

public String toStringReverse()
{
	Node current = tail;
	int counter = 0;
	String str = "";
	while (current != null)
	{
		str += current.data;
		current = current.prev;
		counter++;
		if (current != null)
		{
			str += " ";
		}
	}

	return str + ("\n DEBUG: END OF LL AFTER" + counter + " ELEMENTS REACHED");
}

private class Node {
	private T data;
	private Node next;
	private Node prev;
	Node (T data)
	{
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
}

}
