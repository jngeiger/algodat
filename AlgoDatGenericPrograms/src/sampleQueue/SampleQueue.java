package sampleQueue;

public abstract class SampleQueue<T> {
protected T[] array;
protected int first;
protected int last;

final boolean checkEmpty() 
{
	for (int i = 0; i < array.length; i++)
	{
		if (array[i] != null)
		{
			return false;
		}
	}
	return true;
}
abstract protected T get() throws Exception;
abstract protected void put(T element) throws Exception;
abstract protected boolean isEmpty();


}
