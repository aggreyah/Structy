import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeafList {
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

        System.out.println(leafListIterative(a)); // -> [ 'd', 'g', 'h' ]
    }

    private static List<String> leafListIterative(TreeNode<String> root) {
        if (root == null) return new ArrayList<>();
        List<String> leaves = new ArrayList<>();
        Deque<TreeNode<String>> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode<String> current = stack.pop();
            if (current.left == null && current.right == null) leaves.add(current.value);
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        return leaves;
    }

    private static List<String> leafList(TreeNode<String> root) {
        if (root == null) return new ArrayList<>();
        if (root.left == null && root.right == null){
            List<String> newList = new ArrayList<>();
            newList.add(root.value);
            return newList;
        }
        List<String> leftList = leafList(root.left);
        List<String> rightList = leafList(root.right);
        leftList.addAll(rightList);
        return leftList;
    }
}
