/**
 * 
 */
package data.structures.trees;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;


/**
 * @author kooknc
 *
 */
public class TreeBuilderTests {
	
	private int depth;
	private TreeBuilder.TreeNode<Integer> depthTree;

	@Before
	public void setUp() throws Exception {
		depth = new Random().nextInt(10);
//		depth = 3;
		System.out.println("Tree depth = " + depth);
		depthTree = TreeBuilder.buildIntTreeOfDepth(depth);
	}

	@Test
	public void testNodesCount() {
		System.out.println("************** tree depth ****************");
		int actualCount = (int)Math.pow(2, depth) - 1;
		int expectedCount = depthTree.nodesCount();
		System.out.println("Tree with depth: " + depth + " has " + expectedCount + " nodes.");
		assertEquals(expectedCount, actualCount);
	}

	@Test
	public void testDepth() {
		assertEquals(depth, depthTree.depth());
	}

	@Test
	public void testInOrder() {
		System.out.println("************** In Order ****************");
		ArrayList<Integer> inorderRecursive = new ArrayList<>();
		depthTree.inOrder(inorderRecursive);
		System.out.println(inorderRecursive.toString());
		
		System.out.println("************** In Order Iterative ****************");
		ArrayList<Integer> inorderIterative = new ArrayList<>();
		depthTree.inOrderIterative(inorderIterative);
		System.out.println(inorderIterative.toString());
		
		assertArrayEquals(inorderRecursive.toArray(new Integer[inorderRecursive.size()]), 
				inorderIterative.toArray(new Integer[inorderIterative.size()]));
		
	}

	@Test
	public void testPreOrder() {
		System.out.println("************** Pre Order ****************");
		ArrayList<Integer> preorderRecursive = new ArrayList<>();
		depthTree.preOrder(preorderRecursive);
		System.out.println(preorderRecursive.toString());
	}

	@Test
	public void testPostOrder() {
		System.out.println("************** Post Order ****************");
		ArrayList<Integer> postorderRecursive = new ArrayList<>();
		depthTree.postOrder(postorderRecursive);
		System.out.println(postorderRecursive.toString());
	}

	@Test
	public void testLevelOrder() {
		System.out.println("************** Level Order ****************");
		ArrayList<Integer> levelOrder = new ArrayList<>();
		depthTree.levelOrder(levelOrder);
		System.out.println(levelOrder.toString());
	}
}