package sortedList;

import java.util.function.Function;



public class SortedList<T extends Comparable<T>> extends OurList<T> 
{
	private Node head = null;

	@Override
	public void insert(T ele) 
	{
		// Base case, if LL is empty
		if (head == null)
		{
			head = new Node(ele);
			return;
		}
		
		// This case is called if the given element is greater than the first element in the list => the element will be the new head. Similar to the basic LL implementation
		if(!_isGreater(head.element, ele))
		{
			Node temp2 = new Node(ele);
			temp2.next = head;
			head = temp2;
			return;
		}
		
		// This is called if neither the base case nor the second case if given. The LL will be iterated until the next element in the list is greater than the given one.
		// OR the end of the LL is reached. Starting from line 37 the insertion process is started.
		Node current = head;
		while (current.next != null && _isGreater(current.next.element, ele))
		{
			current = current.next;
		}
		Node temp = new Node(ele);
		temp.next = current.next;
		current.next = temp;
	}
		
	//This returns 'true' if the first element is bigger or equal to the second
	private boolean _isGreater(T element1, T element2)
	{
		if(element1.compareTo(element2) <= 0 )
		{
			return true;
		}
		else
		{
			return false;
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
		Node current = head;
		// Test whether first node has to be deleted
		if (func.apply(current.element))
		{
			head = current.next;
			return true;
		}
		
		// Check rest of list
		Node prev = current;
		current = current.next;
		while (current != null)
		{
			if (func.apply(current.element))
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
		
		
//		System.out.println(list2.toString());
		
		SortedList<String> list3 = new SortedList<String>();
		SortedList<Integer> listInt = new SortedList<Integer>();
		
		for (int i = 0; i < 100; i++)
		{
			listInt.insert(((int)(Math.random() * 100)));
		}
		System.out.println(listInt);
		
//		list3.insert("c");
//		list3.insert("b");
//		list3.insert("a");
	
		list3.insert("z");
		list3.insert("x");
		list3.insert("k");
		list3.insert("m");
		list3.insert("b");
		list3.insert("a");
		
		
		
		System.out.println(list3.toString());
		
//		list2.insert("z");
//		list2.insert("f");
//		list2.insert("b");
//		System.out.println(list2);
//		
//		list2.delete(x -> x.contains("f"));
//		System.out.println(list2);
	}


}