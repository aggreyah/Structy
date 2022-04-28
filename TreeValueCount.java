import java.util.Stack;

public class TreeValueCount {
    public static void main(String[] args) {
        TreeNode<Integer> a = new TreeNode<> (7);
        TreeNode<Integer> b = new TreeNode<> (5);
        TreeNode<Integer> c = new TreeNode<> (1);
        TreeNode<Integer> d = new TreeNode<> (1);
        TreeNode<Integer> e = new TreeNode<> (8);
        TreeNode<Integer> f = new TreeNode<> (7);
        TreeNode<Integer> g = new TreeNode<> (1);
        TreeNode<Integer> h = new TreeNode<> (1);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        f.right = h;

    //      7
    //    /   \
    //   5     1
    //  / \     \
    // 1   8     7
    //    /       \
    //   1         1

        System.out.println(treeValueCount(a, 1)); // -> 4
    }

    private static int treeValueCount(TreeNode<Integer> root, int target) {
        if (root == null) return 0;
        int root_matches = root.value == target? 1 : 0;
        return root_matches + treeValueCount(root.left, target) + treeValueCount(root.right, target);
    }

    private static int treeValueCountIterative(TreeNode<Integer> root, int target) {
        if (root == null) return 0;
        int count = 0;
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode<Integer> current = stack.pop();
            if (current.value == target)
                count ++;
            if (current.left != null)
                stack.push(current.left);
            if (current.right != null)
                stack.push(current.right);
        }
        return count;
    }
}
