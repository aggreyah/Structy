import java.util.*;

public class TreeLevels {
    public static void main(String[] args) {
        TreeNode<Character> a = new TreeNode<>('a');
        TreeNode<Character> b = new TreeNode<>('b');
        TreeNode<Character> c = new TreeNode<>('c');
        TreeNode<Character> d = new TreeNode<>('d');
        TreeNode<Character> e = new TreeNode<>('e');
        TreeNode<Character> f = new TreeNode<>('f');
        TreeNode<Character> g = new TreeNode<>('g');
        TreeNode<Character> h = new TreeNode<>('h');
        TreeNode<Character> i = new TreeNode<>('i');

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

        System.out.println(treeLevelsRecursive(a)); // ->
// [
//   ['a'],
//   ['b', 'c'],
//   ['d', 'e', 'f'],
//   ['g', 'h', 'i']
// ]
    }

    private static List<List<Character>> treeLevelsRecursive(TreeNode<Character> root) {
        if (root == null) return new ArrayList<>();
        List<List<Character>> levels = new ArrayList<>();
        updateLevels(root, levels, 0);
        return levels;
    }

    private static void updateLevels(TreeNode<Character> root, List<List<Character>> list, int level) {
        if (root == null) return;
        if (list.size() == level){
            List<Character> newLevel = new ArrayList<>();
            newLevel.add(root.value);
            list.add(newLevel);
        }
        else
            list.get(level).add(root.value);
        updateLevels(root.left, list, level + 1);
        updateLevels(root.right, list, level + 1);
    }

    private static List<List<Character>> treeLevelsDepthFirst(TreeNode<Character> root) {
        if (root == null) return new ArrayList<>();
        List<List<Character>> levels = new ArrayList<>();
        Pair<TreeNode<Character>, Integer> rootLevelPair = new Pair<>(root, 0);
        Deque<Pair<TreeNode<Character>, Integer>> stack = new ArrayDeque<>();
        stack.push(rootLevelPair);
        while (!stack.isEmpty()){
            Pair<TreeNode<Character>, Integer> currentNodeLevelPair = stack.pop();
            int level = currentNodeLevelPair.getValue();
            TreeNode<Character> currentNode = currentNodeLevelPair.getKey();
            if (levels.size() == level){
                List<Character> newLevel = new ArrayList<>();
                newLevel.add(currentNode.value);
                levels.add(newLevel);
            }
            else
                levels.get(level).add(currentNode.value);
            if (currentNode.right != null)
                stack.push(new Pair<>(currentNode.right, level + 1));
            if (currentNode.left != null)
                stack.push(new Pair<>(currentNode.left, level + 1));
        }
        return levels;
    }
}
