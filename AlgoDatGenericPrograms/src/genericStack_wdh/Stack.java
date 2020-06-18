package genericStack_wdh;

public class Stack<T> {
private T[] array;
private int top;

public static void main(String[] args) throws Exception
{
	Stack<Integer> stack = new Stack<Integer>();
	System.out.println(stack.isEmpty());
	stack.push(20);
	stack.push(30);
	stack.push(30);
	stack.push(40);
	stack.push(50);
	stack.push(50);
	stack.push(50);
	stack.pop();
	stack.pop();
	stack.pop();
	stack.pop();
	stack.pop();
	stack.push(3);
	
}

public String toString()
{
	String value = "";
	for (int i = 0; i < top; i++)
	{
		value += array[i] + " ";
	}
	return value;
}

@SuppressWarnings("unchecked")
public Stack()
{
	array = (T[]) (new Object[1]);
	top = 0;
}

public void push(T value)
{
	if (top == array.length)
	{
		_growIfNeeded();
	}
	array[top++] = value;
	System.out.println(array.length);
}

public T pop() throws Exception
{
	T temp = null;
	try {
		temp = array[--top];
	}
	catch (Exception e)
	{
		System.out.println("Stack is empty!");
	}
	if (top == array.length/4)
	{
		_shrinkIfNeeded();
	}
	return temp;
}

public T peek()
{
	T temp = null;
	try {
		temp = array[top-1];
	}
	catch (Exception e)
	{
		System.out.println("Stack is empty!");
	}
	return temp;
}

public Boolean isEmpty()
{
	return (top == 0?true:false);
}

@SuppressWarnings("unchecked")
private void _shrinkIfNeeded()
{
	Object[] temp = new Object[array.length/2];
	for (int i = 0; i < top; i++)
	{
		temp[i] = array[i];
	}
	array = (T[])temp;
}

@SuppressWarnings("unchecked")
private void _growIfNeeded()
{
	Object[] temp = new Object[array.length*2];
	for (int i = 0; i < array.length; i++)
	{
		temp[i] = array[i];
	}
	array = (T[])temp;
}

}
