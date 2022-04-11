public class SumList {
    public static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(8);
        Node c = new Node(3);
        Node d = new Node(-1);
        Node e = new Node(7);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
//2 -> 8 -> 3 -> -1 -> 7
        System.out.println(sumListIterative(a));
        System.out.println(sumListRecursive(a));
    }

    private static int sumListRecursive(Node node) {
        if (node == null)
            return 0;
        return (Integer) node.value + sumListRecursive(node.next);
    }

    private static int sumListIterative(Node node) {
        int sum = 0;
        while (node != null){
            sum += (Integer) node.value;
            node = node.next;
        }
        return sum;
    }
}
