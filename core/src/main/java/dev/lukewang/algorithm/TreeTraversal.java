package dev.lukewang.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

    public static void main(String[] args) {
        //    1
        //   / \
        //  2   3
        // / \   \
        //4   5   6
        // create all nodes
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        // build relationships
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        System.out.println("Depth First Search:");
        TreeTraversal.depthFirstSearch(node1);
        System.out.println();

        System.out.println("Breadth First Search:");
        TreeTraversal.breadthFirstSearch(node1);
        System.out.println();

        System.out.println("Preorder Traversal:");
        TreeTraversal.preorderTraversal(node1);
        System.out.println();

        System.out.println("Inorder Traversal:");
        TreeTraversal.inorderTraversal(node1);
        System.out.println();

        System.out.println("Postorder Traversal:");
        TreeTraversal.postorderTraversal(node1);
        System.out.println();
    }

    public static void depthFirstSearch(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        depthFirstSearch(node.left);
        depthFirstSearch(node.right);
    }

    public static void breadthFirstSearch(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void preorderTraversal(TreeNode node) {
        depthFirstSearch(node);
    }

    public static void inorderTraversal(TreeNode node) {
        if (node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.val + " ");
        inorderTraversal(node.right);
    }

    private static void postorderTraversal(TreeNode node) {
        if (node == null) return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.val + " ");
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
