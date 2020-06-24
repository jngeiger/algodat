package splay;

public class First {
    
    public static void main(String args[])
    {
        SplayTree<Integer> complexTree = new SplayTree<Integer>();
        SplayTree<Integer> complexTree2 = new SplayTree<Integer>();
        
        
       int nodes[] = {71, 25,36,1,14,19,29,99,50};
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
        complexTree.splay(29);
        System.out.println(complexTree+"\n");
        

        
        


    }
}       

