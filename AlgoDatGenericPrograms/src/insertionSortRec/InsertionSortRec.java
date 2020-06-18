package insertionSortRec;

import java.util.Arrays;

public class InsertionSortRec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayPaul = {12,13,11,10,9,8,7,6,5,4,3,2,1};
		int[] array = {12,99,8,4,16,15};
		insertionSortRec(arrayPaul);
		System.out.println(Arrays.toString(arrayPaul));
	}
	
	public static void insertionSort(int[] array)
	{
		int currentValue = array[0];
		for (int i = 1; i < array.length; i++)
		{
			int j = i;
			currentValue = array[j];
			while (j >= 1 && currentValue < array[j-1])
			{
				array[j] = array[j-1];
				j--;
			}
			array[j] = currentValue;
		}
	}
	
	public static void insertionSortRec(int[] array)
	{
		insertionSortRecCall(array,0);
	}
	
	public static void insertionSortRecCall(int[] array, int length)
	{
		if (array.length == length)
		{
			return;
		}
		
		int j = length;
		int currentValue = array[length];
		
		while (j >= 1 && currentValue < array[j-1])
		{
			array[j] = array[j-1];
			j--;
		}
		array[j] = currentValue;
		
		insertionSortRecCall(array,length+1);
	}
	
	
}
