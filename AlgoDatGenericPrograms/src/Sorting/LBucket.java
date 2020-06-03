package Sorting;

import java.util.LinkedList;

public class LBucket {
Node head;
Node tail;
int counter;

public void insert(int value)
{
	if (counter == 0)
	{
		head = new Node(value);
		tail = head;
	}
	else
	{
		Node temp = head;
		head = new Node(value);
		head.next = temp;
		temp.prev = head;
	}
	counter++;
}

public int getFIFO() throws Exception
{
	if (tail == null)
	{
		head = null;
		throw new Exception("LIST EMPTY");
	}
	int temp = tail.payload;
	tail = tail.prev;
	counter--;
	return temp;
}

public boolean isEmpty()
{
	if (head == null && tail == null)
	{
		return true;
	}
	else {
		return false;
	}
}





		
private class Node {
	int payload;
	Node next;
	Node prev;
	public Node(int value)
	{
		this.payload = value;
		this.next = null;
		this.prev = null;
	}
}
		
}

