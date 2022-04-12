public class LinkedListFind {
    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");

        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println(linkedListFind(a, "d"));
        System.out.println(linkedListFind(a, "e"));
        System.out.println("*** recursive ***");
        System.out.println(linkedListFindRecursion(a, "d"));
        System.out.println(linkedListFindRecursion(a, "e"));
    }

    private static boolean linkedListFindRecursion(Node head, String target) {
        if (head == null)
            return false;
        if (head.value.equals(target))
            return true;
        return linkedListFindRecursion(head.next, target);
    }

    private static boolean linkedListFind(Node head, String target) {
        while (head != null){
            if (head.value.equals(target))
                return true;
            else
                head = head.next;
        }
        return false;
    }
}
