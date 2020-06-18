package selectionSortRec;

import java.util.Arrays;

public class SelectionSort {

	
	public static void main(String[] args)
	{
		int[] arrayPaul = {12,13,11,10,9,8,7,6,5,4,3,2,1};
		int[] array = {12,99,8,4,16,15};
		selectionSort(arrayPaul);
		System.out.println(Arrays.toString(arrayPaul));
	}
	
	public static void selectionSort(int[] array)
	{
		selectionSortRec(array,0,array.length-1);
	}
	public static void selectionSortRec(int[] array, int l, int r)
	{
		if (l == r)
			return;
		int result = insertionGoingUp(array,l,r,0);
		swapAtIndex(array,result,r);
		selectionSortRec(array,l,r-1);
	}
	
	public static int insertionGoingUp(int[] array, int l, int r, int max)
	{
		if (l > r)
		{
			return max;
		}
		if (array[l] > array[max])
		{
			max = l;
		}
		return insertionGoingUp(array,l+1,r,max);
	}
	
	public static void swapAtIndex(int[] array, int one, int two)
	{
		int temp = array[one];
		array[one] = array[two];
		array[two] = temp;
	}
}
