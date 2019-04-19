package leet.hard;

import java.util.ArrayList;
import java.util.List;

public class TreeFromPreOrder {

//  Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class Node {
        int x;
        int depth;

        Node(int val, int d) {
            x= val;
            depth = d;
        }
    }

    public TreeNode recoverFromPreorder(String str) {
        TreeNode root = new TreeNode(0);
        List<Node> nodes = this.parseNodes(str);
        for(Node node : nodes){
            System.out.println(node.x + " at depth: " + node.depth);
        }
        return root;

    }

    private List<Node> parseNodes(String str) {
        List<Node> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        int i =0, depth = 0;
        while (true) {

            int nextNumIndex = i;
            String numString = "";
            while (i < chars.length && chars[nextNumIndex] != '-'){
                numString = numString + chars[nextNumIndex];
                nextNumIndex++;
                i++;
            }
            result.add(new Node(Integer.parseInt(numString), depth));

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

        return result;
    }

    public static void main(String[] args) {
        TreeFromPreOrder tree = new TreeFromPreOrder();
        tree.recoverFromPreorder("1-2--3--4-5--6--7");
        System.out.println();
        tree.recoverFromPreorder("1-2--3---4-5--6---7");
    }
}
