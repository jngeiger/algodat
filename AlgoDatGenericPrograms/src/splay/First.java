package splay;

public class First {
    
    public static void main(String args[])
    {
        SplayTree<Integer> complexTree = new SplayTree<Integer>();
        SplayTree<Integer> complexTree2 = new SplayTree<Integer>();
        
        
       int nodes[] = {40, 25, 72, 13, 30, 60, 76, 6, 17, 27, 34, 45, 66, 81, 1, 9, 19, 42, 52, 53, 7, 55, 56};
        complexTree = new SplayTree<Integer>();
        for (int v : nodes)
        {
            complexTree.insertRec(v);
            complexTree2.insertRec(v);
        }
//        for (int i = 0; i < 16; i++)
//        {
//        	complexTree.insertRec(i);
//        }
//        

        
       
        
        System.out.println(complexTree+"\n");
        complexTree.splay(52);
        complexTree2.splay_stoehr_init(52);
        System.out.println(complexTree+"\n");
        System.out.println(complexTree2+"\n");

        
        


    }
}       

