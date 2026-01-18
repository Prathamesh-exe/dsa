public class BSTImpl {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        insert(root, 3);
        insert(root, 7);
        insert(root, 2);
        insert(root, 4);
        insert(root, 6);
        insert(root, 8);

        System.out.println("In-order Traversal of BST:");
        inOrderTraversal(root);
    }
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    private static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    private static void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }
}
