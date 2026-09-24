public class unit_3_b {

    static class Node {
        String page;
        Node prev;
        Node next;

        Node(String page) {
            this.page = page;
        }
    }

    static Node head = null;
    static Node tail = null;

    static void insert(String page) {
        Node newNode = new Node(page);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    static void delete(String page) {
        Node temp = head;

        while (temp != null && !temp.page.equals(page)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Page not found");
            return;
        }

        if (temp.prev != null)
            temp.prev.next = temp.next;
        else
            head = temp.next;

        if (temp.next != null)
            temp.next.prev = temp.prev;
        else
            tail = temp.prev;

        System.out.println(page + " deleted");
    }

    static void displayForward() {
        Node temp = head;

        System.out.print("First to last: ");

        while (temp != null) {
            System.out.print(temp.page + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    static void displayBackward() {
        Node temp = tail;

        System.out.print("Last to first: ");

        while (temp != null) {
            System.out.print(temp.page + " ");
            temp = temp.prev;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        insert("Google");
        insert("YouTube");
        insert("GitHub");
        insert("LeetCode");

        displayForward();
        displayBackward();

        delete("YouTube");

        displayForward();
        displayBackward();
    }
}
