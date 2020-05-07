package binarySearch;

import java.util.ArrayList;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(42);
		list.add(456);
		list.add(4124);
		list.add(133799);
		list.add(213123312);
		
		System.out.println(binarySearch(list,457));
	}
	
	public static boolean binarySearch(ArrayList<Integer> list, int x)
	{
		int first = 0;
		int last = (list.size() - 1);
		
		while (first <= last)
		{
			int mid = (first + last) / 2;
			if (list.get(mid) == x)
				return true;
			if (list.get(mid) > x)
			{
				last = mid-1;
			}
			if (list.get(mid) < x)
			{
				first = mid+1;
			}
		}
		return false;
	}
}
