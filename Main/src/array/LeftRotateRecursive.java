package array;

public class LeftRotateRecursive {
	 
	
	static void swap(int arr[], int fi, int si, int d) 
	{ 
	   int i, temp; 
	   for(i = 0; i<d; i++)    
	   { 
	     temp = arr[fi + i]; 
	     arr[fi + i] = arr[si + i]; 
	     arr[si + i] = temp; 
	   }      
	}
	
    /* Function to left rotate arr[] of size n by d */
	static void leftRotate(int arr[], int d, int n)  
	{
		int i, j;
		if (d == 0 || d == n)
			return;
		i = d;
		j = n - d;
		while (i != j) {
			if (i < j) /* A is shorter */
			{
				swap(arr, d - i, d + j - i, i);
				j -= i;
			} else /* B is shorter */
			{
				swap(arr, d - i, d, j);
				i -= j;
			}
			// printArray(arr, 7);
		}
		/* Finally, block swap A and B */
		swap(arr, d - i, d, i);
	}   
  
    /*Function to reverse arr[] from index start to end*/
    static void reverseArray(int arr[], int start, int end) 
    { 
        int temp; 
        while (start < end) 
        { 
            temp = arr[start]; 
            arr[start] = arr[end]; 
            arr[end] = temp; 
            start++; 
            end--; 
        } 
    } 
  
    /*UTILITY FUNCTIONS*/
    /* function to print an array */
    static void printArray(int arr[]) 
    { 
        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " "); 
    } 
  
    /* Driver program to test above functions */
    public static void main (String[] args) 
    { 
        int arr[] = {1, 2, 3, 4, 5, 6, 7}; 
        int n = arr.length; 
        int d = 2; 
  
    // in case the rotating factor is  
    // greater than array length 
        d = d % n;  
        leftRotate(arr, 2, 7);  // Rotate array by d 
        printArray(arr); 
    } 


}
