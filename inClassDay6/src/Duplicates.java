import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Duplicates {

	public static void main(String[] args) {
		ArrayList<String> inputList = new ArrayList<String>();
		
		
		Scanner key = new Scanner(System.in);
		System.out.println("How many Strings would you like to enter?");
		int num = key.nextInt();
		key.nextLine();

		
		String str;
		for(int i = 0; i < num; i++) {
			System.out.println("What String would you like to add?");
			str = key.nextLine();
			inputList.add(str);
			
		}
		
		
		System.out.println(inputList);
		System.out.println(removeDups(inputList));
		//comment out above and uncomment below if you want to try the array bonus
		//System.out.println(Arrays.toString(inputList));
		//System.out.println(Arrays.toString(removeDups(inputList)));
		
	}
	
	public static ArrayList<String> removeDups(ArrayList<String> al) {
		ArrayList<String> removed = new ArrayList<String>();
		for(int i = 0; i < al.size(); i++) {
			removed.add(al.get(i));
		}
		for(int k = 0; k < removed.size(); k++) {
			for(int j = k+1; j < removed.size(); j++) {
				System.out.println(removed.get(k));
				System.out.println(removed.get(j));
				if(removed.get(k).equals(removed.get(j))) {
					removed.remove(j);
					j--;
				}
			}
		}
		return removed;
	}
	
}