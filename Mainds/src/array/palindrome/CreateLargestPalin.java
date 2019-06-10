package array.palindrome;

/*
 If n < 3, then num itself is the largest possible palindromic number. 
 Else calculate mid = (n / 2) – 1. 
 Then create an array rightMax[] of size (mid + 1). 
 rightMax[i] contains the index of the greatest digit which is on the right side of num[i] 
 and also greater than num[i] and 0 <= i <= mid. 
 If no such digit exists then rightMax[i] = -1. 
 Now, traverse the rightMax[] array from i = 0 to m, and find the first element having rightMax[i] != -1. 
 Perform the swap(num[i], num[rightMax[i]]) and swap(num[n – i – 1], num[n – rightMax[i] – 1]) operations and break.
 */


//Form the largest palindromic number using atmost two swaps
public class CreateLargestPalin {
	static void largestPalin(char num[], int n) {
		// if length of number is less than '3'
		// then no higher palindromic number
		// can be formed
		if (n <= 3)
			return;

		// find the index of last digit
		// in the 1st half of 'num'
		int mid = n / 2 - 1;

		int[] rightMax = new int[mid + 1];
		int right;

		// as only the first half of 'num[]' is
		// being considered, therefore
		// for the rightmost digit in the first half
		// of 'num[]', there will be no greater right digit
		rightMax[mid] = -1;

		// index of the greatest right digit till the
		// current index from the right direction
		right = mid;

		// traverse the array from second right element
		// in the first half of 'num[]' up to the
		// left element
		for (int i = mid - 1; i >= 0; i--) {

			// if 'num[i]' is less than the greatest digit
			// encountered so far
			if (num[i] < num[right])
				rightMax[i] = right;

			else {

				// there is no greater right digit
				// for 'num[i]'
				rightMax[i] = -1;

				// update 'right' index
				right = i;
			}
		}

		// traverse the 'rightMax[]' array from left to right
		for (int i = 0; i <= mid; i++) {

			// if for the current digit, greater right digit exists
			// then swap it with its greater right digit and also
			// perform the required swap operation in the right halft
			// of 'num[]' to maintain palindromic property, then break
			if (rightMax[i] != -1) {

				// performing the required swap operations
				swap(num, i, rightMax[i]);
				swap(num, n - i - 1, n - rightMax[i] - 1);
				break;
			}
		}
	}

	static char[] swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

	// Driver code
	public static void main(String[] args) {
		char num[] = "4697557964".toCharArray();
		int n = num.length;
		largestPalin(num, n);

		// required largest palindromic number
		System.out.println("Largest Palindrome: " + String.valueOf(num));
	}

}
