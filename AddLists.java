import java.util.ArrayList;
import java.util.List;

public class AddLists {
    public static void main(String[] args) {
        Node<Integer> a1 = new Node<>(9);
        Node<Integer> a2 = new Node<>(8);
        Node<Integer> a3 = new Node<>(6);

        a1.next = a2;
        a2.next = a3;

        Node<Integer> b1 = new Node<>(7);
        Node<Integer> b2 = new Node<>(4);
        Node<Integer> b3 = new Node<>(3);

        b1.next = b2;
        b2.next = b3;

        System.out.println(linkedListValuesRecursive(addLists(a1, b1)));
    }

    private static Node<Integer> addLists(Node<Integer> headOne, Node<Integer> headTwo) {
        if (headOne == null && headTwo == null) return null;
        Node<Integer> result = new Node<>(null);
        Node<Integer> tail = result;
        int carry = 0;
        do {
            int headOneValue = headOne == null ? 0 : headOne.value;
            int headTwoValue = headTwo == null ? 0 : headTwo.value;
            int sum = headOneValue + headTwoValue + carry;
            tail.next = new Node<>(sum % 10);
            tail = tail.next;
            headOne = headOne == null ? null : headOne.next;
            headTwo = headTwo == null ? null : headTwo.next;
            carry = sum < 10 ? 0 : 1;
        } while (headOne != null || headTwo != null || carry != 0);
        return result.next;
    }

    private static Node<Integer> addListsRecursive(Node<Integer> headOne, Node<Integer> headTwo, int carry) {
        if (headOne == null && headTwo == null && carry == 0) return null;
        int headOneValue = headOne == null? 0 : headOne.value;
        int headTwoValue = headTwo == null ? 0 : headTwo.value;
        int sumResult = headOneValue + headTwoValue + carry;
        Node<Integer> sumHeadNode = new Node<>(sumResult % 10);
        carry = sumResult < 10? 0 : 1;
        sumHeadNode.next = addListsRecursive(headOne == null? null : headOne.next, headTwo == null? null : headTwo.next, carry);
        return sumHeadNode;
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
