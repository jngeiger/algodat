package StackInt;

public class StackInt {
private Integer top;
private Integer[] array;

public StackInt() 
{
	this.top = 0;
	this.array = new Integer[1];
}

public void push(int aValue)
{
	if (array.length == top)
	resize(2 * array.length);
	array[top++] = aValue;
}

public int pop() throws Exception
{ 
	if (isEmpty())
	{
		throw new Exception("Stack is empty, nothing to pop");
	}
	int temp = array[--top];
	array[top] = null;
	if (top == array.length / 4)
		resize(array.length / 2);
	return temp;
}

private void resize(int size)
{
	Integer[] arrayTemp = new Integer[size];
	for (int i = 0; i < top; i++)
	{
		arrayTemp[i] = array[i];
	}
	array = arrayTemp;
}

public boolean isEmpty()
{
	return top == 0;
}

public void print()
{
	for (int i = 0; i < top; i++)
	{
		System.out.println(array[i]);
	}
}

public static void main(String[] args)
{
	var s1 = new StackInt();
	s1.push(50);
	s1.push(21);
	s1.push(10);
	s1.push(5);
	s1.push(2);
	try {
	s1.pop();
	s1.pop();
	s1.pop();
	}
	catch (Exception e)
	{
		System.out.println(e.getMessage());
	}

	
	System.out.println(s1.isEmpty());
	System.out.println(s1.array.length);
	s1.print();
	
	try {
		s1.pop();
		s1.pop();
		s1.pop();
		}
	catch (Exception e)
		{
		System.out.println(e.getMessage());
		}
	
	
}




}
