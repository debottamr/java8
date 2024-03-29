package problem;

public class MissingNumber {

	
	 static int getMissingNo1 (int a[], int n) 
	    { 
	        int i, total; 
	        total  = (n+1)*(n+2)/2;    
	        for ( i = 0; i< n; i++) 
	           total -= a[i]; 
	        return total; 
	    } 
	 static int getMissingNo (int a[], int n) 
	    { 
	        int x1 = a[0];  
	        int x2 = 1;  
	          
	        /* For xor of all the elements  
	           in array */
	        for (int i = 1; i < n; i++) 
	            x1 = x1 ^ a[i]; 
	                  
	        /* For xor of all the elements  
	           from 1 to n+1 */         
	        for (int i = 2; i <= n+1; i++) 
	            x2 = x2 ^ i;          
	          
	        return (x1 ^ x2); 
	    } 
	public static void main(String args[]) 
    { 
        int a[] = {1,2,4,5,6}; 
        int miss = getMissingNo(a,5);
        int miss1 = getMissingNo1(a,5); 
        System.out.println(miss);
        System.out.println(miss1);
    } 
}
