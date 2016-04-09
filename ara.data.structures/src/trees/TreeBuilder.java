package trees;

import java.util.ArrayList;
import java.util.Stack;

public class TreeBuilder {
	public static class TreeNode<T>{
		private T data;
		private TreeNode<T> leftNode;
		public T getData() {
			return data;
		}
		public TreeNode<T> getLeftNode() {
			return leftNode;
		}
		public TreeNode<T> getRightNode() {
			return rightNode;
		}
		private TreeNode<T> rightNode;
		public TreeNode(T data, TreeNode<T> leftNode, TreeNode<T> rightNode) {
			super();
//			System.out.println("creating tree node with :" + data);
			this.data = data;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
		public int nodesCount(){
			return 1 + 
					(this.leftNode == null ? 0 : this.leftNode.nodesCount()) +
					(this.rightNode == null ? 0 : this.rightNode.nodesCount());
		}
		
		public int depth(){
			int leftDepth = (this.leftNode == null ? 0 : this.leftNode.depth());
			int rightDepth = (this.rightNode == null ? 0 : this.rightNode.depth());
			return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
		}
		
		public void inOrder(ArrayList<T> result){
			if(this.leftNode != null) this.leftNode.inOrder(result);
			result.add(data);
			if(this.rightNode != null) this.rightNode.inOrder(result);
		}
		
		public void inOrderIterative(ArrayList<T> result){
			Stack<TreeNode<T>> traversalStack = new Stack<>();
			traversalStack.push(this);
			TreeNode<T> currentNode = this.leftNode;
			while (!traversalStack.empty() || currentNode != null){
				if(currentNode != null){
					traversalStack.push(currentNode);
					currentNode = currentNode.leftNode;
				} else {
					currentNode = traversalStack.pop();
					result.add(currentNode.data);
					currentNode = currentNode.rightNode;					
				}
			}
		}
		
		public void preOrder(ArrayList<T> result){
			result.add(data);
			if(this.leftNode != null) this.leftNode.preOrder(result);
			if(this.rightNode != null) this.rightNode.preOrder(result);
		}
		
		public void postOrder(ArrayList<T> result){
			if(this.leftNode != null) this.leftNode.postOrder(result);
			if(this.rightNode != null) this.rightNode.postOrder(result);
			result.add(data);
		}
		
		@Override
		public String toString() {
			return this.data.toString();
		}
	}
	
	public static TreeNode<Integer> buildIntTree(int numberOfNodes){
		if(numberOfNodes <= 0){
			return null;
		}
		int midPoint = numberOfNodes/2;
		return new TreeNode<Integer>(midPoint, buildIntTree(midPoint - 1), buildIntTree(midPoint + 1));
	}
	
	public static TreeNode<Integer> buildIntTreeOfDepth(int depth){
		if(depth <= 0){
			return null;
		}
		return new TreeNode<Integer>(depth, buildIntTreeOfDepth(depth - 1), buildIntTreeOfDepth(depth -1));
	}
}