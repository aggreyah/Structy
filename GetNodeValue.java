public class GetNodeValue {
    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");

        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println(getNodeValue(a, 3));
        System.out.println(getNodeValue(a, 7));
        System.out.println("*** recursive ***");
        System.out.println(getNodeValueRecursive(a, 3));
        System.out.println(getNodeValueRecursive(a, 7));
    }

    private static String getNodeValue(Node head, int index) {
        int count = 0;
        while (head != null){
            if (count == index)
                return (String) head.value;
            head = head.next;
            count ++;
        }
        return null;
    }

    private static String getNodeValueRecursive(Node head, int index) {
        if (head == null)
            return null;
        if (index == 0)
            return (String) head.value;
        return getNodeValueRecursive(head.next, --index);
    }
}
