import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Lab1Scanner {

	public static void main(String[] args) throws FileNotFoundException{
//		Scanner input = new Scanner(System.in);
//		double total = 0;
//		for(int i = 0; i < 5; i++) {
//			System.out.println("Please enter a number:");
//			double t = input.nextDouble();
//			total+=t;
//		}
//		System.out.println(total/5);
		
		File file = new File("data1.txt");
		Scanner scnr = new Scanner(file);
		while(scnr.hasNext()) {
			System.out.println(scnr.nextLine());
		}
		//System.out.println(file.length());
		//System.out.println(file.getAbsolutePath());
		activity4();
		}
	public static boolean isInteger(String str) {
		try {
			int j = Integer.parseInt(str);
			return true;
		}
		catch (NumberFormatException e){
			return false;
		}
	}
	public static void activity4() throws FileNotFoundException {
		File file2 = new File("data2.txt");
		Scanner scnr2 = new Scanner(file2);
		int total = 0;
		while(scnr2.hasNext()) {
			String str = scnr2.next();
			for(int j = 0; j < str.length(); j++) {
				if(isInteger(str.charAt(j)+"")) {
					total+= Integer.parseInt(str.charAt(j)+"");
				}
			}
		}
		System.out.println(total);
	}
	}
