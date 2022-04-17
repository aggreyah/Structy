public class IsUnivalue {
    public static void main(String[] args) {
        Node u = new Node(2);
        Node v = new Node(2);
        Node w = new Node(2);
        Node x = new Node(2);
        Node y = new Node(4);

        u.next = v;
        v.next = w;
        w.next = x;
        x.next = y;

//        System.out.println(isUnivalueList(u));
        System.out.println(isUnivalueListRecursive(u, null));
    }

    private static boolean isUnivalueListRecursive(Node head, Node previous) {
        if (head == null)
            return true;
        if (previous != null && previous.value != head.value)
            return false;
        return isUnivalueListRecursive(head.next, head);
    }

    private static boolean isUnivalueList(Node head) {
        int headValue = (int) head.value;
        Node current = head.next;
        while (current != null){
            if ((int)current.value != headValue)
                return false;
            current = current.next;
        }
        return true;
    }
}
