
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
   Counts how many words in a file.
 */
public class WordCountRunnable implements Runnable{
    private String filename;

    /**
      Constructs a WordCountRunnable object with a file name.
      @param aFilename the file name that needs to count words
     */
    public WordCountRunnable(String aFilename) {
        filename = aFilename;
    }

    public void run() {
        //add your code here:
    	int count = 0;
    	Scanner scnr;
    	try {
    		scnr = new Scanner(new FileInputStream(filename));
    		while(scnr.hasNext()) {
    			scnr.next();
    			count++;
    			
    		}
    		scnr.close();
    	}
    	catch(FileNotFoundException f) {
    		System.out.println("File not found.");
    	}
		System.out.println(filename +": "+count);
        // hints:
        // initialize a counter
        // create Scanner - can use, ... new Scanner(new FileInputStream(filename))
        // don't forget try-catch	  
        // while loop 
        //      count individual words
        // what are you going to catch??
        // print statement of the format:  filename: wordCount
    }
}