package timertask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

public class TimerTaskEx extends TimerTask {
	static AtomicLong ll = new AtomicLong();
    @Override
    public void run() {
    	long incrementAndGet = ll.incrementAndGet();
        System.out.println(incrementAndGet +"==Timer task started at:"+new Date());
        completeTask();
        System.out.println(incrementAndGet +"==Timer task finished at:"+new Date());
    }

    private void completeTask() {
        try {
            //assuming it takes 20 secs to complete the task
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("");
    }
    
    public static void main(String args[]){
        TimerTask timerTask = new TimerTaskEx();
        TimerTask timerTask1 = new TimerTaskEx1();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 1);
       // Timer timer1 = new Timer(true);
        timer.scheduleAtFixedRate(timerTask1, 0, 1);
        
        
        System.out.println("TimerTask started");
        //cancel after sometime
        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // timer.cancel();
       // System.out.println("TimerTask cancelled");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    
}


class TimerTaskEx1 extends TimerTask {

	@Override
	public void run() {
		long incrementAndGet = TimerTaskEx.ll.incrementAndGet();
       
		
        System.out.println(incrementAndGet +"++Timer task started at:"+new Date());
        try {
            //assuming it takes 20 secs to complete the task
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(incrementAndGet +"++Timer task finished at:"+new Date());
    }
	
}