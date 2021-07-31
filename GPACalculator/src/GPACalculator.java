import java.util.*;
public class GPACalculator {

	private double total;
	private double cred;
	private ArrayList<String> courses;

	
	public static void main(String args[]) {
		GPACalculator gpa = new GPACalculator();
		gpa.addCourse("Theory of Computation",4, 3.3);
		gpa.addCourse("Programing & Data Structures",4, 2.0);
		gpa.addCourse("Linear Algebra",3, 4.0);
		System.out.println("This is the amount of credit you are taking right now: " + gpa.cred);
		gpa.printCourses();
		System.out.println("Your GPA is: " + gpa.gpa());
		
	}
	public GPACalculator() {
		this.total = 0;
		this.cred = 0;
		this.courses = new ArrayList<String>();
	}
	
	public double gpa() {
		return this.total/this.cred;
	}
	public void addCourse(String courseName,double credits,double grade) {
		this.cred += credits;
		this.total += credits*grade;
		this.courses.add(courseName);
	}
	public void printCourses() {
		System.out.print("The courses that you are taking is/are: ");
		for(int i = 0; i < this.courses.size(); i++) {
			if(i == this.courses.size()-1) {
				System.out.println(this.courses.get(i)+ ".");
			}
			else {
				System.out.print(this.courses.get(i) + ", ");
			}
		}
	}
}
