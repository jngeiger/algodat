package binarySearch;

public class BinarySearch {

public static void main(String[] args)
{
	int[] array = new int[] {1,51,61,80,91,104,201,301,401,910,1001};
	System.out.println(binarySearch(array,1001));
}

public static int binarySearch(int[] array, int key)
{
	int lo = 0; 
	int high = array.length;
	while (lo <= high)
	{
		int mid = lo + (high - lo) / 2;
		if (key < array[mid])
		{
			high = mid -1;
		}
		if (key > array[mid])
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
