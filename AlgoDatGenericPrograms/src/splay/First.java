package splay;

public class First {
    
    public static void main(String args[])
    {
        SplayTree<Integer> complexTree = new SplayTree<Integer>();

        complexTree.insert(2);
        complexTree.insert(126);
        complexTree.insert(4);
        complexTree.insert(3);
        complexTree.insert(12);
        complexTree.insert(13);
        complexTree.insert(15);
        complexTree.insert(28);
        complexTree.insert(29);
        complexTree.insert(315);
        complexTree.insert(32);
        complexTree.insert(57);
        complexTree.insert(60);
        complexTree.insert(99);
        complexTree.insert(77);
        complexTree.insert(21);
        complexTree.insert(18);
        
        
//        complexTree.splay(67);
        System.out.println(complexTree);
 complexTree.splay_delete(12);
        
        System.out.println(complexTree);
       
        

        

        
        


    }
}       

