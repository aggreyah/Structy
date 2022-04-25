import java.util.Stack;

public class TreeIncludes {
    public static void main(String[] args) {
        TreeNode<String> a = new TreeNode<>("a");
        TreeNode<String> b = new TreeNode<>("b");
        TreeNode<String> c = new TreeNode<>("c");
        TreeNode<String> d = new TreeNode<>("d");
        TreeNode<String> e = new TreeNode<>("e");
        TreeNode<String> f = new TreeNode<>("f");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

    //      a
    //    /   \
    //   b     c
    //  / \     \
    // d   e     f

        System.out.println(treeIncludes(a, "e"));  // -> True
    }

    private static boolean treeIncludes(TreeNode<String> root, String target) {
        if (root == null) return false;
        if (root.value.equals(target)) return true;
        return treeIncludes(root.left, target) || treeIncludes(root.right, target);
    }

    private static boolean treeIncludesIterative(TreeNode<String> root, String target) {
        if (root == null) return false;
        if (root.value.equals(target)) return true;
        Stack<TreeNode<String>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode<String> current = stack.pop();
            if (current.value.equals(target)) return true;
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        return false;
    }
}
