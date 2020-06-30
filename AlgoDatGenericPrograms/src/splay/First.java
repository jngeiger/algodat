package splay;

public class First {
    
    public static void main(String args[])
    {
        SplayTree<Integer> complexTree = new SplayTree<Integer>();
        int[] array = { 9,3,8,2,9,14,7,18,15,15,20};
//        int [] array = {7,18,15,15,20};
       	for (int i = 0; i < 11; i++)
       	{
       		complexTree.insert(array[i]);
       	}
        
//       complexTree.insert(14);
        complexTree.splay(7);
        complexTree.splay(18);
        complexTree.splay(15);
        complexTree.splay(15);
        complexTree.splay(20);
        System.out.println(complexTree);

      
       
        

        

        
        


    }
}       

