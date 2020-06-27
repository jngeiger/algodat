package splay;

public class SplayTree2<T extends Comparable<T>> {
SplayNode<T> root;
	public SplayTree2(SplayNode<T> node)
	{
		this.root = node;
	}
	
	public void insert(T value)
	{
		root = _insert(root,value);
	}
	
	public SplayNode<T> _insert(SplayNode<T> currentNode, T value)
	{
		if (currentNode == null) return new SplayNode<T>(value);
		
		if (value.compareTo(currentNode.getValue()) < 0)
		{
			currentNode.leftChild =  _insert(currentNode.leftChild, value);
			return currentNode;
		}
		else {
			currentNode.rightChild = _insert(currentNode.rightChild, value);
			return currentNode;
		}
	}
	
	public Boolean isIn(T value)
	{
		return _isIn(root, value);
	}
	
	public Boolean _isIn(SplayNode<T> currentNode, T value)
	{
		if (currentNode == null)
		{
			return false;
		}
		if (value.compareTo(currentNode.getValue()) == 0)
		{
			return true;
		}
		if (value.compareTo(currentNode.getValue()) < 0)
		{
			return _isIn(currentNode.leftChild, value);
		}
		else {
			return _isIn(currentNode.rightChild, value);
		}
	}
	
	public String toString()
	{
	        return root.toString();
	}
	
	
	
	
	
	
}
