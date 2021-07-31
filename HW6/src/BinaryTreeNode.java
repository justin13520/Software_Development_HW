import java.util.ArrayList;

/**
 * Binary Tree Node
 * 
 * Tree node that has two children: left and right
 * 
 * @author jl8wf
 * @param <Comparable> The type of data this tree node stores
 */
public class BinaryTreeNode<T extends Comparable<T>> {
	
	/**
	 * Reference pointer to the left subtree
	 */
	private BinaryTreeNode<T> left;
	
	/**
	 * Reference pointer to the right subtree
	 */
	private BinaryTreeNode<T> right;
	
	/**
	 * Data stored at this node
	 */
	private T data;
	
	/**
	 * Default Constructor
	 * 
	 * Creates a binary tree node with null data and null children
	 */
	public BinaryTreeNode(){
		this(null,null,null);
	}
	
	/**
	 * Data-only Constructor
	 * 
	 * Creates a binary tree node with the given data and null children
	 * 
	 * @param theData The data to store at this node
	 */
	public BinaryTreeNode(T theData){
		this(theData,null,null);
	}
	
	
	/**
	 * Full Constructor
	 * 
	 * Creates a binary tree node with the given data and child reference pointers
	 * 
	 * @param theData The data to store at this node
	 * @param leftChild A reference pointer to the left subtree
	 * @param rightChild A reference pointer to the right subtree
	 */
	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}


	/**
	 * Left Child/Subtree getter
	 * 
	 * @return A reference pointer to the root of the left subtree
	 */
	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	/**
	 * Left Child/Subtree Setter
	 * 
	 * @param left A reference pointer to the new left subtree's root node
	 */
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

    /**
     * Right Child/Subtree getter
     * 
     * @return A reference pointer to the root of the right subtree
     */
	public BinaryTreeNode<T> getRight() {
		return right;
	}

    /**
     * Right Child/Subtree Setter
     * 
     * @param left A reference pointer to the new right subtree's root node
     */
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	/**
	 * Get the data at this node
	 * 
	 * @return The data stored at this node
	 */
	public T getData() {
		return data;
	}

	/**
	 * Set the data at this node
	 * 
	 * @param data The data to be stored at this node
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * toString method
	 */
	@Override
	public String toString() {
		if(this.data == null) {
			return null;
		}
	    return "("+this.data.toString()+")";
	}
	
	
	/**
	 * Main method
	 * 
	 * For main method testing, etc
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
	    
	}
	public int size() {
		int size = 0;
		if(this.left == null && this.right == null){
			return 1;
		}
		if(this.left != null) {
			size += this.left.size();
		}
		if(this.right != null) {
			size += this.right.size();
		}
		size += 1;
		return size ;
	}
	public int countRight() {
		int rightSize = 0;
        if(this.right == null && this.left == null){
            return 1;
       	}
        if(this.right != null && this.left != null){
            return this.right.countRight();
        }
        if(this.right != null && this.left == null){
            rightSize += this.right.countRight();
        }
        return rightSize;
    }
	public int height() {
		int leftSide = 1;
		int rightSide = 1;
		if(this.left == null && this.right == null) {
			return 1;
		}
		if(this.left != null) {
			leftSide += this.left.height();
		}
		if(this.right != null) {
			rightSide += this.right.height();
		}
		if(rightSide > leftSide) {
			return rightSide;
		}
		else {
			return leftSide;
		}
	}

	public boolean find(T val) {
		if(this.data.compareTo(val) == 0) {
			return true;
		}
		if(this.data.compareTo(val) > 0) {
			if(this.left == null) {
				return false;
			}
			return this.left.find(val);
			}
		if(this.data.compareTo(val) < 0){
			if(this.right == null) {
				return false;
			}
			return this.right.find(val);
		}
		return false;
	}

	public boolean insert(T val) {//inserts a node of value val, assumes that the tree is not empty
		
		//System.out.println(this.toString());
		
		BinaryTreeNode<T> inserted = new BinaryTreeNode<T>(val);//node of the insert
		
		//The code of the first part is the base case, where it checks leaf nodes
		
		if(this.left == null && this.right == null) {//if the child node was a leaf
			if(this.data.compareTo(val) < 0) {//checks if the root is less than val, if so, puts it on the right side
				this.setRight(inserted);
				return true;
			}
			else if(this.data.compareTo(val) > 0){//else if the root is bigger than val
				this.setLeft(inserted);
				return true;
			}
			else {//if the value of val is the same as the root
				return false;
			}
		}
		
		if(!this.find(val)) {//if the value of val is not in the tree
			
			//These two check if the node has only one child node and the values can be inserted on the empty side
			if(this.data.compareTo(val) > 0 && this.left == null) {
				this.setLeft(inserted);
				return true;
			}
			if(this.data.compareTo(val) < 0 && this.right == null) {
				this.setRight(inserted);
				return true;
			}
			
			if(this.data.compareTo(val) < 0 && this.right.data.compareTo(val) > 0) {//if the current node is smaller than val but the right child is bigger
				if(this.right.getLeft() == null) {//checks to see if the right child's left side is empty
					this.right.setLeft(inserted);
					return true;
				}
				else {//if not, the next node checked is the right child's left node
					return this.right.left.insert(val);
				}
			}
			if(this.data.compareTo(val) > 0 && this.left.data.compareTo(val) < 0) {
				if(this.left.getRight() == null) {
					this.left.setRight(inserted);
					return true;
				}
				else {
					return this.left.right.insert(val);
				}
			}
			if(this.right != null && this.right.data.compareTo(val) < 0) {//if val is smaller than the current node
				return this.right.insert(val);
			}
			if(this.left != null && this.left.data.compareTo(val) > 0) {//if val is bigger than the current node
				return this.left.insert(val);
			}
		}
		
		return false;
	}

	public String inOrder() {
		String inOrder = "";
		if(this.left == null && this.right == null) {
			return this.toString();
		}
		if(this.left != null) {
			inOrder += this.left.inOrder();
		}
		
		inOrder += "("+this.data.toString()+")";
		
		if(this.right != null) {
			inOrder += this.right.inOrder();
		}
		return inOrder;
	}

	public String postOrder() {
		String postOrder = "";
		if(this.left == null && this.right == null) {
			return this.toString();
		}
		if(this.left != null) {
			postOrder += this.left.postOrder();
		}
		if(this.right != null) {
			postOrder += this.right.postOrder();
		}
		postOrder += this.toString();
		return postOrder;
	}

	public boolean buildFromList(ArrayList<T> list) {
		if(this.data == null) {
			this.setData(list.get(0));
			for(int i = 1; i < list.size(); i++) {
				if(list.get(i) == null && i != list.size()-1) {
					i++;
				}
				this.insert(list.get(i));
			}
			return true;
		}
		
		if(this.data != null) {
			this.data = null;
			return this.buildFromList(list);
		}
		return false;
	}
}
