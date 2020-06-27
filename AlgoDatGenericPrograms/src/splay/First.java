package splay;

public class First {
    
    public static void main(String args[])
    {
        SplayTree<Integer> complexTree = new SplayTree<Integer>();

        
//       int nodes[] = {40, 25, 72, 13, 30, 60, 76, 6, 17, 27, 34, 45, 66, 81, 1, 9, 19, 42, 52, 53, 7, 55, 56};
//        complexTree = new SplayTree<Integer>();
//        for (int v : nodes)
//        {
//            complexTree.insertRec(v);
//        }
//        for (int i = 0; i < 16; i++)
//        {
//        	complexTree.insertRec(i);
//        }
       complexTree.splay(56);
        
        complexTree.insert(1);
        complexTree.insert(3);
        complexTree.insert(3);
        complexTree.insert(4);

        
        System.out.println(complexTree);
        

//       int nodes[] = {40, 25, 72, 13, 30, 60, 76, 6, 17, 27, 34, 45, 66, 81, 1, 9, 19, 42, 52, 53, 7, 55, 56};
//        complexTree = new SplayTree<Integer>();
//        for (int v : nodes)
//        {
//            complexTree.insertRec(v);
//        }
        SplayTree2<Integer> myTree = new SplayTree2<Integer>(new SplayNode<Integer>(4));
        myTree.insert(22);
        myTree.insert(2);
        myTree.insert(45);
        myTree.insert(20);
        System.out.println(myTree);
        System.out.println(myTree.isIn(222));

        

        
        


    }
}       

