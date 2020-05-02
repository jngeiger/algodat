package sortedList;

import java.util.function.Function;


public class SortedList<T extends Comparable<T>> extends OurList<T> 
{
	private Node head = null;

	@Override
	public void insert(T ele) 
	{
		
		if (head == null)
		{
			head = new Node(ele);
			return;
		}

		if(!_isGreater(head.element, ele))
		{
			Node temp2 = new Node(ele);
			temp2.next = head;
			head = temp2;
			return;
		}
		Node current = head;
		
		while (current.next != null && _isGreater(current.next.element, ele))
		{
			current = current.next;
		}
		Node temp = new Node(ele);
		temp.next = current.next;
		current.next = temp;
	}
		
	
	private boolean _isGreater(T element1, T element2)
	{
		if(element1.compareTo(element2) < 0 )
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	@Override
	public void insert(T ele, int pos) 
	{
		insert(ele);	
	}

	@Override
	public boolean delete(Function<T, Boolean> func) 
	{
	
		return false;
	}

	@Override
	public String toString() 
	{
		String str = "";
		Node temp = head;
		while(temp != null)
		{
			str += temp.element+"\n";
			temp = temp.next;
		}
		return str;
	}
	
	class Node 
	{
		private Node next = null;
		private T element;
		public Node(T object)
		{
			
			this.element = object;
			this.next = null;
		}
	}
	
	public static void main (String [] args)
	{
		SortedList<String> list2 = new SortedList<String>();
//		
//		
//		list2.insert("k");
//		list2.insert("b");
//		list2.insert("z");
//		list2.insert("x");
//		list2.insert("m");
//		list2.insert("r");
//		list2.insert("y");
//		list2.insert("s");
//		list2.insert("t");
//		list2.insert("a");
		
		
		System.out.println(list2.toString());
		
		SortedList<String> list3 = new SortedList<String>();
		
		list3.insert("c");
		list3.insert("b");
		list3.insert("a");
		
		System.out.println(list3.toString());
		
		list2.insert("z");
		list2.insert("f");
		list2.insert("b");
		System.out.println(list2);
	}


}
