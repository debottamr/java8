package sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] example1 = { 10, 7, 25, 20, 12, 9 };
		System.out.println("Unsorted array is : " + Arrays.toString(example1));
		mergeSort(example1);
		System.out.println("Sorted Array is   : " + Arrays.toString(example1));

		System.out.println(7/2);
		int[] example2 = { 5, 4, 3, 2, 1, 0 };
		System.out.println("\nUnsorted array is : " + Arrays.toString(example2));
		mergeSort(example2);
		System.out.println("Sorted Array is   : " + Arrays.toString(example2));
	}

	public static void mergeSort(int[] a) {
		int[] tempArray = new int[a.length];
		sort(a, tempArray, 0, a.length - 1);
	}

	private static void sort(int[] inputArray, int[] tempArray, int left, int right) {
		if (left >= right)
			return;

		int middle = left + (right - left) / 2;
		
		sort(inputArray, tempArray, left, middle);
		sort(inputArray, tempArray, middle + 1, right);
		merge(inputArray, tempArray, left, middle + 1, right);

	}

	private static void merge(int[] finalArray, int[] tempArray, int left, int middle, int secondArrayEnd) {
		int firstArrayEnd = middle - 1;
		int merge = left;
			
		//copy finalArray to tempArray
		while(merge <= secondArrayEnd) {
			tempArray[merge] = finalArray[merge];
			merge++;
		}		
		
		merge = left;
		//merge to finalArray: sorted array
		while (left <= firstArrayEnd && middle <= secondArrayEnd)
			if (tempArray[left] <= tempArray[middle])
				finalArray[merge++] = tempArray[left++];
			else
				finalArray[merge++] = finalArray[middle++];

		//copy remaining element from first half array to finalArray`
		while (left <= firstArrayEnd) // Copy rest of first half
			finalArray[merge++] = tempArray[left++];

		//copy remaining element from second half of array to finalArray
		while (middle <= secondArrayEnd) // Copy rest of right half
			finalArray[merge++] = tempArray[middle++];

	}
}