//Lab 4
//RandomWords.java

import java.util.Random;

public class RandomWords {

	public static void main(String[] args) {
		System.out.println("There are " + getNumCollision(100) + " Collisions");
		System.out.println("There are " + getNumCollision(300) + " Collisions");
		System.out.println("There are " + getNumCollision(500) + " Collisions");
		System.out.println("There are " + getNumCollision(700) + " Collisions");
	}
	public static int hashFunction(String s) {
		int hash = 0;
		for(int i = 0; i < s.length(); i++) {
			hash += ((int)s.charAt(i));
		}
		return hash%500;
	}
	public static int getNumCollision(int words) {
		int collisions = 0;
		String[] hashTable = new String[500];
		String[] randos = generateRandomWords(words);
		for(int i = 0; i < randos.length; i++) {
			int hashIndex = hashFunction(randos[i]);
			while(hashTable[hashIndex] != null) {
				collisions++;
				if(hashIndex < hashTable.length-1) {
					hashIndex++;
				}
				else {
					hashIndex = 0;
				}
			}
			hashTable[hashIndex] = randos[i];
		}
		
		return collisions;
	}

	//A static method that takes in the number or words you would like in your array of 
	//random words.  Each word is between 3 and 10 characters in length and contain only
	//lower case letters.  
	public static String[] generateRandomWords(int numberOfWords)
	{
	    String[] randomStrings = new String[numberOfWords];
	    Random random = new Random();
	    for(int i = 0; i < numberOfWords; i++)
	    {
	        char[] word = new char[random.nextInt(8)+3]; // Words of length 3 through 10. (Because 1 and 2 letter words are boring.)
	        for(int j = 0; j < word.length; j++)
	        {
	            word[j] = (char)('a' + random.nextInt(26));
	        }
	        randomStrings[i] = new String(word);
	    }
	    return randomStrings;
	}
}
