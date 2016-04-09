package trees;

public class TreeBuilder {
	public static class TreeNode<T>{
		private T data;
		private TreeNode<T> leftNode;
		private TreeNode<T> rightNode;
		public TreeNode(T data, TreeNode<T> leftNode, TreeNode<T> rightNode) {
			super();
			this.data = data;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
	}
	
	public static TreeNode<Integer> buildIntTree(int numberOfNodes){
		if(numberOfNodes == 0){
			return null;
		}
		int midPoint = numberOfNodes/2;
		return new TreeNode<Integer>(midPoint, buildIntTree(midPoint - 1), buildIntTree(midPoint + 1));
	}
	
	public static void main(String[] args) {
		System.out.println(4/2);
	}

}
