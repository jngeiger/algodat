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
    
    public void find(T value)
    {
    	
    }
    
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

    public SplayNode<T> leftRotation(SplayNode<T> node)
    {
    	SplayNode<T> pivot = node.rightChild;
        node.rightChild = pivot.leftChild;
        pivot.leftChild = node;
        
        return pivot;    
    }
    
    public SplayNode<T> rightRotation(SplayNode<T> node)
    {
    	SplayNode<T> pivot = node.leftChild;
        node.leftChild = pivot.rightChild;
        pivot.rightChild = node;
        
        return pivot;
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
    public void splay(T value)
    {
    		root = _splay(root,value);
    }
    
    
    
    	private SplayNode<T> _splay(SplayNode<T> node, T value)
        {
            if ((node == null) || (value.compareTo(node.getValue()) == 0)) return node;

            if (node.getValue().compareTo(value) > 0) // node.value > value  
            {  
                // Node nicht im Baum 
                if (node.leftChild == null) return node;  
      
                // Zig-Zig (Left Left) 
                if (node.leftChild.getValue().compareTo(value) > 0) // node.left.value > value
                {  
                    node.leftChild.leftChild = _splay(node.leftChild.leftChild, value);  
      
                    // Erste Rotation 
                    node = rightRotation(node);  
                }  
                else if (node.leftChild.getValue().compareTo(value) < 0) // Zig-Zag (Left Right)  
                {  
                    node.leftChild.rightChild = _splay(node.leftChild.rightChild, value);  
      
                    // Rotation fuer node.left  
                    if (node.leftChild.rightChild != null)  
                        node.leftChild = leftRotation(node.leftChild);  
                }  
      
                // Zweite Rotation fuer node  
                if (node.leftChild == null) 
                    return node;
                else 
                    return rightRotation(node);  
            }  
            else 
            {  
                // Node nicht im Baum
                if (node.rightChild == null) return node;  
      
                // Zag-Zig (Right Left)  
                if (node.rightChild.getValue().compareTo(value) > 0)  
                {  
                    node.rightChild.leftChild = _splay(node.rightChild.leftChild, value);  
      
                    // Erste Rotation fuer node.right  
                    if (node.rightChild.leftChild != null)  
                        node.rightChild = rightRotation(node.rightChild);  
                }  
                else if (node.rightChild.getValue().compareTo(value) < 0)// Zag-Zag (Right Right)  
                {  
                    node.rightChild.rightChild = _splay(node.rightChild.rightChild, value);  
                    node = leftRotation(node);  
                }  
      
                // Zweite Rotation 
                if (node.rightChild == null) 
                    return node;
                else 
                    return leftRotation(node);  
            } 
        }
    	   public void insert(T value)
    	    {
    	        
    	        if (root == null) 
    	        {
    	            root = new SplayNode<T>(value); 
    	            return;
    	        }

    	        SplayNode<T> newNode = new SplayNode<T>(value);
    	        
    	        // Knoten oder des Mutter in die Wurzel splayen
    	        root = _splay(root, value);
    	        
    	        // Knoten und gesplayten Baum zusammenbauen
    	        if (root.getValue().compareTo(value) >= 0)
    	        {
    	            newNode.rightChild = root;
    	            newNode.leftChild = root.leftChild;
    	            root.leftChild = null;
    	            root = newNode;
    	        }
    	        else {
    	            newNode.leftChild = root;
    	            newNode.rightChild = root.rightChild;
    	            root.rightChild = null;
    	            root = newNode;
    	        }
    	    }
    
    	
}
    	
   
    

