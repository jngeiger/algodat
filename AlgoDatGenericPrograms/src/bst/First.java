package bst;

import java.util.function.Consumer;

public class First {
    
    public static void main(String args[])
    {
//    	BinaryNode<Integer> n1 = new BinaryNode<Integer>(50);
//    	BinaryNode<Integer> n2 = new BinaryNode<Integer>(25);
//    	BinaryNode<Integer> n3 = new BinaryNode<Integer>(75);
//    	BinaryNode<Integer> n4 = new BinaryNode<Integer>(12);
//    	BinaryNode<Integer> n5 = new BinaryNode<Integer>(37);
//    	BinaryNode<Integer> n6 = new BinaryNode<Integer>(87);
//    	BinaryNode<Integer> n7 = new BinaryNode<Integer>(10);
//    	BinaryNode<Integer> n8 = new BinaryNode<Integer>(17);
//    	BinaryNode<Integer> n9 = new BinaryNode<Integer>(32);
//    	BinaryNode<Integer> n10 = new BinaryNode<Integer>(45);
//    	BinaryNode<Integer> n11 = new BinaryNode<Integer>(27);
//    	BinaryNode<Integer> n12 = new BinaryNode<Integer>(33);
//    	
//    	n1.leftChild = n2;
//    	n1.rightChild = n3;
//    	n3.rightChild = n6;
//    	n2.leftChild = n4;
//    	n2.rightChild = n5;
//    	n4.leftChild = n7;
//    	n4.rightChild = n8;
//    	n5.leftChild = n9;
//    	n5.rightChild = n10;
//    	n9.leftChild = n11;
//    	n9.rightChild = n12;
    	
//    	n1.traversalPostOrder(x -> System.out.println(x));
    	
//    	var ezn1 = new BinaryNode<Integer>(1);
//    	var ezn2 = new BinaryNode<Integer>(2);
//    	var ezn3 = new BinaryNode<Integer>(3);
//    	var ezn4 = new BinaryNode<Integer>(4);
//    	ezn1.leftChild=ezn2;
//    	ezn1.rightChild=ezn3;
//    	ezn2.leftChild=ezn4;
//    	
//    	Consumer<BinaryNode<Integer>> consume = (x -> System.out.println(x));
//    	System.out.println(ezn1.hoehe());
//    	
//    	ezn1.traversalPreOrder(consume);
//    	System.out.println();
//    	ezn1.traversalInOrder(consume);
//    	System.out.println();
//    	ezn1.traversalPostOrder(consume);
    	
//    	System.out.println(n1.hoehe());
    	
//    	
//        BST<Integer> l = new BST<Integer>();
//        for (int i=0; i<5; i++)
//            l.insert(i);  
//        System.out.println(l);
        
//        BST<Integer> b = new BST<Integer>();
//        for (int v : values)
//            b.insert(v);
//        System.out.println(b.findRec(85812));
//        System.out.println(b.find(85812));
//        System.out.println(b);
//
//        System.out.println();
//        
//        BST<Integer> lr = new BST<Integer>();
//        for (int i=0; i<5; i++)
//            lr.insertRec(i);
//        System.out.println(lr);
        int[] values = {50,25,75,12,37,87,10,17,32,45,27,28,33};
        BST<Integer> br = new BST<Integer>();
        for (int v : values)
            br.insertRec(v);
        System.out.println(br);
        
        br.deleteIter(25);
        System.out.println(br);
        
    }
}
