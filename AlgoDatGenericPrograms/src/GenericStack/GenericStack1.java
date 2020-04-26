package GenericStack;

public class GenericStack1<T> implements SomeStack<T> {
private int top;
private T[] array;

@SuppressWarnings("unchecked")
public GenericStack1()
{
	this.top = 0;
	this.array = (T[]) new Object[1];
}

@Override
public T pop() throws Exception {
	// TODO Auto-generated method stub
	_shrink();
	return array[--top];
}

@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return (0 == this.top);
}

public void push(T obj) {
	// TODO Auto-generated method stub
	_grow();
	array[top++] = obj;
}
@SuppressWarnings("unchecked")
private void _grow()
{
	if (this.top == array.length)
	{
		T[] arrayTemp = (T[]) new Object[2 * array.length];
		for (int i = 0; i < top; i++)
			arrayTemp[i] = array[i];
		array = arrayTemp;
		return;
	}
	else return;
}
@SuppressWarnings("unchecked")
private void _shrink()
{
	if ((this.top - 1) == array.length / 4)
	{
		T[] arrayTemp = (T[]) new Object[array.length / 2];
		for (int i = 0; i < top; i++)
			arrayTemp[i] = array[i];
		array = arrayTemp;
		return;
	}
}
// Only for debugging
public int _getArraySize()
{ 
	return this.array.length; 
}

}
