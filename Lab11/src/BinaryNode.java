import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryNode {
	
	private int data;
	private BinaryNode leftChild;
	private BinaryNode rightChild;
	
	public BinaryNode(int data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	//getters and setters
	public int getData() {
		return this.data;
	}
	
	public BinaryNode getLeftChild() {
		return this.leftChild;
	}
	
	public BinaryNode getRightChild() {
		return this.rightChild;
	}
	
	public void setLeftChild(BinaryNode newLeftChild) {
		this.leftChild = newLeftChild;
	}
	
	public void setRightChild(BinaryNode newRightChild) {
		this.rightChild = newRightChild;
	}
	
	/**
	 * Gets the number of leaves in the tree with "this" as root
	 * @return the number of leaves in the tree
	 */
	public int numLeaves() {
		int leftLeaves = 0;
		int rightLeaves = 0;
		if(this.leftChild == null && this.rightChild == null) {
			return 1;
		}
		if(this.rightChild != null){
			rightLeaves += this.rightChild.numLeaves();
		}
		if(this.leftChild != null) {
			leftLeaves += this.leftChild.numLeaves();
		}
		
		return leftLeaves + rightLeaves;
	}
	
//	/**
//	 * Gets the breadth-first search traversal of the tree with "this" as root
//	 * Each node's data should have the format (data) Ex: (5) and (10)
//	 * @return the bfs traversal
//	 */
	public static String breadthFirstSearch(BinaryNode root) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		String bfs = "";
		//put root on queue to start it off
		queue.add(root);
		while(!queue.isEmpty()) {
			bfs +="("+queue.peek().data+")";
			if(queue.peek().leftChild != null) {
				queue.add(queue.peek().leftChild);
			}
			if(queue.peek().rightChild != null) {
				queue.add(queue.peek().rightChild);
			}
			queue.remove(queue.peek());
		}		
		return bfs;
	}
}
