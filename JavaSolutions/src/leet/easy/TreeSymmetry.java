package leet.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TreeSymmetry {

    //     Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static Integer[] treeToArray(TreeNode root) {
        List<Integer> treeAsArray = new ArrayList<>(200);
        treeAsArray.add(0, 0);
        insertIntoArray(treeAsArray, root, 1);
        return treeAsArray.toArray(new Integer[treeAsArray.size()]);
    }

    private static void insertIntoArray(List<Integer> treeAsArray, TreeNode node, int nodeIndex) {
        if (node == null) {
            treeAsArray.add(nodeIndex, null);
        } else {
            treeAsArray.add(nodeIndex, node.val);
            insertIntoArray(treeAsArray, node.left, nodeIndex * 2);
            insertIntoArray(treeAsArray, node.right, (nodeIndex * 2) + 1);
        }
    }

    private static TreeNode arrayToTree(Integer[] treeAsArray) {
        int currIndex = 1;
        TreeNode rootNode = buildTreeNode(treeAsArray, currIndex);


        return rootNode;
    }

    private static TreeNode buildTreeNode(Integer[] treeAsArray, int currIndex) {
        if (currIndex < treeAsArray.length && treeAsArray[currIndex] != null) {
            TreeNode root = new TreeNode(treeAsArray[currIndex]);
            root.left = buildTreeNode(treeAsArray,2 * currIndex);
            root.right = buildTreeNode(treeAsArray,(2 * currIndex) + 1);
            return root;
        }
        return null;
    }

    public boolean isSymmetric(TreeNode root) {
        Integer[] treeArray = treeToArray(root);
        int currLevel = 1;
        while (true) {
            int currentLevelStartIndex = (int) Math.pow(2, currLevel);

            if (currentLevelStartIndex > treeArray.length)  {
                return true;
            }
            int currentLevelEndIndex = ((int) Math.pow(2 + 1, currLevel)) - 1;

            if (!checkSymmetry(treeArray, currentLevelStartIndex, currentLevelEndIndex)) {
                return false;
            }
        }

//        return true;
    }

    private boolean checkSymmetry(Integer[] treeArray, int currentLevelStartIndex, int currentLevelEndIndex) {
        for (int i = currentLevelStartIndex, j = currentLevelEndIndex; i >= j; i++, j--) {
            if (treeArray[i] != treeArray[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer [] trees = new Integer[] {0,1,2,2,3,4,4,3};

        TreeNode root = arrayToTree(trees);

        TreeSymmetry ts = new TreeSymmetry();
        System.out.println(ts.isSymmetric(root));

    }
}
