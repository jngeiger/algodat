package sortedList;

import java.util.function.Function;

public class SortedList<T extends Comparable<T>> extends OurList<T> {
private Node head = null;
private Node tail = null;
	

	@Override
	public void insert(T ele) {
		// TODO Auto-generated method stub
		// list is empty
		if (head == null)
		{
			head = new Node(ele);
		}
		
		else
		{
			Node current = head;
			Node element = new Node(ele);
			
			if (element.data.compareTo(current.data) > 0)
			{
				Node temp = current;
				head = element;
				element.next = temp;
				return;
			}
			
			while ((current.next != null) && element.data.compareTo(current.next.data) < 0)
			{
				current = current.next;
			}
			Node temp = current.next;
			current.next = element;
			element.next = temp;
			
			
			
			
		}
		
	}

	@Override
	public void insert(T ele, int pos) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean sorted()
	{
		Node current = head;
		boolean sorted = true;
		while (current.next != null)
		{
			if (current.data.compareTo(current.next.data) > 0 )
			{
				sorted = false;
			}	
			current = current.next;
		}
		return sorted;
	}
	
	public void sortList()
	{
		boolean mark = false;
		Node current = head;
		
		
		while (mark == false)
		{
			mark = true;
			current = head;
			while (current.next != null)
			{
				if (current.data.compareTo(current.next.data) < 0 )
				{
					mark = false;
					Node temp = current;
					Node temp2 = current.next;
					temp.next = current.next.next;
					temp2.next = temp;
					current = temp2;
					
				}
				
				current = current.next;
				
			}
			
		}
	}

	@Override
	public boolean delete(Function<T, Boolean> func) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
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
	    private Node next;
	    private T data;
	    
	    Node (T data) {
		      this.data = data;
		      this.next = null;
		    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedList<String> s1 = new SortedList<String>();
		s1.insert("M");
		s1.insert("X");
		s1.insert("F");
		s1.insert("C");
		s1.insert("A");
		//s1.insert("C");
		
		System.out.println(s1);
	}
}
