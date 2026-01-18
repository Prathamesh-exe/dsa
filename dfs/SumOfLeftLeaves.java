// https://leetcode.com/problems/sum-of-left-leaves/description/

public class SumOfLeftLeaves {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(sumOfLeftLeaves(root));
    }

    private static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        // if it is a left leaf
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        } 
        sum += sumOfLeftLeaves(root.left);                      
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}