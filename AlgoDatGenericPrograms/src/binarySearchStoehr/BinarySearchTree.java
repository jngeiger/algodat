package binarySearchStoehr;

public class BinarySearchTree<T extends Comparable<? super T>> 
{
	private BinaryNode<T> root;
	public BinarySearchTree() 
	{
		root = null;
	}
	public BinarySearchTree(T value) 
	{
		root = new BinaryNode<T>(value);
	}
	public String toString() 
	{
		return root.toString();
	}
	public void insert(T value) 
	{
		
	}
	public Boolean find(T value) 
	{
		BinaryNode<T> node = root;
		while((node != null) && (node.getValue() != value)) 
		{
			//TBD
//			if(value.compareTo(node))
//				node = node.leftChild;
//			else
//				node = node.rightChild;
		}
		return (node!=null);
	}
	
	public void insert(T value)
	{
		BinaryNode<T> newNode = new BinaryNode<T>(value);
		BinaryNode<T> currentNode = root;
		
		if (root == null)
		{
			root = newNode;
			return;
		}
		
		BinaryNode<T> parent = null;
		// Blattposition suchen
		while (currentNode != null)
		{
			parent = currentNode;
			if (value.compareTo(currentNode.getValue()) < 0)
			{
				currentNode = currentNode.leftChild;
			}
			else {
				currentNode = currentNode.rightChild;
			}
		}
		
		// Knoten einfügen
		if (value.compareTo(parent.getValue()) < 0)
		{
			parent.leftChild = newNode;
		}
		else {
			parent.rightChild = newNode;
		}
		
	}
	
}