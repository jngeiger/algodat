package hashing;

import java.util.ArrayList;

public class Hashing <T extends Comparable<T>> {
	    private ArrayList<ArrayList<T>> hashTable;
	    private int hashTableSize;
	    
	    Hashing()
	    {
	        this(997);
	    }
	    
	    Hashing(int aSize)
	    {
	        hashTableSize = aSize;
	        hashTable = new ArrayList<ArrayList<T>>();
	        
	        for (int i=0; i<hashTableSize; i++)
	        {
	            ArrayList<T> collisonTable = new ArrayList<T>();
	            hashTable.add(collisonTable);
	        }
	    }
	    
	    public String toString()
	    {
	        String res = "";
	        
	        for (int i=0; i<hashTableSize; i++)
	        {
	            ArrayList<T> collisonTable = hashTable.get(i);
	            res += "[" + i + "]";
	            res += "<";
	            for (int j=0; j<collisonTable.size(); j += 1)
	                res += collisonTable.get(j);
	            res += ">\n";
	        }
	        return res;
	    }
	    
	    public void add(T value)
	    {
	        // Hash Wert
	    	int hash = value.hashCode();
	    	int hashValue = Math.abs(hash)%hashTableSize;
	    	
	    	// Element in der Kollisionstabelle ablegen
	    	ArrayList<T> c = hashTable.get(hashValue);
	    	c.add(value);
	    }
	    
	    public Boolean isIn(T value)
	    {
	    	// Hash Wert
	    	int hash = value.hashCode();
	    	int hashValue = Math.abs(hash)%hashTableSize;
	    	
	    	// Element in der Kollisionstabelle ablegen
	    	ArrayList<T> c = hashTable.get(hashValue);
	    	
	    	for (int i = 0; i < c.size(); i++ )
	    	{
	    		if (c.get(i).compareTo(value) == 0) return true;
	    	}
	    	return false;
	    }
	    
	    public Boolean delete(T value)
	    {
	    	return true;
	    }
}
