import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



/**
 * Homework 5 Card Creator
 * 
 * This class defines the thread task that will
 * "come up with" and submit greeting card ideas
 * to the print queue.  We have added the code
 * necessary to read from the file, but it's up to
 * you to handle turning off the printer (keeping
 * track of how many threads are open) and adding
 * the read-in line from the inspiration file to
 * the queue.
 * 
 * @author Justin Liu ( jl8wf ) 
 *
 */
public class CardCreator implements Runnable {//CardCreator class that runs the threads
	
	/**
	 * Print queue to add new card ideas
	 */
	private PrintQueue printQueue;
	
	/**
	 * Inspiration file name
	 */
	private String filename;
	
	/**
	 * CardCreator constructor
	 */	
	public static int threadCount = 0;//added this field to know when there is no more things to queue
	
	
	public CardCreator(PrintQueue d, String filename) {
		printQueue = d;
		this.filename = filename;
	}

	/**
	 * Run method that is the main method for the thread
	 */
	@Override
	public void run() {
		threadCount++;//adds a threadcount because each time run is called, a thread is calling it
		Scanner s = null;
		try {
			s = new Scanner(new FileReader(filename));//reads the file to get the lines
			while (s.hasNextLine()) {//makes sure there is a line
				printQueue.enqueue(s.nextLine());//adds the line to queue
				Thread.sleep(1000); //sleeps for a second
			}
		} 
		catch (IOException e) {
			System.out.println("Could not read file");
		} 
		catch (InterruptedException e) {
			System.out.println("Interrupted");
		} 
		finally {
			if (s != null) {//once the scanner is done
				threadCount--;//the thread is done by now
				if(threadCount == 0) {//if there are no more threads left
					printQueue.turnOff();//turns printer off
					System.out.println(threadCount + " threads are left");
				}
				s.close();//closes scanner
			}
		}
	}

}
