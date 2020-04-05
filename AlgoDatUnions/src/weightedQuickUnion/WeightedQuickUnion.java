package weightedQuickUnion;

public class WeightedQuickUnion {
private int[] array;
private int[] sz;

public WeightedQuickUnion(int size)
{
	array = new int[size];
	for (int i = 0; i < array.length; i++)
	{
		array[i] = i;
	}
	sz = new int[size];
	
}

public int root(int x)
{
	while (x != array[x])
	{
		array[x] = array[array[x]];
		x = array[x];
	}
	return x;
}

public void union(int x, int y)
{
	int i = root(x);
	int j = root(y);
	if (sz[i] < sz[j])
	{
		array[i] = j;
		sz[j] += sz[i];
	}
	else
	{
		array[j] = i;
		sz[i] += sz[j];
	}
	
}

public boolean connected(int x, int y)
{
	return root(x) == root(y);
}


public static void main(String[] args)
{
	var x = new WeightedQuickUnion(10);
	x.union(3, 4);
	x.union(7, 4);
	x.union(1, 2);
	System.out.println(x.connected(3,1));
	
}
}
