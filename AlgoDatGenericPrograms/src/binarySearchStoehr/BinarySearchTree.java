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
}