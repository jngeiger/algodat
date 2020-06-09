package tree;

import java.lang.reflect.Array;
import java.util.function.Consumer;

public class First {

    public TreeNode<String> createTree()
    {
        TreeNode<String> beverages = new TreeNode<String>("Beverages");
        TreeNode<String> hot = new TreeNode<String>("Hot");
        
        TreeNode<String> tea = new TreeNode<String>("Tea");
        TreeNode<String> coffee = new TreeNode<String>("Coffee");
        TreeNode<String> chocolate = new TreeNode<String>("Chocolate");

        TreeNode<String> green = new TreeNode<String>("Green");
        TreeNode<String> black = new TreeNode<String>("Black");
        TreeNode<String> chai = new TreeNode<String>("Chai");


        TreeNode<String> cold = new TreeNode<String>("Cold");

        TreeNode<String> limo = new TreeNode<String>("Limo");
        TreeNode<String> milk = new TreeNode<String>("Milk");
        
        TreeNode<String> citrone = new TreeNode<String>("Citrone");
        TreeNode<String> orange = new TreeNode<String>("Orange");
        
        beverages.add(hot);
        hot.add(tea);
        hot.add(coffee);
        hot.add(chocolate);
        tea.add(green);
        tea.add(black);
        tea.add(chai);

        beverages.add(cold);
        cold.add(limo);
        cold.add(milk);
        limo.add(citrone);
        limo.add(orange);   
        
        return beverages; 
    }
    
    public TreeNode<Integer> createPiTree()
    {
    	Integer[] x  = new Integer[] {3,1,4,1,5,9,2,6,5,3,5};
    	TreeNode<Integer> root = new TreeNode<Integer>(x[0]);
    	TreeNode<Integer> node = root;
    	
    	int idx = 1;
    	int breite = node.getValue();
    	int markIdx = 0;
    	while (idx < x.length)
    	{
    		for (int i = 0; i < node.getValue(); i++)
    		{
    			node.add(new TreeNode<Integer>(x[idx++]));
    		}
    		
    	}
    		
    	
    		
    	
    	return root;
    }
    
    static public void main(String args[])
    {
        First treeController = new First();
        TreeNode<String> root = treeController.createTree();
        Consumer<TreeNode<String>> printNode = a -> {System.out.println(a.getValue());};
//        root.depthFirst();
//
//        System.out.println();
        root.breadthFirst(); 
//        root.breadthFirstPerLine();
//        System.out.println(root.isInTree("Chai"));
//        First pi = new First();
//        TreeNode<Integer> piroot = pi.createPiTree();
//        piroot.depthFirst();
    }
}