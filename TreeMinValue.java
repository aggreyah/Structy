import java.util.Stack;

public class TreeMinValue {
    public static void main(String[] args) {
        TreeNode<Integer> a = new TreeNode<>(3);
        TreeNode<Integer> b = new TreeNode<>(11);
        TreeNode<Integer> c = new TreeNode<>(4);
        TreeNode<Integer> d = new TreeNode<>(4);
        TreeNode<Integer> e = new TreeNode<>(-2);
        TreeNode<Integer> f = new TreeNode<>(1);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

    //       3
    //    /    \
    //   11     4
    //  / \      \
    // 4   -2     1
        System.out.println(treeMinValue(a));  // -> -2
    }

    private static int treeMinValue(TreeNode<Integer> root) {
        if (root == null) return Integer.MAX_VALUE;
        return minVal(root.value, treeMinValue(root.left), treeMinValue(root.right));
    }

    private static Integer minVal(Integer...ints) {
        Integer min = Integer.MAX_VALUE;
        for (Integer item : ints) {
            if (item < min) min = item;
        }
        return min;
    }

    private static int treeMinValueIterative(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        int smallest = Integer.MAX_VALUE;
        while (!stack.isEmpty()){
            TreeNode<Integer> current = stack.pop();
            if (smallest > current.value) smallest = current.value;
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        return smallest;
    }
}
