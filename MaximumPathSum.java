public class MaximumPathSum {
    public static void main(String[] args) {
        TreeNode<Integer> a = new TreeNode<> (5);
        TreeNode<Integer> b = new TreeNode<> (11);
        TreeNode<Integer> c = new TreeNode<> (54);
        TreeNode<Integer> d = new TreeNode<> (20);
        TreeNode<Integer> e = new TreeNode<> (15);
        TreeNode<Integer> f = new TreeNode<> (1);
        TreeNode<Integer> g = new TreeNode<> (3);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = f;
        e.right = g;

    //        5
    //     /    \
    //    11    54
    //  /   \
    // 20   15
    //      / \
    //     1  3

        System.out.println(maxPathSum(a));  // -> 59
    }

    private static int maxPathSum(TreeNode<Integer> root) {
        if (root == null) return -Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return root.value;
        return root.value + max(maxPathSum(root.left), maxPathSum(root.right));
    }

    private static int max(int... ints) {
        Integer maximum = -Integer.MAX_VALUE;
        for (int item : ints) {
            if (item > maximum) maximum = item;
        }
        return maximum;
    }
}
