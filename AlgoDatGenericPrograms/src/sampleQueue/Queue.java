package sampleQueue;

public class Queue<T> extends SampleQueue<T> {

@SuppressWarnings("unchecked")
public Queue()
{
	array = (T[]) new Object[1];
	first = 0;
	last = 0;
}

protected boolean isEmpty()
{
	return (first == last && array[first] == null);
}

public void debug()
{
	System.out.println("First: " + this.first + " Last: " + this.last + " Array Size: " + this.array.length);
}

public T get() throws Exception
{
	if (isEmpty())
	{
		throw new Exception("Queue empty (get)");
	}
	if (first == array.length)
	{
		first = 0;
	}
	T temp = array[first];
	array[first] = null;
	first++;
	
	_shrinkIfNeeded(array.length / 2);
	
	return temp;
	
}

public void put(T element) throws Exception
{
	_growIfNeeded(2*array.length);
	
	if (last == array.length && array[0] == null)
	{
		last = 0;
	}
	
	array[last++] = element;
	
}

@SuppressWarnings("unchecked")
private void _growIfNeeded(int size)
{
	if (_getArrayElements() == array.length)
	{
	T[] temp = (T[]) new Object[size];
	for (int i = 0; i < array.length; i++)
	{
		temp[i] = array[i];
	}
	first = 0;
	array = temp;
	}
}
	
@SuppressWarnings("unchecked")
private void _shrinkIfNeeded(int size)
{
	if (_getArrayElements() <= array.length / 4)
	{
		T[] temp = (T[]) new Object[size];
		int counter = 0;
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] != null)
			temp[counter++] = array[i];
		}
		first = 0;
		last = temp.length - 1;
		array = temp;
	}
}

private int _getArrayElements()
{
	int count = 0;
	for (int i = 0; i < array.length; i++)
	{
		if (array[i] != null)
		{
			count++;
		}
	}
	return count;
}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Queue<String> q1 = new Queue<String>();
		System.out.println(q1.checkEmpty()); // true
		q1.put("Hello");
		q1.debug(); //First: 0 Last: 1 Array Size: 1
		System.out.println(q1.checkEmpty()); // false
		
		q1.put("World"); 
		q1.debug(); //First: 0 Last: 2 Array Size: 2
		
		q1.put("Test");
		q1.put("123");
		q1.debug(); // First: 0 Last: 4 Array Size: 4
		System.out.println(q1.get());  // Hello
		q1.put("another test");
		q1.debug(); //First: 1 Last: 1 Array Size: 4
		
		System.out.println(q1.get());
		
	}

}
