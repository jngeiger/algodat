package abstractQueue;

public class Queue<T> extends SampleQueue<T> {
private T[] array;
private int first;
private int last;


@SuppressWarnings("unchecked")
public Queue()
{
	array = (T[]) new Object[1];
	first = 0;
	last = 0;
}

public boolean isEmpty()
{
	return (first == last && array[first] == null);
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
private void _growIfNeeded(int size) throws Exception
{
	if (_getArrayElements() == array.length - 1)
	{
	T[] temp = (T[]) new Object[size];
	int i = 0;
	while (true)
	{
		try {
			temp[i] = get();
			i++;
		}
		catch (Exception e)
		{
			break;
		}
	}
	first = 0;
	last = i;
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

private void _debug()
{
	System.out.println("First: " + this.first + " Last: " + this.last + " Array Size: " + this.array.length);
}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Queue<String> q1 = new Queue<String>();
		
		q1.put("Hello");
		q1._debug(); //First: 0 Last: 1 Array Size: 1
	
		
		q1.put("World"); 
		q1._debug(); //First: 0 Last: 2 Array Size: 2
		
		q1.put("Test");
		q1.put("123");
		q1._debug(); // First: 0 Last: 4 Array Size: 4
		System.out.println(q1.get());  // Hello
		q1.put("another test");
		q1._debug(); //First: 1 Last: 1 Array Size: 4
		
		System.out.println(q1.get()); // World
		q1.put("Blub");
		System.out.println(q1.get()); // Test
		System.out.println(q1.get()); // 123
		q1._debug(); // First: 4 Last: 2 Array Size: 4
		System.out.println(q1._getArrayElements()); // 2 -> OK
		System.out.println(q1.get());// another test
		System.out.println(q1._getArrayElements()); // 1 - > OK
		q1._debug(); // First: 0 Last: 1 Array Size: 2 -> OK
		System.out.println(q1.get()); //-> Blub
		q1._debug(); // Array Size: 1 -> OK
		System.out.println(q1._getArrayElements()); // 0 -> OK
		q1.put("c");
		q1.put("s");
		q1.put("t");
		q1.put("j");
		System.out.println(q1._getArrayElements());
		System.out.println(q1.get());
		System.out.println(q1.get());
		q1.put("f");
		q1.put("t");
		q1.put("jk");
		q1._debug();
		
		System.out.println(q1.get());
		System.out.println(q1.get());
		System.out.println(q1.get());
		System.out.println(q1.get());
		System.out.println(q1.get());

		
		
	}

}
