import java.util.Stack;

public class TreeSum  {
    public static void main(String[] args) {
        TreeNode<Integer> a = new TreeNode<>(1);
        TreeNode<Integer> b = new TreeNode<>(6);
        TreeNode<Integer> c = new TreeNode<>(0);
        TreeNode<Integer> d = new TreeNode<>(3);
        TreeNode<Integer> e = new TreeNode<>(-6);
        TreeNode<Integer> f = new TreeNode<>(2);
        TreeNode<Integer> g = new TreeNode<>(2);
        TreeNode<Integer> h = new TreeNode<>(2);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        f.right = h;

//      1
//    /   \
//   6     0
//  / \     \
// 3   -6    2
//    /       \
//  2         2

        System.out.println(treeSumRecursive(a)); // -> 10
    }

    private static int treeSum(TreeNode<Integer> root) {
        if (root == null) return 0;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.add(root);
        int totalSum = 0;
        while (!stack.isEmpty()){
            TreeNode<Integer> current = stack.pop();
            totalSum += current.value;
            if (current.left != null)
                stack.push(current.left);
            if (current.right != null)
                stack.push(current.right);
        }
        return totalSum;
    }

    private static int treeSumRecursive(TreeNode<Integer> root) {
        if (root == null) return 0;

        return root.value + treeSumRecursive(root.left) + treeSumRecursive(root.right);
    }

}
