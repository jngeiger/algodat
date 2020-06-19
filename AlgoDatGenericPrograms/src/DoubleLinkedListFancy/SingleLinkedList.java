package DoubleLinkedListFancy;

import java.util.function.Function;

public class SingleLinkedList<T> 
{
	private Node head;
	private Node tail;
	
	public SingleLinkedList()
	{
		head = null;
		tail = null;
	}
	
	public void insert(T ele) 
	{
		if (head == null)
		{
			head = new Node(ele);
			tail = head;
		}
		else {
			Node temp = head;
			head = new Node(ele);
			head.next = temp;
			temp.prev = head;
		}
	}
	
	public void insert(T ele, int pos) throws Exception
	{
		if (pos == 0)
		{
			insert(ele);
		}
		else {
			Node currentNode = head;
			for (int i = 1; i < pos; i++)
			{
				if (currentNode.next == null)
				{
					Node temp = currentNode;
					currentNode.next = new Node(ele);
					currentNode.next.prev = temp;
					tail = currentNode.next;
					return;
				}
				currentNode = currentNode.next;	
			}
			Node temp = new Node(ele);
			temp.prev = currentNode;
			temp.prev.next = temp;
			temp.next = currentNode.next;
			currentNode.next = temp;
		}
		
	}
	
	public boolean delete(Function<T, Boolean> fnc) 
	{
		Node currentNode = head;
		Node parent = head;
		while (currentNode != null)
		{
			if(fnc.apply(currentNode.value))
			{
				if (currentNode == head)
				{
					head = head.next;
					head.prev = null;
					return true;
				}
			parent.next = currentNode.next;
			if (currentNode.next != null)
			currentNode.next.prev = parent;
			else 
				tail = tail.prev;
			return true;
			}
		parent = currentNode;
		currentNode = currentNode.next;
		}
		
		return false;
	}
	
	
	public String toString() 
	{
		String v = "< ";
		Node current = head;
		while(current != null) 
		{
			v += current.value + " ";
			current = current.next;
		}
		v += ">";
		return v;
	}
	
	public String toString2() 
	{
		String v = "< ";
		Node current = tail;
		while(current != null) 
		{
			v += current.value + " ";
			current = current.prev;
		}
		v += ">";
		return v;
	}
	private class Node
	{
		private Node next;
		private Node prev;
		private T value;
		@SuppressWarnings("unused")
		private Node(T value) 
		{
			this.value = value;
			this.next = null;
			this.prev = null;
		}
	}
	public static void main(String[] args) throws Exception
	{
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		list.insert(22);
		list.insert(23);
		list.insert(24);
		list.insert(200,100);
		System.out.println(list);
		list.delete(x -> x == 23);
		System.out.println(list);
		System.out.println(list.toString2());
	}
}