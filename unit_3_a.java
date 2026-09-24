import java.util.Scanner;

public class unit_3_a {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    static void insertBeginning(int value) {

        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;
    }

    static void insertEnd(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    static void search(int value) {

        Node temp = head;

        while (temp != null) {

            if (temp.data == value) {
                System.out.println(value + " found");
                return;
            }

            temp = temp.next;
        }

        System.out.println(value + " not found");
    }

    static void delete(int value) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == value) {
            head = head.next;
            System.out.println(value + " deleted");
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println(value + " not found");
        } else {
            temp.next = temp.next.next;
            System.out.println(value + " deleted");
        }
    }

    static void display() {

        Node temp = head;

        System.out.print("List: ");

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        insertEnd(10);
        insertEnd(20);
        insertBeginning(5);

        System.out.println("After insertion:");
        display();

        System.out.print("Enter roll number to search: ");
        int searchValue = sc.nextInt();
        search(searchValue);

        System.out.print("Enter roll number to delete: ");
        int deleteValue = sc.nextInt();
        delete(deleteValue);

        System.out.println("Updated list:");
        display();
    }
}
