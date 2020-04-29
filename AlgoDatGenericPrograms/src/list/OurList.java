package list;

import java.util.function.Function;

public abstract class OurList<T> {
	public abstract void insert(T ele);
	public abstract void insert(T ele, int pos);
    public abstract boolean delete(Function<T, Boolean> func);
    public abstract String toString();
    
public static void main(String[] args)
{
		List<Integer> l = new List<Integer>();
		
		l.insert(1);
		l.insert(11);
		l.insert(111);
		l.insert(1111);
		System.out.println(l + "\n");
		l.insert(2,2);
		
		System.out.println(l + "\n");
		
		Function<Integer, Boolean> isEven = a -> {return (a % 2) == 0;};
		l.delete(isEven);
		System.out.println(l + "\n");
		
		System.out.println("PART2 ////////////////////////////////");
		
		DoublyLinkedList<Integer> l2 = new DoublyLinkedList<Integer>();
		
		l2.insert(1);
		l2.insert(11);
		l2.insert(111);
		l2.insert(1111);
		
		
		System.out.println(l2 + "\n");
		System.out.println(l2.toStringReverse() + "\n");
		l2.insert(2,2);
		
		System.out.println(l2 + "\n");
		System.out.println(l2.toStringReverse() + "\n");
		
		

		l2.delete(isEven);
		System.out.println(l2 + "\n");
		System.out.println(l2.toStringReverse() + "\n");
		
		
}
}
