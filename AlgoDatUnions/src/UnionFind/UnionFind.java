package UnionFind;

import QuickUnion.QuickUnion;

public class UnionFind {
private int[] array;

public UnionFind(int n)
{
	array = new int[n];
	for (int i = 0; i < array.length; i++)
	{
		array[i] = i;
	}
}

public boolean connected(int x, int y)
{
	return (array[x] == array[y]);
}

public void union(int x, int y)
{
	int xid = array[x];
	int yid = array[y];
	
	for (int i = 0; i < array.length; i++)
	{
		if (array[i] == xid)
		{
			array[i] = yid;
		}
	}
}

public static void main(String[] args)
{
	var x = new QuickUnion(10);
	x.union(2, 4);
	x.union(4, 5);
	x.union(5, 7);
	x.union(1, 8);
	System.out.println(x.connected(2, 5));
	System.out.println(x.connected(1, 8));
	System.out.println(x.connected(9, 1));
	System.out.println(x.connected(2,6));
}

}
