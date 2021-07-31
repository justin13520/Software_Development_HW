import java.util.Scanner;
// Justin Liu: jl8wf
public class OneDArrayActivity {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many values do you want in the array?");
		int x = keyboard.nextInt();
		int[] values = new int[x];
		for(int i = 0; i < x; i++){
			System.out.println("Enter the " + i + " value in the array");
			values[i] = keyboard.nextInt();
		}
		
		for(int j = 0; j < values.length; j++){
			System.out.print(values[j] + " ");
		}
		
		//Input your code here.
		for(int k = 0; k < values.length-1; k++) {
			if(values[k] >= values[k+1]) {
				System.out.println();
				System.out.println("Error, not increasing in value");
				k = values.length;
			}
		}
		
		keyboard.close();
	}

}
