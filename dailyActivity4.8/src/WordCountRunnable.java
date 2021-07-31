import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
   Counts how many words in a file -- SOLUTION to Concurrency In-Class Activity (DAY 1)  
   STARTER CODE for Concurrency In-Class Activity DAY 2
*/
public class WordCountRunnable implements Runnable{
	
   private String filename;
   private Lock threadCountLock;
   private Lock combinedWordCountLock;
   public static int threadCount;
   public static int combinedWordCount;
   /**
      Constructs a WordCountRunnable object with a file name.
      @param aFilename the file name that needs to count word
   */
   public WordCountRunnable(String aFilename)
   {
      filename = aFilename;
      threadCountLock = new ReentrantLock();
      combinedWordCountLock = new ReentrantLock();
   }

   public void run(){
	threadCountLock.lock();
	combinedWordCountLock.lock();
	int count = 0;
      try
      {
         Scanner in = new Scanner(new FileInputStream(filename)); // use Scanner to read the file (filename)

         while (in.hasNext()) // while there are more tokens (words)
         {
            in.next(); // consume the word (to be able to progress through the file)
            count++;   // count the number of words
         }
         in.close();   // close the scanner (important!)
      } 
      catch (FileNotFoundException e)
      {
         System.out.println(filename + " not found!");
      }
      finally {
    	  threadCountLock.unlock();
    	  combinedWordCountLock.unlock();
      }
      System.out.println(filename + ": " + count); // print the total number of words in the file
      combinedWordCount += count;
      WordCountRunnable.threadCount--; 
      System.out.println("Total threads running: "+threadCount);
      if(threadCount == 0) {
    	  System.out.println("Total words: "+combinedWordCount);
      }
   }
}
