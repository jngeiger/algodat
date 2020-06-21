package uebungbinärbaume;

public class BST<T extends Comparable<T>>{
BinaryNode<T> root;

public BST(BinaryNode<T> node)
{
	this.root = node;
}

public BST(T value)
{
	this.root = new BinaryNode<T>(value);
}

public String toString()
{
    return root.toString();
}

public void insertRec(T value)
{
    root = _insertRec(root, value);
}

private BinaryNode<T> _insertRec(BinaryNode<T> node, T value)
{
	if (node == null) return new BinaryNode<T>(value);
	if (value.compareTo(node.getValue()) < 0)
	{
		node.leftChild = _insertRec(node.leftChild,value);
	}
	else {
		node.rightChild = _insertRec(node.rightChild, value);
	}
	return node;
}


public void insert(T value)
{
	BinaryNode<T> parent = root;
	BinaryNode<T> current = root;
	
	while (current != null)
	{
		parent = current;
		if (value.compareTo(current.getValue()) < 0)
		{
			current = current.leftChild;
		}
		else {
			current = current.rightChild;
		}
	}
	if (value.compareTo(parent.getValue()) < 0)
	{
		parent.leftChild = new BinaryNode<T>(value);
	}
	else {
		parent.rightChild = new BinaryNode<T>(value);
	}
	
}
public void delete(T value)
{
    root = _delete(root, value);
}

private BinaryNode<T> _delete(BinaryNode<T> currentNode, T value)
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


private T getMinValue(BinaryNode<T> forNode)
{
    while(forNode.leftChild != null)
    {
        forNode = forNode.leftChild;
    }
    return forNode.getValue();
}


}
