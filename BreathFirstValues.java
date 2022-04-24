import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreathFirstValues {
    public static void main(String[] args) {
        TreeNode<String> a = new TreeNode<>("a");
        TreeNode<String> b = new TreeNode<>("b");
        TreeNode<String> c = new TreeNode<>("c");
        TreeNode<String> d = new TreeNode<>("d");
        TreeNode<String> e = new TreeNode<>("e");
        TreeNode<String> f = new TreeNode<>("f");
        TreeNode<String> g = new TreeNode<>("g");
        TreeNode<String> h = new TreeNode<>("h");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        f.right = h;

    //      a
    //    /   \
    //   b     c
    //  / \     \
    // d   e     f
    //    /       \
    //   g         h

        System.out.println(breadthFirstValues(a));
    //   -> ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
    }

    private static List<String> breadthFirstValues(TreeNode<String> root) {
        if (root == null) return null;
        Queue<TreeNode<String>> queue = new ArrayDeque<>();
        queue.offer(root);
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode<String> current = queue.poll();
            result.add(current.value);
            if (current.left != null)
                queue.offer(current.left);
            if (current.right != null)
                queue.offer(current.right);
        }
        return result;
    }
}
