package avl;

public class First {
    
    public static void main(String args[])
    {        
        int complexContent[] = {10,5,18,4,16,19,17};
        AVLTree<Integer> complexTree = new AVLTree<Integer>();
        for (int v : complexContent)
            complexTree.insertRec(v);
        System.out.println(complexTree);
       complexTree.delete(10);
        System.out.println(complexTree);
    }
}