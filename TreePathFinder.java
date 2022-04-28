import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreePathFinder {
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

        System.out.println(pathFinder(a, "e"));  // -> [ 'a', 'b', 'e' ]
    }

    private static List<String> pathFinder(TreeNode<String> root, String target) {
        List<String> result = pathFinderReversed(root, target);

        if(result != null){
            Collections.reverse(result);
            return result;
        }
        return null;
    }

    private static List<String> pathFinderReversed(TreeNode<String> root, String target) {
        if (root == null) return null;
        if (root.value.equals(target)) {
            List<String> result = new ArrayList<>();
            result.add(root.value);
            return result;
        }else {
            if (root.left == null && root.right == null)
                return null;
        }
        List<String> leftResult = pathFinderReversed(root.left, target);
        if (leftResult != null){
            leftResult.add(root.value);
            return leftResult;
        }
        List<String> rightResult = pathFinderReversed(root.right, target);
        if (rightResult != null){
            rightResult.add(root.value);
            return rightResult;
        }
        return null;
    }
}
