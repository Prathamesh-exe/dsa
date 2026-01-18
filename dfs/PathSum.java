// https://leetcode.com/problems/path-sum/description/

public class PathSum {
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 22));
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // check if it's a leaf node
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        // recursively check left and right subtrees
        boolean leftHasPath = hasPathSum(root.left, targetSum - root.val);
        boolean rightHasPath = hasPathSum(root.right, targetSum - root.val);
        return leftHasPath || rightHasPath;
    }
}