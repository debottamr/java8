package blockqueue;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockQue {
	public static void main(String[] args) {
		int capacity = 15;

		// create object of PriorityBlockingQueue
		PriorityBlockingQueue<Integer> pbq = new PriorityBlockingQueue<Integer>(capacity);

		// add numbers
		pbq.add(1);
		pbq.add(2);
		pbq.add(3);

		// print queue
		System.out.println("PriorityBlockingQueue:" + pbq);

		pbq = new PriorityBlockingQueue<Integer>(capacity, Comparator.reverseOrder());

		// add numbers
		pbq.add(1);
		pbq.add(2);
		pbq.add(3);

		// print queue
		System.out.println("PriorityBlockingQueue:" + pbq);

		pbq = new PriorityBlockingQueue<Integer>();

		// add numbers
		pbq.add(12);
		pbq.add(1);
		pbq.add(2);
		pbq.add(3);
		pbq.add(4);
		pbq.add(5);
		pbq.add(6);
		pbq.add(7);
		pbq.add(8);
		pbq.add(9);
		pbq.add(10);
		pbq.add(11);
		
		System.out.println("PriorityBlockingQueue:" + pbq);
	}
}
