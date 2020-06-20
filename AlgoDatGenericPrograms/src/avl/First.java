package avl;

public class First {
    
    public static void main(String args[])
    {        
        int complexContent[] = {5, 6, 13, 12};
        AVLTree<Integer> complexTree = new AVLTree<Integer>();
        for (int v : complexContent)
            complexTree.insertRec(v);
        System.out.println(complexTree);
        complexTree.insertRec(11);
        System.out.println(complexTree);
    }
}