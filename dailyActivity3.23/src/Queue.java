/*
Name: Justin Liu
Computing ID: jl8wf

*/


public class Queue {

	final int INITIAL_SIZE = 10;
	String[] elements;
	int currentSize, head, tail;
	
	public Queue(){
		this.elements = new String[this.INITIAL_SIZE];
		this.currentSize = this.head = this.tail = 0;
	}
	
	public void add(String s){
		growIfNecessary();
		this.elements[tail] = s;
		tail = (tail+1)%elements.length;
	}
	
	public String remove(){
		if(this.elements.length == 0) {
			return null;
		}
		String removed = this.elements[head];
		this.elements[head] = null;
		head = (head +1) % elements.length;
		currentSize--;
		return removed;
	}
	
	private void growIfNecessary(){
		if(currentSize == elements.length){
			String[] newElements = new String[2*elements.length];
			for(int i = 0; i < elements.length; i++){
				newElements[i] = elements[(head+i)%elements.length];
			}
			elements = newElements;
			head = 0;
			tail = currentSize;
		}
	}
	
	public static void main(String[] args) {
        Queue a = new Queue();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        a.add("e");
        System.out.println(java.util.Arrays.toString(a.elements));
	}

}
