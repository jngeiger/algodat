package binarySearchStoehr;

import java.util.Random;
import java.util.Arrays;

public class SortedArray {
    private int aArray[];
    private int aSize;
    private Random dice;

    final private int MAXVALUE = 21;
    
    SortedArray()
    {
        aSize = 42;
		aArray = new int[42];
        
        dice = new Random(4221);	
		
		for (int i=0; i<aSize; i+=1)
			aArray[i] = dice.nextInt(MAXVALUE);
        Arrays.sort(aArray);
        System.out.println(Arrays.toString(aArray));
    }
        
    int getAnyValue()
    {
        return aArray[dice.nextInt(aSize)];
    }
    
    // #####.    #####.    #####.    #####.    #####.    #####.    ######
    
    Boolean findInArray(int aValue)
    {
        for (int i = 0; i < aArray.length; i++)
        {
        	if (aValue == aArray[i])
        	{
        		return true;
        	}
        }
        return false;
    }
    
    Boolean findInArrayFastRec(int aValue)
    {
    	return (_findInArrayFastRec(aValue,0,aArray.length-1));
    }
    
    private Boolean _findInArrayFastRec(int aValue, int lo, int hi)
    {
    	if (aValue == aArray[((lo+hi)/2)])
    	{
    		return true;
    	}
    	if (lo >= hi)
    	{
    		return false;
    	}
    	else {
    		return (aValue < aArray[(lo+hi)/2]) ? _findInArrayFastRec(aValue,lo,((lo+hi)/2)-1) : _findInArrayFastRec(aValue,((lo+hi)/2)+1,hi);
    	}
    }

    Boolean findFastInArray(int aValue)
    {
       int lo = 0;
       int hi = aArray.length-1;
       int mid = (lo+hi)/2;
       
       while (lo != hi)
       {
    	   if (aValue == aArray[mid])
    	   {
    		   return true;
    	   }
    	   else if (aValue < aArray[mid])
    	   {
    		   hi = mid - 1;
    		   mid = (lo + hi)/2;
    		  
    	   }
    	   else {
    		   lo = mid+1;
    		   mid = (mid+1 + hi) / 2;
    		  
    	   }
       }
       return false;
    }
    
    public static void main(String args[])
    {
        SortedArray myArray = new SortedArray();
        
        System.out.println(myArray.findFastInArray(2));
        System.out.println(myArray.findInArrayFastRec(2));
       
    }
}