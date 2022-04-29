import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllTreePaths {
    public static void main(String[] args) {
        TreeNode<String> a = new TreeNode<>("a");
        TreeNode<String> b = new TreeNode<>("b");
        TreeNode<String> c = new TreeNode<>("c");
        TreeNode<String> d = new TreeNode<>("d");
        TreeNode<String> e = new TreeNode<>("e");
        TreeNode<String> f = new TreeNode<>("f");
        TreeNode<String> g = new TreeNode<>("g");
        TreeNode<String> h = new TreeNode<>("h");
        TreeNode<String> i = new TreeNode<>("i");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        e.right = h;
        f.left = i;

    //         a
    //      /    \
    //     b      c
    //   /  \      \
    //  d    e      f
    //      / \    /
    //     g  h   i

        System.out.println(allTreePaths(a));  // ->
    // [
    //   [ 'a', 'b', 'd' ],
    //   [ 'a', 'b', 'e', 'g' ],
    //   [ 'a', 'b', 'e', 'h' ],
    //  [ 'a', 'c', 'f', 'i' ]
    // ]
    }

    private static List<List<String>> allTreePaths(TreeNode<String> root) {
        List<List<String>> paths = allTreePathsReversed(root);
        for (List<String> path: paths) {
            Collections.reverse(path);
        }
        return paths;
    }

    private static List<List<String>> allTreePathsReversed(TreeNode<String> root) {
        if (root == null) return new ArrayList<>();
        if (root.left == null && root.right == null){
            List<List<String>> result = new ArrayList<>();
            List<String> rootValueAsList = new ArrayList<>();
            rootValueAsList.add(root.value);
            result.add(rootValueAsList);
            return result;
        }
        List<List<String>> paths = new ArrayList<>();
        List<List<String>> leftSubPaths = allTreePathsReversed(root.left);
        for (List<String> subPath: leftSubPaths) {
            subPath.add(root.value);
        }
        List<List<String>> rightSubPaths = allTreePathsReversed(root.right);
        for (List<String> subPath: rightSubPaths) {
            subPath.add(root.value);
        }
        paths.addAll(leftSubPaths);
        paths.addAll(rightSubPaths);
        return paths;
    }
}
