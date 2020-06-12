package baeume;

import java.util.function.Consumer;

public class BinaryNode<T> 
{
	private T value;
    public BinaryNode<T> leftChild = null;
    public BinaryNode<T> rightChild = null;
    
    BinaryNode(T v)
    {
        value = v;
    }
    
    public String toString()
    {
        return desc(this, "", "", "");
    }
    T getValue()
    {
        return value;
    }
    
    
    // Inspired by Knuth and programmed by Grooth
    private String desc(BinaryNode<T> node, String top, String root, String bottom)
    {
        if (node == null) return root + "null\n";
        
        if ((node.leftChild == null) && (node.rightChild == null))
            return root + node.value + "\n";
        
        return desc(node.rightChild, 
                    top + " ",
                    top + "   ", 
                    top + "  ") +
                    root + node.value + "\n" +
               desc(node.leftChild,
                    bottom + "  ",
                    bottom + "   ", 
                    bottom + " ");
    }
	public void preOrderTraversal(Consumer<BinaryNode<T>> v) 
	{
		v.accept(this);
		if(leftChild != null)
			leftChild.preOrderTraversal(v);
		if(rightChild != null)
			rightChild.preOrderTraversal(v);
	}
	public void inOrderTraversal(Consumer<BinaryNode<T>> v) 
	{
		if(leftChild != null)
			leftChild.inOrderTraversal(v);
		v.accept(this);
		if(rightChild != null)
			rightChild.inOrderTraversal(v);
	}
	public void postOrderTraversal(Consumer<BinaryNode<T>> v) 
	{
		if(leftChild != null)
			leftChild.postOrderTraversal(v);
		if(rightChild != null)
			rightChild.postOrderTraversal(v);
		v.accept(this);
	}
	public int getHeigth(BinaryNode<T> root) 
	{
		if(root == null)
			return 0;
		return 1 + max(getHeigth(root.leftChild) , getHeigth(root.rightChild));
	}
	public int max(int l, int r) 
	{
		return (l>r) ? l:r;
	}
}