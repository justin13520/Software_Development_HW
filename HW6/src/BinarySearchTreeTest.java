import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

	@Test(timeout=100)
	public void testSize() {
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
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(7);
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<Integer>(root);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(9);
		list2.add(2);
		list2.add(5);
		list2.add(1);
		list2.add(4);
		list2.add(6);
		list2.add(8);
		list2.add(10);
		tree2.buildFromList(list2);
		
		assertTrue(tree.size() == 10);
		assertTrue(tree.size() == 10);
	}
	
	public void testSizeWhenSizeIsZero() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		assertTrue(tree.size() == 0);
	}
	@Test(timeout=100)
	public void testHeight() {
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
		assertTrue(tree.height() == 4);
	}
	
	public void testHeightIsZero() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		assertTrue(tree.height() == 0);
	}
	
	@Test(timeout=100)
	public void testFindTrueCases() {
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
		assertTrue(tree.find(5));
		assertTrue(tree.find(8));
	}
	
	public void testFindFalseCases() {
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
		assertFalse(tree.find(11));
	}
	
	@Test(timeout=100)
	public void testInsert() {
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
		tree.insert(11);
		assertTrue(tree.find(11));
		assertEquals(tree.inOrder(),"(1)(2)(3)(4)(5)(6)(7)(8)(9)(10)(11)");
	}
	
	@Test(timeout=100)
	public void testInsertWhenItIsAlreadyThere() {
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
		assertFalse(tree.insert(10));
	}
	
	@Test(timeout=100)
	public void testInOrder() {
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
		assertTrue(tree.inOrder().equals("(1)(2)(3)(4)(5)(6)(7)(8)(9)(10)"));
	}
	
	@Test(timeout=100)
	public void testPostOrder() {
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
		assertTrue(tree.postOrder().equals("(1)(2)(4)(6)(5)(3)(8)(10)(9)(7)"));
	}
	@Test(timeout=100)
	public void testToString() {
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
	}
	@Test(timeout=100)
	public void testBuildFromList() {
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
		
		assertTrue(tree.inOrder().equals("(1)(2)(3)(4)(5)(6)(7)(8)(9)(10)"));
		assertTrue(tree.postOrder().equals("(1)(2)(4)(6)(5)(3)(8)(10)(9)(7)"));
	}
	
	@Test(timeout=100)
	public void testBuildFromEmptyList() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		assertTrue(tree.size() == 0);
	}
}
