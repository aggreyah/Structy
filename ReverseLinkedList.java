public class ReverseLinkedList {
    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");

        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println(LinkedListValues.linkedListValuesIterative(a));

//        System.out.println(LinkedListValues.linkedListValuesIterative(reverseLinkedList(a)));

        System.out.println(LinkedListValues.linkedListValuesIterative(reverseLinkedListRecursive(a, null)));
    }

    private static Node reverseLinkedListRecursive(Node head, Node previous) {
        Node next;
        if (head == null)
            return previous;
        next = head.next;
        head.next = previous;
        return reverseLinkedListRecursive(next, head);
    }

    private static Node reverseLinkedList(Node head) {
        Node previous = null;
        Node current = head;
        Node next;

        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
