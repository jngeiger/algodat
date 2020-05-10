package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithmClass {
    public int array[]; // Fuer Debugging
    
    SortingAlgorithmClass()
    {
        this(42);
    }

    SortingAlgorithmClass(int n)
    {
        array = new int[n];
        for (int i=0; i<n; i++)
            array[i] = i;
    }

    SortingAlgorithmClass(int otherArray[])
    {
        array = new int[otherArray.length];
        for (int i=0; i<otherArray.length; i++)
            array[i] = otherArray[i];
    }
 
    public void ascending()
    {
        for (int i=0; i<array.length; i++)
            array[i] = i;
    }

    public void decending()
    {
        for (int i=0; i<array.length; i++)
            array[i] = array.length-i-1;
    }
    public void mergeSortMain()
    {
    	mergeSort(array,0,array.length);
    }
    public void mergeSort(int[] unsortedArray, int l, int r)
    {
    	if (r-l <= 1)
    	{
    		return;
    	}
    	int m = (l+r)/2;
    	mergeSort(unsortedArray,l,m);
    	mergeSort(unsortedArray,m,r);
    	merge(unsortedArray,l,m,r);
    	
    }
    
    private void merge(int [] unsortedArray,int l, int m, int r)
    {
    	int[] left = Arrays.copyOfRange(unsortedArray,l,m);
    	int[] right = Arrays.copyOfRange(unsortedArray,m,r);
    	int leftIndex = 0;
    	int rightIndex = 0;
    	
    	for (int i = l; i < r; i++)
    	{
    		boolean leftMore = leftIndex < left.length;
    		boolean rightMore = rightIndex < right.length;
    		boolean leftSmaller = leftMore && rightMore && left[leftIndex] <= right[rightIndex];
    		
    		if (!rightMore || leftSmaller)
    		{
    			unsortedArray[i] = left[leftIndex++]; 
    		}
    		else
    		{
    			unsortedArray[i] = right[rightIndex++];
    		}
    	}
    	
    }
   
    public void slowSort()
    {
    	recSlowSort(this.array,0,array.length-1);
    }
    
    public void recSlowSort(int[] array, int i, int j)
    {
    	if (i >= j)
    	{
    		return;
    	}
    	int m = (i+j)/2;
    	recSlowSort(array,i,m);
    	recSlowSort(array,m+1,j);
    	
    	if (array[m] > array[j])
    	{
    		int temp = array[m];
    		array[m] = array[j];
    		array[j] = temp;
    	}
    	
    	recSlowSort(array,i,j-1);
    	
    }
    
    public void shuffle(boolean random)
    {
        Random dice;
        
        if (random)
            dice = new Random((int)(Math.random() * 984648678) + 1);
        
        else
            dice = new Random(42);

        // Knuth Band 2
        for (int i=0; i<array.length; i++)
        {
            int j = dice.nextInt(i+1);
            int zwsp = array[i];
            array[i] = array[j];
            array[j] = zwsp;
        }
    }   
    
    public boolean isSorted()
    {
        for (int i=0; i<array.length-1; i++)
            if (array[i] > array[i+1]) return false;
        return true;
    }
    
    public void dump(int lineLength)
    {
        int nrLength = (int)Math.log10(array.length)+2;
        int maxPerLine = lineLength / nrLength;
        String formatStr = "%" + nrLength + "d";
        
        for (int i=0; i<array.length; i++)
        {
            if ((i!=0) && (i%maxPerLine==0)) System.out.println();
            System.out.printf(formatStr, array[i]);
        }
    }
    
    public void randomSort()
    {
    	int keepAlive = 1;
    	while(!isSorted())
    	{
    		shuffle(true);
    		keepAlive++;
    		System.out.println(keepAlive);
    	}
    }
    
    public void bubbleSort()
    {
    	boolean check = true;
    	do {
    		check = true;
    		for (int i = 0; i < array.length - 1; i++)
    		{
    			if (array[i] > array[i+1])
    			{
    				int temp = array[i];
    				array[i] = array[i+1];
    				array[i+1] = temp;
    				check = false;
    			}
    		}
    	} while(check == false);
    }
    
    public void bubbleSortRec()
    {
    	bubbleRec(0,1);
    }
    
    private void bubbleRec(int index1, int index2)
    {
    
    		// Overflow detection -> Start from beginning if end of array is reached  and recursively check whether the array is now sorted 
    		if (index2 == array.length)
    		{	
    			if (recIsSorted(0, 1))
    			{
    				return;
    			}
    			else {
    			index1 = 0;
    			index2 = 1;
    			}
    		}
    		swapIfNeeded(index1,index2);
    		bubbleRec(++index1,++index2);
    }
   
    // Checks if the given array is sorted by recursively calling itself
    private boolean recIsSorted(int index1,int index2)
    {
    	if (index2 == array.length-1)
    	{
    		if (array[index1] < array[index2])
    			return true;
    		else
    			return false;
    	}
    	else
    	{
    		if (array[index1] > array[index2])
    		{
    			return false;
    		}
    		else {
    			return recIsSorted(index1+1,index2+1);	
    		}
    	}
    }
    
    private void swapIfNeeded(int index1, int index2)
    {
    	if (array[index1] > array[index2])
		{
			int temp = array[index1];
			array[index1] = array[index2];
			array[index2] = temp;
		}
	}
    
    
    public int[] dropSort()
    {
    	int[] newArray = new int[array.length];
    	newArray[0] = array[0];
    	int index2 = 1;
    	
    	for (int i = 1; i < array.length; i++)
    	{
    		if (array[i] > newArray[index2-1])
    		{
    			newArray[index2++] = array[i];
    			
    		}
    	}
    	
    	int[] cleanedArray = new int[index2];
    	for (int i = 0; i < cleanedArray.length; i++)
    	{ 
    		cleanedArray[i] = newArray[i];
    	}
    	return cleanedArray;
    }
    
  
    public void quickSort(int l, int r)
    {
    	if (r-l <= 1)
    	{
    	return;
    	}
    	else {
    	int partition = partition(l,r);
    	quickSort(l,partition-1);
    	quickSort(partition+1,r);
    	}
   }
    
    
    public int partition(int l,int r)
    {
    	int pivot = array[r];
    	int i = l-1;
    	
    	for (int j = l; j < r; j++)
    	{
    		if (array[j] <= pivot)
    		{
    			i++;
    			swap(j,i);
    		}
    	}
    	swap(r,i+1);
    	return i+1;
    }
    
    public void swap(int int1, int int2)
    {
    	int temp = array[int1];
    	array[int1] = array[int2];
    	array[int2] = temp;
    }
     
    public static void main(String args[])
    {

        SortingAlgorithmClass s = new SortingAlgorithmClass(8);
        s.shuffle(true);
        s.mergeSortMain();
//        s.recSlowSort(s.array, 0, s.array.length-1);
//        s.dump(60);
//        s.mergeSortMain();
//        s.dump(60);
        System.out.println(s.isSorted());
        s.dump(60);
       // s.dump(60);
        
       
  
    }
}