package baeume;

import java.util.function.Consumer;

public class BinFirst 
{
	BinaryNode<Integer> createTree()
    {
        BinaryNode<Integer> zero = new BinaryNode<Integer>(0);
        BinaryNode<Integer> one = new BinaryNode<Integer>(1);
        BinaryNode<Integer> five = new BinaryNode<Integer>(5);
        BinaryNode<Integer> seven = new BinaryNode<Integer>(7);
        BinaryNode<Integer> eight = new BinaryNode<Integer>(8);
        BinaryNode<Integer> nine = new BinaryNode<Integer>(9);
    
        seven.leftChild = one;
        seven.rightChild = nine;
        nine.leftChild = eight;
        one.leftChild = zero;
        one.rightChild = five;
    
        return seven;
    }
    
	BinaryNode<Integer> createEasyTree()
	{
		BinaryNode<Integer> zero = new BinaryNode<Integer>(0);
		BinaryNode<Integer> one = new BinaryNode<Integer>(1);
		BinaryNode<Integer> two = new BinaryNode<Integer>(2);
		BinaryNode<Integer> three = new BinaryNode<Integer>(3);
		BinaryNode<Integer> four = new BinaryNode<Integer>(4);
		
		zero.leftChild = one;
		zero.rightChild = two;
		two.leftChild = three;
		two.rightChild = four;
		
		return zero;
		
	}
    static public void main(String args[])
    {
//        BinFirst treeController = new BinFirst();
//        BinaryNode<Integer> root = treeController.createTree();
//        System.out.println(root);
//        System.out.println();
//	    Consumer<BinaryNode<Integer>>print = a -> {System.out.println(a.getValue());};    
//        root.preOrderTraversal(print);
//        System.out.println();
//        root.inOrderTraversal(print);
//        System.out.println();
//        root.postOrderTraversal(print);
//        System.out.println();
    	
    	BinFirst ctrl = new BinFirst();
    	BinaryNode<Integer> root = ctrl.createEasyTree();
        System.out.println(root.getHeigth(root));
    }
}