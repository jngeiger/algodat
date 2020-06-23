package splay;


public class SplayTree<T extends Comparable<? super T>> {
    
    public SplayNode<T> root;

    SplayTree()
    {
        root = null;
    }
    
    SplayTree(T value)
    {
        root = new SplayNode<T>(value);
    }
    
    public String toString()
    {
        return root.toString();
    }
    
    // #####     #####     #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####     #####     #####
    
    public void insertRec(T value)
    {
        root = _insertRec(root, value);
    }
    
    private SplayNode<T> _insertRec(SplayNode<T> currentNode, T value)
    {
        // How to find currentNode
        if (currentNode == null) return new SplayNode<T>(value);
        
        if (value.compareTo(currentNode.getValue()) < 0) // >
            currentNode.leftChild = _insertRec(currentNode.leftChild, value);
        else
            currentNode.rightChild = _insertRec(currentNode.rightChild, value);  
        
        // splaying for currentNode
        return currentNode;      
    }
    
    
    // #####     #####     #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####     #####     #####
    
    public Boolean isIn(T value)
    {
        SplayNode<T> currentNode = root;  
        
        while ((currentNode != null) && (value.compareTo(currentNode.getValue()) != 0))
        {
            if (value.compareTo(currentNode.getValue()) < 0)
                currentNode = currentNode.leftChild;
            else
                currentNode = currentNode.rightChild;            
        }
        
        return (currentNode != null);
    }
    
    // #####     #####     #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####     #####     #####
    
    public void delete(T value)
    {
        root = _delete(root, value);
    }
    
    private SplayNode<T> _delete(SplayNode<T> currentNode, T value)
    {
    	
        if (currentNode == null) return null;

        if (value.compareTo(currentNode.getValue()) == 0)
        {
            if ((currentNode.leftChild == null) && (currentNode.rightChild == null)) return null;
            if (currentNode.leftChild == null) return currentNode.rightChild;
            if (currentNode.rightChild == null) return currentNode.leftChild;

            T replacement = getMinValue(currentNode.rightChild);
            currentNode.setValue(replacement);
            currentNode.rightChild = _delete(currentNode.rightChild, replacement);
        }
        else if (value.compareTo(currentNode.getValue()) < 0) // >
            currentNode.leftChild = _delete(currentNode.leftChild, value);
        else
            currentNode.rightChild = _delete(currentNode.rightChild, value);
               
        return currentNode;
    }
    
    private T getMinValue(SplayNode<T> forNode)
    {
        while(forNode.leftChild != null)
        {
            forNode = forNode.leftChild;
        }
        return forNode.getValue();
    }
    
    // #####     #####     #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####     #####     #####

    private SplayNode<T> leftRotation(SplayNode<T> node)
    {
    	SplayNode<T> newRoot = node.rightChild;
    	node.rightChild = newRoot.leftChild;
    	newRoot.leftChild = node;
    	return newRoot;
    	
    }
    
    private SplayNode<T> rightRotation(SplayNode<T> node)
    {
        SplayNode<T> newRoot = node.leftChild;
        node.leftChild = newRoot.rightChild;
        newRoot.rightChild = node;
        return newRoot;
    }    

    public void printWayToNode(T value)
    {
      printWayToNodeRec(value,root);
    }
    
    public void printWayToNodeRec(T value, SplayNode<T> currentNode)
    {
    	System.out.println(currentNode.getValue());
    	if (value.compareTo(currentNode.getValue()) == 0)
    	{
    		return;
    	}
    	if (value.compareTo(currentNode.getValue()) > 0)
    	{
    		if (currentNode.rightChild != null)
    			printWayToNodeRec(value,currentNode.rightChild);
    	}
    	else {
    		if (currentNode.leftChild != null)
    		{
    			printWayToNodeRec(value,currentNode.leftChild);
    		}
    	}
    	
    }
    
    public void printWayBack(T value)
    {
        printWayBackRec(value,root);
    }
    
    public void printWayBackRec(T value, SplayNode<T> currentNode)
    {
    	if (value.compareTo(currentNode.getValue()) == 0)
    	{
    		System.out.println(currentNode.getValue());
    		return;
    	}
    	if (value.compareTo(currentNode.getValue()) > 0)
    	{
    		if (currentNode.rightChild != null)
    			printWayBackRec(value,currentNode.rightChild);
    			System.out.println(currentNode.getValue());
    	}
    	else {
    		if (currentNode.leftChild != null)
    		{
    			printWayBackRec(value,currentNode.leftChild);
    			System.out.println(currentNode.getValue());
    		}
    	}
    
    	
    
    	
    }
    
}
