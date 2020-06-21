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

public void traversalPostOrder()
{
	if (leftChild != null) leftChild.traversalInOrder();
	System.out.println(getValue());
	if (rightChild != null) rightChild.traversalInOrder();
}


public static void main(String[] args)
{
	BinaryNode<Integer> root = new BinaryNode<Integer>(50);

	
	BST<Integer> bst = new BST<Integer>(root);
	
	bst.insert(25);
	bst.insert(75);
	bst.insert(87);
	bst.insert(12);
	bst.insert(10);
	bst.insert(17);
	bst.insert(37);
	bst.insert(32);
	bst.insert(27);
	bst.insert(33);
	bst.insert(45);

	System.out.println(root);
	bst.delete(50);
	System.out.println(root);
	
}



}
