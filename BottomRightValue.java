import java.util.ArrayDeque;
import java.util.Deque;

public class BottomRightValue {
    public static void main(String[] args) {
        TreeNode<Integer> a = new TreeNode<>(-1);
        TreeNode<Integer> b = new TreeNode<>(-6);
        TreeNode<Integer> c = new TreeNode<>(-5);
        TreeNode<Integer> d = new TreeNode<>(-3);
        TreeNode<Integer> e = new TreeNode<>(-4);
        TreeNode<Integer> f = new TreeNode<>(-13);
        TreeNode<Integer> g = new TreeNode<>(-2);
        TreeNode<Integer> h = new TreeNode<>(6);
        TreeNode<Integer> i = new TreeNode<>(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        e.right = h;
        f.left = i;

    //        -1
    //      /   \
    //    -6    -5
    //   /  \     \
    // -3   -4   -13
    //     / \    /
    //    -2  6  7

        System.out.println(bottomRightValue(a));  // -> 7
    }

    private static int bottomRightValue(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode<Integer> current = null;
        while (!queue.isEmpty()){
            current = queue.removeFirst();
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
        return current.value;
    }
}
