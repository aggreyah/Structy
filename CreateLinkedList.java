public class CreateLinkedList {
    public static void main(String[] args) {
        String [] strings = new String[] {"a", "b", "c", "d" , "e", "f"};
//        System.out.println(LinkedListValues.linkedListValuesIterative(createLinkedList(strings)));
        System.out.println(LinkedListValues.linkedListValuesIterative(createLinkedListRecursive(strings, 0)));
    }

    private static Node createLinkedListRecursive(String[] strings, int index) {
        if (index == strings.length)
            return null;
        Node head = new Node(strings[index]);
        head.next = createLinkedListRecursive(strings, ++index);
        return head;
    }

    private static Node createLinkedList(String[] strings) {
        if (strings.length == 0)
            return null;
        Node dummy = new Node(null);
        Node tail = dummy;
        for (String string: strings){
            Node current = new Node(string);
            tail.next = current;
            tail = tail.next;
        }
        return dummy.next;
    }
}
