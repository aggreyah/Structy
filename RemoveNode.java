public class RemoveNode {
    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

//        System.out.println(LinkedListValues.linkedListValuesIterative(removeNode(a, "d")));
        System.out.println(LinkedListValues.linkedListValuesIterative(removeNodeRecursive(a, "f")));
    }

    private static Node removeNodeRecursive(Node head, String targetVal) {
        if (head == null)
            return null;
        if (head.value == targetVal)
            return head.next;
        head.next = removeNodeRecursive(head.next, targetVal);
        return head;
    }

    private static Node removeNode(Node head, String targetVal) {
        if (head.value == targetVal)
            return head.next;
        Node previous = null;
        Node current = head;
        while (current != null){
            if (current.value.equals(targetVal)){
                previous.next = current.next;
                break;
            }
            else {
                previous = current;
                current = current.next;
            }
        }
        return head;
    }
}
