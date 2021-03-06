package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SortingAlgorithmClass {
    public int array[]; // Fuer Debugging
    
    SortingAlgorithmClass(int aSize, int maxNum)
    {
        array = new int[aSize];
        
        Random dice;
        dice = new Random(42);
        
        for (int i = 0; i < aSize; i++)
        {
        	array[i] = dice.nextInt(maxNum+1);
        }
    }
    
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
    
    
    // HEAPSORT
    
    public void heapSort()
    {
    	createHeap();
    	for (int i = array.length-1; i >= 0; i--)
    	{
    		swapAtIndex(i,0);
    		sink(0,i-1);
    	}
    }

    public void createHeap()
    {
    	for (int i = (array.length-1)/2; i >= 0; i--)
    	{
    		sink(i,array.length-1);
    	}
    }
    
    public int leftSonOf(int nodeId)
    {return (nodeId * 2)+1;}
    
    public int rightSonOf(int nodeId)
    {return (nodeId * 2)+2;}
    
    public void sink(int nodeId, int lastId)
    {
    	while (leftSonOf(nodeId) <= lastId || rightSonOf(nodeId) <= lastId)
    	{
    		int maxId = leftSonOf(nodeId);
    		if (rightSonOf(nodeId) <= lastId && array[rightSonOf(nodeId)] > array[leftSonOf(nodeId)])
    		{
    			maxId = rightSonOf(nodeId);
    		}
    		if (array[maxId] > array[nodeId])
    		{
    			swap(maxId,nodeId);
    			nodeId = maxId;
    		}
    		else {
    			return;
    		}
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

    public void decending()
    {
        for (int i=0; i<array.length; i++)
            array[i] = array.length-i-1;
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
    
    
    private List<Integer> getPrattSequence(int max_size)
    {
    	List<Integer> list = new ArrayList<Integer>();
    	int temp = 0;
    	for (int i = 0; i < max_size; i++)
    	{
    		if (Math.pow(2, i) > max_size)
    		{
    			break;
    		}
    		for (int j = 0; j < max_size; j++)
    		{
    			temp = ((int)Math.pow(2, i)) * ((int)Math.pow(3, j));
    			if (temp > max_size)
        		{
        			break;
        		}
    			list.add(temp);
    		}
  
    		
    	}
    	
    	list.sort((x,y) ->x.compareTo(y));
    	return list;
    }
    
    
    public void insertionSort()
    {
    	for (int i = 1; i < array.length; i++)
    	{
    		int currentValue = array[i];
    		int j = i;
    		while (j >= 1 && array[j-1] > currentValue)
    		{
    			array[j] = array[j-1];
    			j--;
    		}
    		array[j] = currentValue;
    	}
    }
    
    private void insertionSort(int jump)
    {
    	for (int i=1; i<array.length; i+=1)
        {
            int currentValue = array[i];
            int j=i;
            while ((j>=jump) && (array[j-jump] > currentValue))
            {
                array[j] = array[j-jump];
                j -= jump;
            }
            array[j] = currentValue;
        }
    }
    
    
    public boolean isSorted()
    {
        for (int i=0; i<array.length-1; i++)
            if (array[i] > array[i+1]) return false;
        return true;
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
    
    public void ownBucketSort(int[] array)
    {
    	int max = array[0];
    	
    	for (int i = 1; i < array.length; i++)
    	{
    		if (array[i] > max) max = array[i];	
    	}
    	
    	int[] buckets = new int[max+1];
    	
    	for (int i = 0; i < array.length; i++)
    	{
    		buckets[array[i]]++;
    	}
    	
    	//UPDATE buckets
    	for (int i = 1; i <= max; i++)
    	{
    		buckets[i] = buckets[i] + buckets[i-1];
    	}
    	
    	//reinsert
    	int[] output = new int[array.length];
    	for (int i = array.length-1; i >= 0; i--)
    	{
    		output[--buckets[array[i]]] = array[i];
    	}
    	 System.out.println(Arrays.toString(output));
    	
    }
    
    
    
    public void radixSort() throws Exception
    {	
    	// Custom Array Buckets
    	class ABucket {
//        	ArrayList<Integer> intList;
        	int[] array;
        	int max = 0;
        		public ABucket(int x)
        		{
//        		intList = new ArrayList<Integer>();
        		array = new int[x];
        		}
        		public void push(int value)
        		{
        			array[max++] = value;
//        			intList.add(value);
        		}
        		public int get(int index) throws Exception
        		{
        			return array[index];
        		}
        	}
    	
    	// Create and initialize Buckets
    	ABucket[] cache = new ABucket[10];
    	
    	
    	
    	// Find Max and digits
    	int max = array[0];
    	for (int i = 1; i < array.length; i++)
    	{
    		if (array[i] > max)
    		{
    			max = array[i];
    		}
    	}
    	
    	int numberOfIterations = _getDigits(max);
    	
    	
    	// Run Sort k times
    	for (int k = 0; k < numberOfIterations;k++)
    	{		
    		for (int i = 0; i < cache.length; i++)
        	{
        		cache[i] = new ABucket(array.length);
        	}
    		
    		for (int i = 0; i < array.length; i++)
    		{
    				cache[_getDigitFromPos(array[i],k)].push(array[i]);
    		}
    		
        	int idx = 0;
        	for (int i = 0; i < cache.length; i++)
        	{
        		for (int j = 0; j < cache[i].max; j++)
        		{
        			array[idx++] = cache[i].get(j);
        		}
        		
        	}
    	} 	
    }
    public void radixSortArray() throws Exception
    {
    	class Bucket {
//    	ArrayList<Integer> intList;
    	int[] array;
    	int max = 0;
    		public Bucket(int x)
    		{
//    		intList = new ArrayList<Integer>();
    		array = new int[x];
    		}
    		public void push(int value)
    		{
    			array[max++] = value;
//    			intList.add(value);
    		}
    		public int get(int index) throws Exception
    		{
    			return array[index];
    		}
    	}
    	
    	
    	Bucket[] cache = new Bucket[10];
    	
    	
    	int max = array[0];
    	for (int i = 1; i < array.length; i++)
    	{
    		if (array[i] > max)
    		{
    			max = array[i];
    		}
    	}
    	int numberOfIterations = _getDigits(max);
    	
    	
    	for (int k = 0; k < numberOfIterations;k++)
    	{		
    		for (int i = 0; i < 10; i++)
        	{
        		cache[i] = new Bucket(array.length);
        	}
    		for (int i = 0; i < array.length; i++)
    		{
    				cache[_getDigitFromPos(array[i],k)].push(array[i]);
    		}
    		
        	int idx2 = 0;
        	for (int i = 0; i < cache.length; i++)
        	{
        		for (int j = 0; j < cache[i].max;j++)
        		{
        			array[idx2++] = cache[i].get(j);
        		}
        	}
        	
    		
    	}
    }
    
    
    
    private static int _getDigitFromPos(int nr, int pos)
    {
    	
    	for (int i = 0; i < pos; i++)
    	{
    		nr = nr / 10;
    		if (nr == 0)
    		{
    			return 0;
    		}
    	}
    	return nr % 10;
    }
    
    private static int _getDigits(int number)
    {
    	if (number == 0)
    	{
    		return 0;
    	}
    	else {
    		return 1 + _getDigits(number/10);
    	}
    }
    public void bucketSort()
    {
       int max = array[0];
       int min = array[0];
       
       for (int i = 1; i < array.length; i++)
       {
    	   if (array[i] > max) max = array[i];
    	   if (array[i] < min) min = array[i];
       }
       
       int[] buckets = new int[max-min+1];
       
       for (int i = 0; i < array.length; i++)
       {
    	   buckets[array[i]-min]++;
       }
       
       int idx = 0;
       for (int i = 0; i < buckets.length; i++)
       {
    	   for (int j = 0; j < buckets[i]; j++)
    	   {
    		   array[idx++] = i+min;
    	   }
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
    
    private int _partitionHoare(int l, int r)
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
    		 if (left < right)
    		 {
    			 swapAtIndex(left,right);
    		 }
    		 else 
    		 {
    			 return right;
    		 }
    	 }
    }
    
    private int[] _partitionDF(int [] array, int l, int r) {
    	int pivot = array[(l+r)/2];
    	int smaller = l;
    	int equals = l;
    	int bigger = r;
    	
    	while (equals <= bigger)
    	{
    	if (array[equals] < pivot)
    	{
    		swapAtIndex(smaller,equals);
    		smaller++; equals++;
    	}
    	else if (array[equals] == pivot)
    	{
    		equals++;
    	}
    	else {
    		swapAtIndex(equals,bigger);
    		bigger--;
    	}
    	}
    	int[] result = new int[] {smaller,bigger};
    	return result;
    }
    
    
    public void quickSort()
    {
    	quickSortSelfRec(array, array.length);
    }
    
    public void quickSortHoare()
    {
    	_quickSortHoareRec(0,array.length-1);
    }
    
    private void _quickSortHoareRec(int l, int r)
    {
    	if (l < r)
    	{
    		int pivotIDX = _partitionHoare(l,r);
    		_quickSortHoareRec(l,pivotIDX);
    		_quickSortHoareRec(pivotIDX+1,r);
    	}
    }
    
   
    
    private void quickSortRec(int[] theArray, int used)
    {
    	if (used < 2) return;
    	int lhs[] = new int[used-1];
    	int lCnt=0;
    	int rhs[] = new int[used-1];
    	int rCnt=0;
    	int pivots[] = new int[used];
    	int pCnt=0;
    	
    	int pivot = theArray[0];
    	
    	for (int i = 0; i < used; i++)
    	{
    		int v = theArray[i];
    		if (v < pivot) {
    			lhs[lCnt] = v;
    			lCnt ++;
    		}
    		
    		if (v == pivot) {
    			pivots[pCnt] = v;
    			pCnt ++;
    		}
    		
    		if (v > pivot) {
    			rhs[rCnt] = v;
    			rCnt ++;
    		}
    	}
    	
    		quickSortRec(lhs,lCnt);
    		quickSortRec(rhs,rCnt);
    		
    		int idx = 0;
    		for (int i = 0; i <lCnt;i++)
    		{
    			int v = lhs[i];
    			theArray[idx] = v;
    			idx++;
    		}
    		for (int i = 0; i <pCnt;i++)
    		{
    			int v = pivots[i];
    			theArray[idx] = v;
    			idx++;
    		}
    		for (int i = 0; i <rCnt;i++)
    		{
    			int v = rhs[i];
    			theArray[idx] = v;
    			idx++;
    		}
    		
    		
    }
    
    

    private void quickSortSelfRec(int[] myArray, int size)
    {
    	if (size < 2)
    		return;
    	int[] leftArray = new int[size-1];
    	int[] rightArray = new int[size-1];
    	int[] pivotArray = new int[size];
    	int leftcounter = 0;
    	int rightcounter = 0;
    	int pivotcounter = 0;
    	
    	int pivot = myArray[0];
    	for (int i = 0; i < size; i++)
    	{
    		if (myArray[i] < pivot)
    		{
    			leftArray[leftcounter++] = myArray[i];
    		}
    		if (myArray[i] == pivot)
    		{
    			pivotArray[pivotcounter++] = myArray[i];
    		}
    		if (myArray[i] > pivot)
    		{
    			rightArray[rightcounter++] = myArray[i];
    		}
    	}
    	quickSortSelfRec(leftArray,leftcounter);
    	quickSortSelfRec(rightArray,rightcounter);
    	
    	int index = 0;
    	for (int i = 0; i < leftcounter; i++)
    	{
    		myArray[index++] = leftArray[i]; 
    	}
    	for (int i = 0; i < pivotcounter; i++)
    	{
    		myArray[index++] = pivotArray[i]; 
    	}
    	for (int i = 0; i < rightcounter; i++)
    	{
    		myArray[index++] = rightArray[i]; 
    	}
    	
    
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
    
    
    public void slowSort()
    {
    	recSlowSort(this.array,0,array.length-1);
    }
    
    
    public void swap(int int1, int int2)
    {
    	int temp = array[int1];
    	array[int1] = array[int2];
    	array[int2] = temp;
    }
    
    
    private void swapAtIndex(int i, int j)
   	{
   		int zwsp = array[i];
   		array[i] = array[j];
   		array[j] = zwsp;
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
    
    public void selectionSort()
    {
    	int index = array.length;
    	for (int i = 0; i < array.length; i++)
    	{
    		int highestIndex = 0;
    		for (int j = 0; j < index; j++)
    		{
    			if (array[j] > array[highestIndex])
    			{
    				highestIndex = j;
    			}
    		}
    		index--;
			swapAtIndex(highestIndex,index);
    	}
    }
    
    public void shellSort() throws Exception
    {
    	if (array.length == 0)
    	{
    		throw new Exception("EMPTY ARRAY");
    	}
    	List<Integer> list = getPrattSequence(array.length);
        for (int i = list.size()-1; i >= 0; i--)
        {
        	insertionSort(list.get(i));
        }
    } 
    
    public void mergeSort()
    {
    	int tmpMemory[] = new int[array.length];
    	_mergeSortRec(0,array.length-1,tmpMemory);
    }
    
    private void _mergeSortRec(int l, int r, int tmpMemory[])
    {
    	if ((r-l) < 1)
    	{
    		return;
    	}
    	int m = (l+r)/2; 
    	_mergeSortRec(l,m,tmpMemory);
    	_mergeSortRec(m+1,r,tmpMemory);
    	
    	combine(l,m,r,tmpMemory);
    }
   
    private void combine(int l, int m, int r, int[] tmpMemory)
    {
    	int l_01 = l;
    	int r_01 = m;
    	int l_02 = m+1;
    	int r_02 = r;
    	int idx = 0;
    	
    	int i = l_01;
    	int j = l_02;
    	
    	while ((i <= r_01) && (j <= r_02))
    	{
    		if (array[i] < array[j])
    		{
    			tmpMemory[idx++] = array[i++];
    		}
    		else {
    			tmpMemory[idx++] = array[j++];
    		}
    	}
    	
    	while (i <= r_01)
    	{
    		tmpMemory[idx++] = array[i++];
    	}
    	while (j <= r_02)
    	{
    		tmpMemory[idx++] = array[j++];
    	}
    	
    	idx = 0;
    	for (int k = l;  k <= r_02; k++)
    	{
    		array[k] = tmpMemory[idx++];
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
    
    
     
    public static void main(String args[]) throws Exception
    {	// 12345670

        SortingAlgorithmClass s = new SortingAlgorithmClass(9);
        s.array = new int[] {6,17,3,42,8,9,4,60};
        s.quickSort();
        System.out.println(Arrays.toString(s.array));
        
       
  
//        s.mergeSort();


        
//        System.out.println(Arrays.toString(s.array));
        

        
        
        
//        s.array = new int[] {9000,123,123,431,333,452,119,125,423};
//        s.dump(60);
//        
//        s.radixSort();
//        System.out.println(Arrays.toString(s.array));

//        System.out.println(Arrays.toString(s.array));
//        System.out.println(s.isSorted());
       

//        s.shuffle(true);
//        s.selectionSort();
//        s.quickSortHoare();
//        s.dump(60);
//        System.out.println(s.isSorted());
//        s.dump(60);
//        s.shuffle(true);
//        s1.array = Arrays.copyOfRange(s.array, 0, s.array.length);
//        s2.array = Arrays.copyOfRange(s.array, 0, s.array.length);
//        s3.array = Arrays.copyOfRange(s.array, 0, s.array.length);
//        
//       long x = System.currentTimeMillis();
//       s.shellSort();
//       System.out.println(s.isSorted()  + "SHELL");
//       System.out.println(System.currentTimeMillis() - x);
//       
//       
//       long y = System.currentTimeMillis();
//       s1.mergeSortMain();
//       System.out.println(s1.isSorted()  + "MERGE");
//       System.out.println(System.currentTimeMillis() - y);
//       
//       long z = System.currentTimeMillis();
//       s2.bubbleSort();
//       System.out.println(s2.isSorted() + "BUBBLE");
//       System.out.println(System.currentTimeMillis() - z);
//       
//       long f = System.currentTimeMillis();
//       s3.insertionSort();
//       System.out.println(s3.isSorted() + "INSERTION");
//       System.out.println(System.currentTimeMillis() - f);

        
//        SortingAlgorithmClass s1 = new SortingAlgorithmClass(1_234_567);
//        SortingAlgorithmClass s2 = new SortingAlgorithmClass(1_234_567);
//        SortingAlgorithmClass s3 = new SortingAlgorithmClass(1_234_567);
//    
//        
//        s.shuffle(true);
//        s1.array = Arrays.copyOfRange(s.array, 0, s.array.length);
//        s2.array = Arrays.copyOfRange(s.array, 0, s.array.length);
//        s3.array = Arrays.copyOfRange(s.array, 0, s.array.length);
//        
//       long x = System.currentTimeMillis();
//       s.shellSort();
//       System.out.println(s.isSorted()  + "SHELL");
//       System.out.println(System.currentTimeMillis() - x);
//       
//       
//       long y = System.currentTimeMillis();
//       s1.mergeSortMain();
//       System.out.println(s1.isSorted()  + "MERGE");
//       System.out.println(System.currentTimeMillis() - y);
       
//       long z = System.currentTimeMillis();
//       s2.bubbleSort();
//       System.out.println(s2.isSorted() + "BUBBLE");
//       System.out.println(System.currentTimeMillis() - z);
       
//       long f = System.currentTimeMillis();
//       s.insertionSort();
//       System.out.println(s.isSorted() + "INSERTION");
//       System.out.println(System.currentTimeMillis() - f);

       
//			s.mergeSortMain();
//        s.recSlowSort(s.array, 0, s.array.length-1);
//        s.dump(60);
//        s.mergeSortMain();
//        s.dump(60);
        
//        s.dump(60);
       // s.dump(60);
        
       
  
    }
}