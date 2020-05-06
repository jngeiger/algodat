package Sorting;

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
    	if (!recIsSorted(array.length-2, array.length-1))
    	{
    		// Overflow detection -> Start from beginning if end of array is reached
    		if (index2 == array.length)
    		{
    			index1 = 0;
    			index2 = 1;
    		}
    		swapIfNeeded(index1,index2);
    		bubbleRec(++index1,++index2);
    	}
    }
   
    
    private boolean recIsSorted(int index1,int index2)
    {
    	if (index1 == 0)
    	{
    		if (array[index1] < array[index2])
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	}
    	else
    	{
    		if (array[index1] > array[index2])
    		{
    			return false;
    		}
    		else {
    			return recIsSorted(index1-1,index2-1);	
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
    
  
        

     
    public static void main(String args[])
    {
        SortingAlgorithmClass s = new SortingAlgorithmClass(600);
       
        

        s.shuffle(true);
        s.dump(60);
        s.bubbleSortRec();
        System.err.println("SPACER");
        s.dump(60);
        
       
  
    }
}