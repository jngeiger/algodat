package splay;

public class First {
    
    public static void main(String args[])
    {
        SplayTree<Integer> complexTree = new SplayTree<Integer>();

        complexTree.insertRec(2);
        complexTree.insertRec(3);
        complexTree.insertRec(1);
        System.out.println(complexTree);
        complexTree.root = complexTree.rightRotation(complexTree.root);
       
        System.out.println(complexTree);
        complexTree.root = complexTree.rightRotation(complexTree.root);
        

        

        
        


    }
}       

