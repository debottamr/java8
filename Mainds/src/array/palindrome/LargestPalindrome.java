package array.palindrome;
/*
 
    Sort the array in ascending order.
    Start traversing the array from the end.
    The first number which is a palindrome is the required answer.
    If no palindromic number is found then print -1

 */
public class LargestPalindrome {
	// Function to check if n is palindrome
	static boolean isPalindrome(int n) {
		// Find the appropriate divisor
		// to extract the leading digit
		int divisor = 1;
		while (n / divisor >= 10)
			divisor *= 10;

		while (n != 0) {
			int leading = n / divisor;
			int trailing = n % 10;

			// If first and last digits are
			// not same then return false
			if (leading != trailing)
				return false;

			// Removing the leading and trailing
			// digits from the number
			n = (n % divisor) / 10;

			// Reducing divisor by a factor
			// of 2 as 2 digits are dropped
			divisor = divisor / 100;
		}
		return true;
	}

	// Function to find the largest palindromic number
	static int largestPalindrome(int[] A, int n) {
		int currentMax = -1;

		for (int i = 0; i < n; i++) {

			// If a palindrome larger than the currentMax is found
			if (A[i] > currentMax && isPalindrome(A[i]))
				currentMax = A[i];
		}

		// Return the largest palindromic number from the array
		return currentMax;
	}

	// Driver program
	public static void main(String[] args) {
		int[] A = { 1, 232, 54545, 999991 };
		int n = A.length;

		// print required answer
		System.out.println(largestPalindrome(A, n));

	}
}
