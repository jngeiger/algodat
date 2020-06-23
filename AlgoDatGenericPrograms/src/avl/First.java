package avl;

public class First {
    
    public static void main(String args[])
    {        
        int complexContent[] = {10,20,15,25,30};
        AVLTree<Integer> complexTree = new AVLTree<Integer>();
        for (int v : complexContent)
            complexTree.insertRec(v);
        System.out.println(complexTree);
        complexTree.insertRec(22);
        System.out.println(complexTree);
    }
}