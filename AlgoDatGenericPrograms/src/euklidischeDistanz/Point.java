package euklidischeDistanz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Point{
private double x;
private double y;

public Point(int a, int b) 
{
	this.x = a;
	this.y = b;
}

public String toString()
{
	return "(" + (int)this.x + "," + (int)this.y + ")";
}

public double product()
{
	return this.x * this.y;
}


public static void main(String[] args)
{
	Point a = new Point(2,3);
	Point b = new Point(4,7);
	Point[] array = new Point[4096];
	
	for (int i = 0; i < array.length; i++)
	{
		array[i] = new Point((int)(Math.random()*10000) + 1, (int)(Math.random()*10000) + 1);
		for (int j = 0; j < array.length; j++)
		{
			if (array[j] == null)
			{
				continue;
			}
			if (i == j)
			{
				continue;
			}
			else if (array[i].x == array[j].x && array[i].y == array[j].y)
			{
			i--;
			break;
			}
		}
	}
			
	List<Point> list = Arrays.asList(array);
	
	Arrays.sort(array,  new Comparator<Point>() {
		public int compare(Point p1, Point p2)
		{
			if (p1.product() < p2.product()) { return -1; }
			else if (p1.product() > p2.product()) {return 1;}
			else { return 0; }
		}});
//	boolean check = false;
//	for (int i = 0; i < array.length -1; i++)
//	{
//		System.out.println(array[i] + "|" + array[i+1] + "Differenz: " + array[i].getDifference(array[i+1]));
//		if ((array[i].getDifference(array[i+1]) == 0.0))
//				{
//					check = true;
//				}
//	}
//	System.out.println(check);
//	
	
	
	try {
		getLowestDistance(array);
		fastLowestDistance(array);
	}
	catch (Exception e)
	{
		System.err.println(e.getMessage());
	}
}


public double getDifference(Point o) {
	return Math.sqrt(Math.pow(o.x - this.x, 2.0) + Math.pow(o.y - this.y, 2.0));
}

private static void getLowestDistance(Point[] array) throws Exception
{
	if (array.length < 2)
	{
		throw new Exception("Array too small!");
	}
	var x = System.nanoTime();
	var lowestDistance = array[0].getDifference(array[1]);
	Point a = array[0];
	Point b = array[1];
	for (int i = 0; i < array.length; i++)
	{
		for (int j = i+1; j < array.length; j++)
		{
			if (array[i].getDifference(array[j]) < lowestDistance)
			{
				lowestDistance = array[i].getDifference(array[j]);
				a = array[i];
				b = array[j];
			}
		}
	}
	System.err.println("BRUTE FORCE: Finished after: " + (System.nanoTime() - x) + " ns" + "\t" + a.toString() + b.toString() + " Diff by: " + a.getDifference(b));
	
	
	
}

public static void fastLowestDistance(Point[] array) throws Exception
{
	Point a = array[0];
	Point b = array[1];
	var x = System.nanoTime();
	var lowestDistance = array[0].getDifference(array[1]);
	for (int i = 0; i < array.length - 1; i++)
		if (array[i].getDifference(array[i+1]) < lowestDistance)
		{
			a = array[i];
			b = array[i+1];
			lowestDistance = array[i].getDifference(array[i+1]);
		}
	System.err.println("FASTALG: Finished after: " + (System.nanoTime() - x) + " ns"  + "\t" + a.toString() + b.toString() + " Diff by: " + a.getDifference(b));
	
	
}

}
