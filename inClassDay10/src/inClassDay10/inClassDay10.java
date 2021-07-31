package inClassDay10;

import java.util.HashSet;

public class inClassDay10 {

	public static void main(String[] args) {
		//two HashSets to put into method names
		HashSet<String> myCards = new HashSet<String>();
		HashSet<String> topN = new HashSet<String>();
		//setting the names already written
		myCards.add("Dog1");
		myCards.add("George");
		myCards.add("Winter");
		myCards.add("Hinata");
		//setting names that are in the book
		topN.add("Dog1");
		topN.add("Dog2");
		topN.add("Dog3");
		topN.add("Dog4");
		//printing out to see if they were added correctly
		System.out.println(topN);
		System.out.println(myCards);
		//prints out the cards that need to be written
		System.out.println(names(myCards,topN));
		

	}
	public static HashSet<String> names(HashSet<String> cards, HashSet<String> topNames){
		HashSet<String> newCards = new HashSet<String>();
			for(String s1 : topNames) {
				if(!cards.contains(s1)) {
					//if cards does not contain s1, then it will add
					System.out.println(s1);
					newCards.add(s1);
				}
			}
		return newCards;
	}
}
