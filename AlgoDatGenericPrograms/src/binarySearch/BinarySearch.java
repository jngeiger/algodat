package binarySearch;

public class BinarySearch {

public static void main(String[] args)
{
	int[] array = new int[] {1,51,61,80,91,104,201,301,401,910,1001};
	System.out.println(binarySearch(array,910));
}

public static int binarySearch(int[] array, int key)
{
	int lo = 0; int hi = array.length;
	while (lo <= hi)
	{
		int mid = lo + (hi - lo) / 2;
		if (key < array[mid]) 
		{
			hi = mid - 1;
		}
		else if (key > array[mid])
		{
			lo = mid + 1;
		}
		else
		{
			return mid;
		}
	}
	return -1;
}
}
