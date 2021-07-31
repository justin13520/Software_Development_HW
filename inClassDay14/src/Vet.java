/**
 * 
 * @author CS 2110 Faculty
 * Vet class, where all domesticated animals must visit
 *
 */
public class Vet {

	// TODO The following method is incomplete; you need to fix it to:
	// a) take an animal argument and b) have the animal make its noise
	public static void giveShot(Animal a) {
		// do horrible things to the animal
		System.out.println(" after the shot cried " + a.makeNoise());

	}
	
	public static void main(String[] args) {
		Animal a = new Dog("Jack");
		String aType = String.valueOf(a.getClass()).substring(6);
		Animal b = new Cat("Garfield");
		String bType = String.valueOf(b.getClass()).substring(6);
		Animal c = new Animal("Marlow");
		String cType = String.valueOf(c.getClass()).substring(6);
		// TODO Complete the rest of the code to print the following output:
		// > Dog Jack after the shot cried Woof!
		// > Cat Garfield after the shot cried Miaw!
		// > Animal Marlow after the shot cried ...
		System.out.print(aType + " " + a.name);
		giveShot(a);
		System.out.print(bType + " " + b.name);
		giveShot(b);
		System.out.print(cType + " " + c.name);
		giveShot(c);
	}

}
