import java.util.Arrays;

public class Main1 {

	public static void main(String[] args) {
		int arr1[] = {2, 1, 4, 3, 6, 5, 8, 7 };
		/*int arr2[] = {2, 4, 1, 3, 5, 7, 6, 8};
		int arr3[] =   {1, 2, 3, 4, 5, 6, 7, 8};
		int arr4[] = {2, 4, 6, 7, 1, 3, 5, 8};
		int arr5[] = {2, 4, 6, 7, 5, 8, 1, 3 };
		
		int arr11[] = {2, 4, 6, 8 ,1, 3, 5, 7};
		int arr12[] = {1, 3,2, 4,  5, 7, 6, 8};
		int arr13[] =   {2, 1, 4, 3, 6, 5, 8, 7};
		int arr14[] = {1, 3, 5, 8, 2, 4, 6, 7 };
		*/
		
	test(arr1);
		/*test(arr2);
		test(arr3);
		test(arr4);
		test(arr5);
		
		test(arr11);
		test(arr12);
		test(arr13);
		test(arr14);*/
	}

	private static void test(int[] arr) {
		int lastIndex = arr[0] % 2 == arr[arr.length - 1] % 2 ? arr.length / 2 : arr.length - 1;
		int incrementer = arr[0] % 2 == arr[arr.length - 1] % 2 ? 1 : -1;
		for (int count = 0; count < arr.length; count++) {
			if (count < arr.length / 2) {
				if (arr[count] % 2 != arr[0] % 2 && arr[0] % 2 == arr[lastIndex] % 2) {
					int temp = arr[count];
					arr[count] = arr[lastIndex];
					arr[lastIndex] = temp;
				}
				if (arr[0] % 2 != arr[lastIndex] % 2) {
					lastIndex = lastIndex + incrementer;
				}
			} else {
				if (count % 2 != arr[count] % 2) {
					int temp = arr[count];
					arr[count] = arr[arr.length - count - 1];
					arr[arr.length - count - 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	static void main1(String[] args) {
		int arr[] = { 1, 3, 5, 7 , 2, 4, 6, 8};
		for (int count = 0; count < arr.length ; count++) {
			if(count %2 == 0 && arr[count]%2 !=0 ){
				for (int innercount= count ; innercount < arr.length ; innercount++) {
					if( arr[innercount]%2 ==0){
						int temp = arr[count];
						arr[count] = arr[innercount];
						arr[innercount]= temp;
						break;
					}
					
				}
			}else if(count %2 != 0 && arr[count]%2 ==0 ){
				for (int innercount= count ; innercount < arr.length ; innercount++) {
					if( arr[innercount]%2 !=0){
						int temp = arr[count];
						arr[count] = arr[innercount];
						arr[innercount]= temp;
						break;
					}
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
