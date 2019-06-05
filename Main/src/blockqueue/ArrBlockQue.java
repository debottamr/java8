package blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrBlockQue {
	public static void main(String[] args) throws InterruptedException 
    { 
        // define capacity of ArrayBlockingQueue 
        int capacity = 3; 
  
        // create object of ArrayBlockingQueue 
        ArrayBlockingQueue<Integer> abq 
            = new ArrayBlockingQueue<Integer>(capacity); 
  
        // add  numbers 
        abq.add(1); 
        abq.add(2); 
        abq.add(3); 
        
        boolean offer = abq.offer(4);
        System.out.println(offer);
        
        boolean offer1 = abq.offer(4, 1, TimeUnit.SECONDS);
        System.out.println(offer);
        System.out.println(offer1);
        //generates Exception
        abq.add(4); 
  
        // print queue 
        System.out.println("ArrayBlockingQueue:"
                           + abq); 
  
        // remove all the elements 
        abq.clear(); 
  
        // print queue 
        System.out.println("ArrayBlockingQueue:"
                           + abq); 
    } 
}
