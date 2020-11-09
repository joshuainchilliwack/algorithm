
import java.util.HashSet;
import java.util.Set;

public class SumWithPair {

	public static void main(String[] args) {

		// assumptions:

		// input array1 [2,6,7,8,12 ], array2 [3,5,6,7,9] , sum : 20
		// arrays are not sorted
		// return true/false
		// time complexity is the most important
		// assume no negative numbers for each element, and sum
		// no duplicate numbers for pair

		// go through the array , check if the element is in the set then return true
		// or put that element's complement in the set

		int[] arr1 = { 2, 6, 7, 8, 12 };
		int[] arr2 = { 3, 5, 6, 7, 9 };

		System.out.println(hasPairWithSum(arr1, 20)); // return true
		System.out.println(hasPairWithSum(arr2, 20)); // return false
	}

	private static boolean hasPairWithSum(int[] array, int sum) {

		Set<Integer> complementSet = new HashSet<>();

		for (int i = 0; i < array.length; i++) {

			if (complementSet.contains(array[i])) {
				return true;
			}
			int complement = sum - array[i];
			if (complement <= 0) {
				continue;
			}
			complementSet.add(complement);
		}
		return false;
	}
}
