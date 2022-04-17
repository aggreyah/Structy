public class LongestStreak {
    public static void main(String[] args) {
        Node a = new Node(7);
        Node b = new Node(7);
        Node c = new Node(9);
        Node d = new Node(9);
        Node e = new Node(9);
        Node f = new Node(9);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        System.out.println(longestStreak(a));
    }

    private static int longestStreak(Node head) {
        Node current = head;
        Integer previousNodeVal = null;
        int maximumStreak = 0;
        int currentStreak = 0;
        while (current != null){
            if (previousNodeVal == current.value){
                currentStreak ++;
            }else{
                previousNodeVal = (Integer) current.value;
                currentStreak = 1;
            }
            if (currentStreak > maximumStreak)
                maximumStreak = currentStreak;
            current = current.next;
        }
        return maximumStreak;
    }
}
