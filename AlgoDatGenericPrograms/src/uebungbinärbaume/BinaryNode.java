package uebungbinärbaume;

public class BinaryNode<T> {
BinaryNode<T> leftChild;
BinaryNode<T> rightChild;
T payload;


public BinaryNode(T value)
{
	this.payload = value;
}

public T getValue()
{
	return payload;
}

public void setValue(T value)
{
	this.payload = value;
}

public String toString()
{
	return desc(this,"","","");
}
private String desc(BinaryNode<T> node, String top, String root, String bottom)
{
    if (node == null) return root + "null\n";
    
    if ((node.leftChild == null) && (node.rightChild == null))
        return root + node.payload + "\n";
    
    return desc(node.rightChild, 
                top + " ",
                top + "┌──", 
                top + "│ ") +
                root + node.payload + "\n" +
           desc(node.leftChild,
                bottom + "| ",
                bottom + "└──", 
                bottom + " ");
}

public int getHeight()
{
    return _hoehe(this);
}

private int _hoehe(BinaryNode<T> node)
{
	if (node == null)
		return -1;
	else
		return 1 + Math.max(_hoehe(node.leftChild), _hoehe(node.rightChild));
}

public void traversalPreOrder()
{
	
	System.out.println(this.getValue());
	if (leftChild != null) leftChild.traversalPreOrder();
	if (rightChild != null) rightChild.traversalPreOrder();
}

public void traversalInOrder()
{
	if (leftChild != null) leftChild.traversalInOrder();
	System.out.println(getValue());
	if (rightChild != null) rightChild.traversalInOrder();
}


public static void main(String[] args)
{
	BinaryNode<String> root = new BinaryNode<String>("ROOT");
	root.leftChild = new BinaryNode<String>("FIRST");
	root.rightChild = new BinaryNode<String>("SECOND");	
	root.rightChild.leftChild = new BinaryNode<String>("THIRD");
	root.rightChild.leftChild.leftChild = new BinaryNode<String>("Fourth");
	root.rightChild.leftChild.leftChild.rightChild = new BinaryNode<String>("Five");
	
	System.out.println(root);
	System.out.println(root.getHeight());
	root.traversalInOrder();
}



}
