import java.util.ArrayList;
import java.util.List;

public class LevelAverages {
    public static void main(String[] args) {
        TreeNode<Integer> a = new TreeNode<>(5);
        TreeNode<Integer> b = new TreeNode<>(11);
        TreeNode<Integer> c = new TreeNode<>(54);
        TreeNode<Integer> d = new TreeNode<>(20);
        TreeNode<Integer> e = new TreeNode<>(15);
        TreeNode<Integer> f = new TreeNode<>(1);
        TreeNode<Integer> g = new TreeNode<>(3);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = f;
        e.right = g;

    //        5
    //     /    \
    //    11    54
    //  /   \
    // 20   15
    //      / \
    //     1  3

        System.out.println(levelAverages(a));  // -> [ 5, 32.5, 17.5, 2 ]
//        System.out.println(getLevels(a));
    }

    private static List<Double> levelAverages(TreeNode<Integer> root) {
        List<Double> averages = new ArrayList<>();
        List<List<Integer>> levels = getLevels(root);
        for (List<Integer> level : levels) {
            int sum = 0;
            for (int item : level){
                sum += item;
            }
            averages.add((sum*1.0 / level.size()));
        }

        return averages;
    }
    private static List<List<Integer>> getLevels(TreeNode<Integer> root){
        if (root == null) return new ArrayList<>();
        List<List<Integer>> levels = new ArrayList<>();
        populateList(root, levels, 0);
        return levels;
    }

    private static void populateList(TreeNode<Integer> root, List<List<Integer>> list, int level) {
        if (root == null) return;
        if (list.size() == level){
            List<Integer> newLevel = new ArrayList<>();
            newLevel.add(root.value);
            list.add(newLevel);
        }else {
            list.get(level).add(root.value);
        }
        populateList(root.left, list, level + 1);
        populateList(root.right, list, level + 1);
    }
}
