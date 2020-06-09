package tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Consumer;


public class TreeNode<T> {
    private T value;
    public ArrayList<TreeNode<T>> children = new ArrayList<TreeNode<T>>();
    
    TreeNode(T v)
    {
        value = v;
    }
    
    void set(T val)
    {
    	value = val;
    }
    
    void add (TreeNode<T> child)
    {
        children.add(child);
    }
    
    T getValue()
    {
        return value;
    }
    
	void depthFirst()
	{
		System.out.println(this.getValue());
		for (int i = 0; i < children.size(); i++)
		{
			children.get(i).depthFirst();
		}
	}
	
	
	
	void breadthFirstPerLine()
	{
		ArrayList<TreeNode<T>> list = new ArrayList<TreeNode<T>>();
		System.out.println(getValue());
		for (int i = 0; i < children.size(); i++)
		{
			list.add(children.get(i));
		}
		int idx = 0;
		int marker = list.size();
		while (idx < list.size())
		{
			if (idx == marker)
			{
				System.out.println();
				marker = list.size();
			}
			TreeNode<T> node = list.get(idx);
			System.out.print(node.getValue() + " ");
			idx++;
			for (int i = 0; i < node.children.size(); i++)
				list.add(node.children.get(i));
		}
	}
	
	void breadthFirst()
	{
		ArrayList<TreeNode<T>> list = new ArrayList<TreeNode<T>>();
		System.out.println(this.getValue());
		for (int i = 0; i < children.size(); i++)
		{
			list.add(this.children.get(i));
		}
		
		int idx = 0;
		while (idx < list.size())
		{
			TreeNode<T> node = list.get(idx++);
			System.out.println(node.getValue());
			for (int i = 0; i < node.children.size();i++)
			{
				list.add(node.children.get(i));
			}
		}
	}
	
	Boolean isInTree(T value)
	{	
		if (getValue().equals(value))
		{
			return new Boolean(true);
		}
		
		for (int i = 0; i < children.size(); i++)
		{
			if(children.get(i).isInTree(value))
			{
				return new Boolean(true);
			}
		}
		
		return new Boolean(false);
		
	}
	
}

	
	
