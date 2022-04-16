public class ZipperLists {
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

        Node x = new Node("x");
        Node y = new Node("y");
        Node z = new Node("z");

        x.next = y;
        y.next = z;

//        System.out.println(LinkedListValues.linkedListValuesIterative(zipperListsRecursive(x, a)));
        System.out.println(LinkedListValues.linkedListValuesIterative(zipperListsIterative(a, x)));
    }

    private static Node zipperListsIterative(Node headOne, Node headTwo) {
        Node tail = headOne;
        Node currentOne = headOne.next;
        Node currentTwo = headTwo;
        int count = 0;
        while (currentOne != null && currentTwo != null){
            if (count % 2 == 0){
                tail.next = currentTwo;
                currentTwo = currentTwo.next;
            }else {
                tail.next = currentOne;
                currentOne = currentOne.next;
            }
            tail = tail.next;
            count++;
        }
        if (currentOne != null)
            tail.next = currentOne;
        if (currentTwo != null)
            tail.next = currentTwo;
        return headOne;
    }

    private static Node zipperListsRecursive(Node headOne, Node headTwo) {
        if (headOne == null && headTwo == null)
            return null;
        if (headOne == null)
            return headTwo;
        if (headTwo == null)
            return headOne;

        Node nextOne = headOne.next;
        Node nextTwo = headTwo.next;
        headOne.next = headTwo;
        headTwo.next = zipperListsRecursive(nextOne, nextTwo);
        return headOne;
    }
}
