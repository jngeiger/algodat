package DynamicArray;

public class DynStringArray {
private String[] arr;
int counter;

public DynStringArray() {
	arr = new String[1];
	counter = 0;
}

public void add(String item)
{
	if (arr.length == counter) {
		resize(2 * arr.length);
	}
	arr[counter] = item;
	counter++;
}

public void delete()
{
arr[--counter] = null;
if ((arr.length / 4) == counter)
{
	resize(arr.length / 2);
	System.err.println("Array shrinked because its at one quarter the size");
}


}



public void resize(int newSize)
{
	String[] arrNew = new String[newSize];
	for (int i = 0; i < counter; i++)
	{
		arrNew[i] = arr[i];
	}
	arr = arrNew;
}

public void getDynArray()
{
	for (String s:arr)
	{
		if (s != null)
		System.out.println(s);
	}
}

public int getLength()
{
	return arr.length;
}

public static void main(String[] args)
{
	DynStringArray array = new DynStringArray();
	array.add("Hello");
	array.add("World");
	array.add("Is");
	array.add("This");
	array.add("Scaling");
	array.add("Correctly?");
	
	
	array.delete();
	array.delete();
	array.delete();
	System.out.println(array.getLength());
	array.delete();
	System.out.println(array.getLength());
	

	
	
	
	
}
}
