package sum3;

public class Sum3_bruteForce {
	
public static void main(String[] args)
{
	int[] array = new int[] {30,-40,-20,-10,40,0,10};
	Long startTime = System.nanoTime();
	System.out.println(sum3(array));
	long endTime = System.nanoTime();
	System.out.println("Took "+(endTime - startTime) + " ns");
}

public static int sum3(int[] array)
{
	var count = 0;
	
	for (int i = 0; i < array.length; i++)
		for (int j = i+1; j < array.length; j++)
			for(int k = j+1; k < array.length; k++)
			{
				count = (array[i] + array[k] + array[j]) == 0 ? (++count):count;
			}
	
	return count;
	
}
}
