package laplaceDice;

public class LaPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(throwTheDice());
	}
	
	public static double throwTheDice()
	{
		int counter = 0;
		int amountOfThrows = 1000000;
		for (int i = 0; i < amountOfThrows; i++)
		{
			int y1 = (int)(Math.random()*6)+1;
			int y2 = (int)(Math.random()*6)+1;
			int y3 = (int)(Math.random()*6)+1;
		
			if ((y1 == 1 && y2 != 1 && y3 != 1) || (y1 != 1 && y2 == 1 && y3 != 1) || (y1 != 1 && y2 != 1 && y3 == 1))
			{
				counter++;
			}
			System.out.println(counter);
		}
		
		return ((double)counter / amountOfThrows);
	}
	

}
