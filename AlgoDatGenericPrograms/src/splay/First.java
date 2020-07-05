package splay;

import java.util.Arrays;

public class First {
    
    public static void main(String args[])
    {
        SplayTree<Integer> complexTree = new SplayTree<Integer>();
        SplayTree<Character> sptree = new SplayTree<Character>();
        Character[] starray = {'P','O','R','S','C','H','E'};
        
        int [] array = {0,19,19,17,8,1,20,19};
       	for (int i = 0; i < starray.length; i++)
       	{
       		sptree.insert(starray[i]);
       	}
       	sptree.splay_delete('S');
//       complexTree.insert(14);
       
        System.out.println(sptree);

      
       
        

        

        
        


    }
}       

