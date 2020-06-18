package quickSortIterative;

import java.util.Arrays;
import java.util.Random;

public class Temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int arrayPaul[] = {12,13,11,10,9,8,7,6,5,4,3,2,1,0};
		int hello[] =     {12,13,11,10,9,8,7,6,5,4,3,2,1,0};
		int test[] = {12,99,8,4,16,15};
//		int[] stoehr = getRandomArray();
//		shuffle(stoehr);
		quickSortIter(test);
		
		System.out.println(Arrays.toString(test));
	
	}
	public static int[] getRandomArray()
	{
		int[] array;
	 array = new int[300];
     
     Random dice;
     dice = new Random(42);
     
     for (int i = 0; i < array.length; i++)
     {
     	array[i] = dice.nextInt(10000+1);
     }
     return array;
	}
	
	public static void shuffle(int[] array)
    {
        Random dice;
        
        
            dice = new Random((int)(Math.random() * 984648678) + 1);
        
        

        // Knuth Band 2
        for (int i=0; i<array.length; i++)
        {
            int j = dice.nextInt(i+1);
            int zwsp = array[i];
            array[i] = array[j];
            array[j] = zwsp;
        }
    }   
	
	public static void quickSortIter(int[] array)
	{
		int result = _partitionHoare(array,0,array.length-1);
		int y = result+1;
		while (result > 1)
		{
			result = _partitionHoare(array,0,result);
			
		}
		while (y < array.length-1 )
		{
			result = _partitionHoare(array,y,array.length-1);
			y = result+1;
		}
	}
	
	
    
    private static void _quickSortHoareRec(int[] array,int l, int r)
    {
    	if (l < r)
    	{
    		int pivotIDX = _partitionHoare(array,l,r);
    		_quickSortHoareRec(array,l,pivotIDX);
    		_quickSortHoareRec(array,pivotIDX+1,r);
    	}
    }
	
	private static int _partitionHoare(int[] array, int l, int r)
    {
    	 int pivot = array[l];
    	 int left = l-1;
    	 int right = r+1;
    	 
    	 while(true)
    	 {
    		 do {
    			 left++;
    		 } while (array[left] < pivot);
    		 
    		 do {
    			 right--;
    		 } while (array[right] > pivot);
    		 if (right >= left)
    		 {
    			 return right;
    		 }
    		 else 
    		 {
    			 swapAtIndex(array,left,right);
    		 }
    	 }
    }
	
	private static void swapAtIndex(int[] array,int i, int j)
   	{
   		int zwsp = array[i];
   		array[i] = array[j];
   		array[j] = zwsp;
   	}
	
	public static void quickSortByHoare(int [] arr, int l, int r) 
	{
		if(l<r) 
		{
			int p = _getPivot(arr, l, r);
			quickSortByHoare(arr, l, p);
			quickSortByHoare(arr, p+1, r);
		}
	}
	public static int _getPivot(int[]arr,int l, int r) 
	{
		int p=arr[l];
		int le=l-1;
		int re =r+1;
		while(true)
		{
			do 
			{
				le++;
			}while(arr[le] < p);
			do 
			{
				re--;
			}while(arr[re] > p);
			if(le<re)
				swap(arr, le, re);
			else
				return re;
		}
	}
	public static void swap(int[] array,int i, int j) 
    {
    	int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
    }
	
	public static void print(int[] arr) 
	{
		System.out.print("<");
		for(int i=0;i<arr.length;i++)
			System.out.print(" " + arr[i]);
		System.out.print(" >");
		System.out.println();
	}
}
