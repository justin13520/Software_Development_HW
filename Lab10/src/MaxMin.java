import java.util.Arrays;

// LAB 9: Recursion, Pt. 1
//In collaboration with Parth Raut, plr6uqx

public class MaxMin {
	
	public static void main(String[] args) 
	{
		int[] values = {19, 12, 13, 14, 17, 18, 16, 11, 14};
		int[] maxMinResults = maxMin(values);
		System.out.println(maxMinResults[0] + " and " + maxMinResults[1]);
		
		int[] val = {1,2,1,1,1};
		int[] maxMinResults1 = maxMin(val);
		System.out.println(maxMinResults1[0] + " and " + maxMinResults1[1]);
	}
	
	/*  maxMin() - Return an array containing the minimum and maximum values of the input array.
	 * 	@param list: an array of ints as input
	 * 	
	 * 	Use the helper function to perform the recursion with the additional parameters
	 * 	
	 * 	@return: an int array, one index is minimum and the other is the maximum value.
	 */
	public static int[] maxMin(int[] list) {
		return maxMinHelper(list, 0, list.length-1);
	}

	/*  maxMinHelper() - Helper function for the maxMin function.
	 * 	@param list: an array of ints as input
	 * 	@param first: the first index of the list (for recursion)
	 * 	@param last: the last index of the list (for recursion)
	 * 	
	 * 	Identify a base case, and work it out so that the array returns the min and max values.
	 * 	Then, identify what the method does to recursively arrive at the base case.
	 * 	
	 * 	@return: an int array, one index is minimum and the other is the maximum value.
	 */
	
	public static int[] maxMinHelper(int[] list, int first, int last){
		if(first == last) {
			int[] a = {list[first],list[last]};
			return a;
		}
		int mid = first+(last-first)/2;
		int[] left = maxMinHelper(list, first, mid);
		int[] right = maxMinHelper(list, mid+1, last);
		int min = Math.min(left[0], right[0]);
		int max = Math.max(left[1], right[1]);
		int[] a = {min,max};
		return a;
		
		
	}
}
