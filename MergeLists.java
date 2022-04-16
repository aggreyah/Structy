import java.util.ArrayList;
import java.util.List;

public class MergeLists {
    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(7);
        Node c = new Node(10);
        Node d = new Node(12);
        Node e = new Node(20);
        Node f = new Node(28);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        Node q = new Node(1);
        Node r = new Node(8);
        Node s = new Node(9);
        Node t = new Node(10);
        q.next = r;
        r.next = s;
        s.next = t;

//        System.out.println(linkedListValuesRecursive(mergeLists(a, q)));
        System.out.println(linkedListValuesRecursive(mergeListsRecursive(a, q)));
    }

    private static Node mergeListsRecursive(Node headOne, Node headTwo) {
        if (headOne == null && headTwo == null)
            return null;
        if (headOne == null)
            return headTwo;
        if (headTwo == null)
            return headOne;

        if ((Integer) headOne.value < (Integer) headTwo.value){
            Node temp = headOne.next;
            headOne.next = mergeListsRecursive(temp, headTwo);
            return headOne;
        }else{
            Node temp = headTwo.next;
            headTwo.next = mergeListsRecursive(headOne, temp);
            return headTwo;
        }
    }

    private static Node mergeLists(Node headOne, Node headTwo) {
        Node currentOne = headOne;
        Node currentTwo = headTwo;
        Node dummy = new Node(null);
        Node tail = dummy;

        while (currentOne != null && currentTwo != null){
            if ((Integer) currentOne.value < (Integer) currentTwo.value){
                tail.next = currentOne;
                currentOne = currentOne.next;
            }else {
                tail.next = currentTwo;
                currentTwo = currentTwo.next;
            }
            tail = tail.next;
        }
        if (currentOne != null)
            tail.next = currentOne;
        if (currentTwo != null)
            tail.next = currentTwo;

        return dummy.next;
    }

    private static List<Integer> linkedListValuesRecursive(Node node) {
        List<Integer> listValues = new ArrayList<>();
        updateList(node, listValues);
        return listValues;
    }

    private static void updateList(Node node, List<Integer> values) {
        if (node == null)
            return;
        values.add((Integer) node.value);
        updateList(node.next, values);
    }
}
