import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Homework 5 PrintQueue
 * 
 * Implement the class below as specified in the
 * homework 5 document.
 * 
 * @author Justin Liu ( jl8wf ) 
 *
 */
 
// Don't forget to include the appropriate import statements
 
public class PrintQueue {//PrinterQueue class to queue the printer
    
	private LinkedList<String> toPrint;     // the printer's list of documents
	private Lock documentChangeLock;  // a ReentrantLock lock
	private Condition hasPrintTask;   // a condition object
	private boolean isOn;             // boolean variable describing if the 
                                      // queue is on (accepting jobs)

	//TODO:  Handle locking and conditions around the
    //       enqueueing and dequeuing of documents
    //       in this PrintQueue's document list (toPrint)
    //       Note: See example in the zip folder 'Thread Example 6 - Bank Deadlock' 


    /**
     * Constructor
     */
    public PrintQueue() {//constructor
        toPrint = new LinkedList<String>(); // create the list of documents
        isOn = true; // turn on the print queue
        documentChangeLock = new ReentrantLock();
        hasPrintTask = documentChangeLock.newCondition();
    }


    /**
     * dequeue
     * TODO: Write more comments
     */
    public String dequeue() {
    	documentChangeLock.lock();
        // This seems dangerous! Something needs to change here...!
		// Hint: Only remove an item from the queue if it's not empty, 
		//       and do not dequeue if the queue is empty, but wait if the queue is on.
		// Implement this method
    	while(toPrint.isEmpty() && isOn) {//if its empty and on, then itll wait to something to enqueue
    		try {
				hasPrintTask.await();//waiting to get enqueued
				
			} 
    		catch (InterruptedException e) {
				System.out.println("Interrupted in dequeue");
			}
    	}
    	if(isOn != true) {//if the printer is not on, itll return nothing to dequeue
    		documentChangeLock.unlock();
    		return null;
    	}
    	else {
    		documentChangeLock.unlock();
    		return toPrint.remove(); // return the first document
    	}
    }


    /**
     * enqueue
     * TODO: Write more comments
     */
    public void enqueue(String s) {
    	documentChangeLock.lock();//locks it so that only the thread that is adding is active
        toPrint.add(s); // add to the list of documents
        hasPrintTask.signalAll();//signals if the printer queue was empty
        documentChangeLock.unlock();//unlocks so the printer can dequeue
    }

    /**
     * turnOff
     * TODO: Write more comments
     */
    public void turnOff() {//turns printer off when at the end there is no more cards to print
    	documentChangeLock.lock();//locks so that only this thread is active
		isOn = false;//sets on to off
		hasPrintTask.signalAll();//signals dequeue that the printer is off, which will then return null
		documentChangeLock.unlock();
	}
	
    
    /**
     * isOn
     * TODO: Write more comments
     */
    public boolean isOn() {//turns printer on
		return isOn;
	}	
    
}
