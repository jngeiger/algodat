package avl;

public class First {
    
    public static void main(String args[])
    {        
        int complexContent[] = {10,5,18,4,16,19,17};
        Character[] list = {'A','T','T','R','I','B','U','T'};
        AVLTree<Integer> complexTree = new AVLTree<Integer>();
        AVLTree<Character> characterTree = new AVLTree<Character>();
        for (char v : list)
            characterTree.insertRec(v);
        
        System.out.println(characterTree);
    }
}