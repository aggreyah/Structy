import java.util.ArrayList;
import java.util.List;

public class LinkedListValues {
    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");

        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println(linkedListValuesIterative(a));
        System.out.println(linkedListValuesRecursive(a));
    }

    private static List<String> linkedListValuesRecursive(Node node) {
        List<String> listValues = new ArrayList<>();
        updateList(node, listValues);
        return listValues;
    }

    private static void updateList(Node node, List<String> values) {
        if (node == null)
            return;
        values.add((String) node.value);
        updateList(node.next, values);
    }

    private static List<String> linkedListValuesIterative(Node node) {
        List<String> listValues = new ArrayList<>();
        while (node != null){
            listValues.add((String) node.value);
            node = node.next;
        }
        return listValues;
    }
}
