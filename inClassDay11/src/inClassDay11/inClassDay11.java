package inClassDay11;

import java.util.TreeMap;

public class inClassDay11 {

	public static void main(String[] args) {
		TreeMap<String,Integer> a = new TreeMap<String, Integer>();
		//random names and numbers
		a.put("Justin",5);
		a.put("Edward",4);
		a.put("parth",3);
		/*prints the "phonebook" to see if the values are reversed
		*/
		System.out.println(a);
		//prints the results to see if the values were switched with the keys
		System.out.println(reverseBook(a));
	}
	public static TreeMap<Integer, String> reverseBook(TreeMap<String,Integer> phoneBook){
		TreeMap<Integer, String> rPhoneBook = new TreeMap<Integer, String>();
		for(String i: phoneBook.keySet()) {
			//puts the values in the place of the key in TreeMap rPhoneBook and key in values
			rPhoneBook.put(phoneBook.get(i),i);
		}
		return rPhoneBook;
	}
}
