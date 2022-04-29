public class HowHigh {
    public static void main(String[] args) {
        TreeNode<String> a = new TreeNode<>("a");
        TreeNode<String> b = new TreeNode<>("b");
        TreeNode<String> c = new TreeNode<>("c");
        TreeNode<String> d = new TreeNode<>("d");
        TreeNode<String> e = new TreeNode<>("e");
        TreeNode<String> f = new TreeNode<>("f");
        TreeNode<String> g = new TreeNode<>("g");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;

    //      a
    //    /   \
    //   b     c
    //  / \     \
    // d   e     f
    //    /
    //   g

        System.out.println(howHigh(a));  // -> 3
    }

    private static int howHigh(TreeNode<String> node) {
        if (node == null) return -1;
        int leftHeight = howHigh(node.left);
        int rightHeight = howHigh(node.right);
        return 1 + (leftHeight > rightHeight? leftHeight : rightHeight);
    }
}
