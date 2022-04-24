import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstTraverse {
    public static void main(String[] args) {
        TreeNode a = new TreeNode("a");
        TreeNode b = new TreeNode("b");
        TreeNode c = new TreeNode("c");
        TreeNode d = new TreeNode("d");
        TreeNode e = new TreeNode("e");
        TreeNode f = new TreeNode("f");
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

        System.out.println(depthFirstValuesRecursive(null));
    //   -> ['a', 'b', 'd', 'e', 'c', 'f']
    }

    private static List<String> depthFirstValuesRecursive(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        result.add((String) root.value);
        result.addAll(depthFirstValuesRecursive(root.left));
        result.addAll(depthFirstValuesRecursive(root.right));
        return result;
    }

    private static List<String> depthFirstValues(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            result.add((String) currentNode.value);
            if (currentNode.right != null)
                stack.push(currentNode.right);
            if (currentNode.left != null)
                stack.push(currentNode.left);
        }
        return result;
    }
}
