public class InsertNode {
    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");

        a.next = b;
        b.next = c;
        c.next = d;

//        System.out.println(LinkedListValues.linkedListValuesIterative(insertNode(a, "m", 3)));
        System.out.println(LinkedListValues.linkedListValuesIterative(insertNodeRecursive(a, "m", 4, 0)));
    }

    private static Node insertNodeRecursive(Node head, String value, int index, int count) {
        if (index == 0){
            Node valueNode = new Node(value);
            valueNode.next = head;
            return valueNode;
        }
        if (head == null)
            return null;

        if (count == index - 1){
            Node temp = head.next;
            Node valueNode = new Node(value);
            head.next = valueNode;
            valueNode.next = temp;
        }
        head.next = insertNodeRecursive(head.next, value, index, ++count);

        return head;
    }

    private static Node insertNode(Node head, String value, int index) {
        if (index == 0){
            Node valueNode = new Node(value);
            valueNode.next = head;
            return valueNode;
        }
        int count = 0;
        Node current = head;
        while (current != null){
            if (count == index - 1){
                Node temp = current.next;
                Node valueNode = new Node(value);
                current.next = valueNode;
                valueNode.next = temp;
                break;
            }
            current = current.next;
            count++;
        }
        return head;
    }
}
