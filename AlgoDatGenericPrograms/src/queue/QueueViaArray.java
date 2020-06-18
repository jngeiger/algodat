package queue;

import java.lang.reflect.Array;

public class QueueViaArray<T> extends Queue<T> 
{
	T array[];
	int first=0;
	int last=0;
	@SuppressWarnings("unchecked")
	public QueueViaArray() 
	{
		array = (T[]) new Object[2];
	}
	@Override
	public void put(T value) 
	{
		if (array.length == last)
				_growIfNeeded();
		array[last++] = value;
		
	}
	@Override
	public T get() 
	{
		T temp = array[first];
		array[first++] = null;
		if (last - first <= array.length/4)
		{
			_shrinkIfNeeded();
		}
		return array[first++];
	}
	@Override
	public boolean isEmpty() 
	{
		return (first > last);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void _growIfNeeded() 
	{
		T[] temp = (T[])new Object[array.length*2];
		for (int i = 0; i < last; i++)
		{
			temp[i] = array[i];
		}
		array = (T[])temp;
	}
	@Override
	protected void _shrinkIfNeeded() 
	{
		T[] temp = (T[])new Object[array.length/2];
		for (int i = 0; i < last; i++)
		{
			temp[i] = array[i];
		}
		array = (T[])temp;
		last = last - first;
		first = 0;
	}
	public String toString()  
	{
		String v=" | ";
		for(int i =0;i<array.length;i++)
			v += array[i] + " | ";
//		v += "\nLength: " + q.length;
		return v;
	}
}