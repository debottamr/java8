package array.mostrecent;

public class MostRecentlyUsed {
	static void mostRecentlyUsedApps(int[] arr, int N, int K) {
		int app_index = 0;

		// Finding the end index after K presses
		app_index = (K % N);

		// Shifting elements by 1 towards the found index
		// on which the K press ends
		int x = app_index, app_id = arr[app_index];
		while (x > 0) {
			arr[x] = arr[--x];
		}

		// Update the current active app
		arr[0] = app_id;
	}

	// Utility function to print
	// the contents of the array
	static void printArray(int[] arr, int N) {
		for (int i = 0; i < N; i++)
			System.out.println(arr[i] + " ");
	}

	// Driver code
	public static void main(String args[]) {
		int K = 3;
		int[] arr = { 3, 5, 2, 4, 1 };
		int N = arr.length;

		mostRecentlyUsedApps(arr, N, K);
		printArray(arr, N);
	}
}
