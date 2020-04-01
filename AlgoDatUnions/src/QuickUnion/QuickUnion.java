package QuickUnion;

public class QuickUnion {
private int[] array;

public QuickUnion(int n)
{
	array = new int[n];
	for (int i = 0; i < array.length; i++)
	{
		array[i] = i;
	}
}

public boolean connected(int x, int y)
{
	return (root(x) == root(y));
}

private int root (int x)
{
	while (x != array[x])
	{
		x = array[x];
	}
	return x;
}

public void union(int x, int y)
{
	array[root(x)] = root(y);
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
