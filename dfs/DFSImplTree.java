
public class DFSImplTree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    dfs(root);

  }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode(int val) {
        this.val = val;
        }
    }
    private static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        dfs(node.left);
        dfs(node.right);
    }

}
