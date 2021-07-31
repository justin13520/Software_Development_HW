import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Binary Search Tree Class
 * 
 * The head class for a binary search tree implementation.
 * 
 * @author jl8wf
 * @param <Comparable> Type of data to store in the binary tree
 */
public class BinarySearchTree<T extends Comparable<T>> {

	/**
	 * A reference pointer to the root of the tree
	 */
	private BinaryTreeNode<T> root;

	/**
	 * Default constructor
	 * 
	 * Creates a binary tree object with null root note (empty tree)
	 */
	public BinarySearchTree() {
		this(null);
	}

	/**
	 * Constructor
	 * 
	 * Creates a binary tree object with the given node as root
	 * 
	 * @param newRoot The root of the tree
	 */
	public BinarySearchTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}
	
	/**
	 * Get the root of the tree
	 * 
	 * @return The root of the tree
	 */
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * Set the root of the tree
	 * 
	 * @param root  The new root of this tree
	 */
	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}
	
	
	/**
	 * Returns the size of the tree (that is, the 
	 * number of nodes in the tree). 
	 *
	 */
	public int size() {
		if(root == null) {
			return 0;
		}
		return root.size();
	}
	
	/**
	 * Returns the height of the tree. 
	 *
	 */
	public int height() {
		if(root == null) {
			return 0;
		}
		return root.height();
	}
	
	/**
	 * Find if an element exists
	 * 
	 * Checks to see if the value val appears in the
	 * tree (recursively).  Returns true if it appears
	 * and false otherwise.
	 * 
	 * @param val The value to find
	 * @return True if the tree contains the value, false otherwise
	 */
	public boolean find(T val) {
	    if(root == null) {
	    	return false;
	    }
	    return root.find(val);
	}
	
	/**
	 * Insert an element
	 * 
	 * Inserts val into the tree where it should appear, returning
	 * true on success and false otherwise
	 * 
	 * @param val The value to insert
	 * @return True on success, false otherwise
	 */
	public boolean insert(T val) {
		if(root == null) {
			root = new BinaryTreeNode<T>(val);
	    	return true;
	    }
		return root.insert(val);
	}
	
	/**
	 * Return a string that represents the data held at each 
	 * node following the rules of an in-order traversal.
	 * 
	 * Covered in class Wednesday, April 22
	 */
	public String inOrder() {
		if(root == null) {
			return null;
		}
		return root.inOrder();
	}
	
	/**
	 * Return a string that represents the data held at each 
	 * node following the rules of a post-order traversal.
	 * 
	 * Covered in class Wednesday, April 22
	 */
	public String postOrder() {
		if(root == null) {
			return null;
		}
		return root.postOrder();
	}

	/**
	 * Build from a list
	 * 
	 * Build the tree from the given list, overwriting any tree data
	 * previously stored in this tree.  Should read from beginning to
	 * end of the list and repeatedly call insert() to build the tree
	 * 
	 * If the tree is not empty when this method is called, you should
	 * empty the tree before adding any elements in list.
	 *
	 * @param list The list from which to build the tree
	 * @return True if successfully built, false otherwise
	 */
	public boolean buildFromList(ArrayList<T> list) {
		if(list.size() == 0) {
    		root = null;
    		BinarySearchTree<T> empty = new BinarySearchTree<T>(root);
    		return true;
    	}
		
	    if(root == null) {
	    	root = new BinaryTreeNode<T>(list.get(0));
	    	return root.buildFromList(list);
	    }
	    
	    return root.buildFromList(list);
	}
	
    /**
     * toString method
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        if(root == null) {
        	return null;
        }
        return root.inOrder();
    }
    public int countRight() {

        if (root == null) { // the tree is empty...

            return 0; // there are no nodes, so the count is zero (0)

        } else {

            // call countRight() on the root of the tree

            return root.countRight();

        }       

    }
	/**
	 * Main method
	 * 
	 * For testing, etc
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(3);
		list.add(9);
		list.add(2);
		list.add(5);
		list.add(1);
		list.add(4);
		list.add(6);
		list.add(8);
		list.add(10);
		tree.buildFromList(list);
		System.out.println(tree.countRight());
	}
}
