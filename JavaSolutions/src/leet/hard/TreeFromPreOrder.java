package leet.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeFromPreOrder {

//  Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class Node extends TreeNode {
        int depth;

        Node(int val, int d) {
            super(val);
            depth = d;
        }
    }

    public TreeNode recoverFromPreorder(String str) {
        TreeNode root = null;
        char[] chars = str.toCharArray();
        int i =0, depth = 0;
        Stack<Node> stack = new Stack<>();
        while (true) {
            int nextNumIndex = i;
            String numString = "";
            while (i < chars.length && chars[nextNumIndex] != '-'){
                numString = numString + chars[nextNumIndex];
                nextNumIndex++;
                i++;
            }
            Node node = new Node(Integer.parseInt(numString), depth);
            if (node.depth == 0) {root = node;}

            updateTree(stack, node);

            if (i >= chars.length) {
                break;
            }

            int nextHyphenIndex = i;
            depth = 0;
            while (chars[nextHyphenIndex] == '-') {
                nextHyphenIndex++;
                i++;
                depth++;
            }

            if (i >= chars.length) {
                break;
            }
        }

        return root;
    }

    private void updateTree(Stack<Node> stack, Node node) {
        System.out.println(node.val + " at depth: " + node.depth);
        if (stack.empty()) {
            stack.push(node);
            return;
        }
        Node topNode = stack.peek();
        if (topNode.depth < node.depth) {
            topNode.left = node;
            stack.push(node);
        } else {
            while (topNode.depth >= node.depth) {
                topNode = stack.pop();
            }
            topNode.right = node;
            stack.push(node);
        }
    }

    private void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {
        TreeFromPreOrder tree = new TreeFromPreOrder();
        TreeNode root = tree.recoverFromPreorder("1-2--3--4-5--6--7");
        System.out.println();
        tree.printPreOrder(root);
        System.out.println();


        root = tree.recoverFromPreorder("1-2--3---4-5--6---7");
        tree.printPreOrder(root);
    }
}
