package splay;

public class First {
    
    public static void main(String args[])
    {
        SplayTree<Integer> complexTree = new SplayTree<Integer>();
        SplayTree<Character> sptree = new SplayTree<Character>();
        Character[] starray = {'A','T','T','R','I','B','U','T'};
        
        int [] array = {0,19,19,17,8,1,20,19};
       	for (int i = 0; i < array.length; i++)
       	{
       		sptree.insert(starray[i]);
       	}
        
       	
//       complexTree.insert(14);
       
        System.out.println(sptree);

      
       
        

        

        
        


    }
}       

