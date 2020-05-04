package recursiveBinarySearch;

import java.util.ArrayList;
import java.util.List;

public class RecursiveBinarySearch<T extends Comparable<T>> {
private List<T> sortedList = null;
private int counter;
	
public RecursiveBinarySearch(List<T> list)
{
	list.sort((x,y) -> x.compareTo(y));
	sortedList = list;
}

public T search(T value) throws Exception
{
	return recursion(value, sortedList);
}

public T recursion(T value, List<T> list) throws Exception
{
	counter++;
	if (list.size() == 1 && !(value.compareTo(list.get(0)) == 0))
	{
			throw new Exception("Not in List");
	}
	
	if (value.compareTo(list.get(0)) == 0)
	{
		return (list.get(0));
	}
	if (value.compareTo(list.get(list.size() / 2 - 1)) < 0)
	{
		return recursion(value,list.subList(0, (list.size()/2)));
	}
	else
	{
		return recursion(value,list.subList(list.size() / 2 , (list.size())));
	}
}




public String toString()
{
	return sortedList.toString();
}


public static void main(String[] args) throws Exception
{
	var list = new ArrayList<Integer>();
//	for (int i = 0; i < 100; i++)
//	{
//		list.add(Integer.valueOf((int) (Math.random() * 10)+1));
//	}
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(4);
	list.add(5);
	list.add(42);
	list.add(6);
	list.add(41);
	list.add(38);
	list.add(22);
	list.add(8);
	
	RecursiveBinarySearch<Integer> search = new RecursiveBinarySearch<Integer>(list);
	System.out.println(list);
	search.search(42);

	System.out.println(search.counter);
	
}
}
