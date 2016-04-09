package trees;

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
		
		public void inOrder(){
			if(this.leftNode != null) this.leftNode.inOrder();
			System.out.print(this.data + "\t");
			if(this.rightNode != null) this.rightNode.inOrder();
		}
		
		public void inOrderIterative(){
			
		}
		
		public void preOrder(){
			System.out.print(this.data + "\t");
			if(this.leftNode != null) this.leftNode.preOrder();
			if(this.rightNode != null) this.rightNode.preOrder();
		}
		
		public void postOrder(){
			if(this.leftNode != null) this.leftNode.postOrder();
			if(this.rightNode != null) this.rightNode.postOrder();
			System.out.print(this.data + "\t");
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
	
	
	public static void main(String[] args) {
		TreeNode<Integer> treeOfDepth = buildIntTreeOfDepth(3);
		System.out.println(treeOfDepth.nodesCount());
		System.out.println(treeOfDepth.depth());
		System.out.println("************** In Order ****************");
		treeOfDepth.inOrder();
		System.out.println("");
		System.out.println("************** Pre Order ****************");
		treeOfDepth.preOrder();
		System.out.println("");
		System.out.println("************** Post Order ****************");
		treeOfDepth.postOrder();
		System.out.println("");
	}
}
