import java.util.Scanner;

public class unit_2_b {

    static final int SIZE = 5;

    static int[] queue = new int[SIZE];
    static int front = -1;
    static int rear = -1;

    static void insert(int value) {

        if ((rear + 1) % SIZE == front) {
            System.out.println("Queue Overflow");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % SIZE;
        queue[rear] = value;

        System.out.println(value + " inserted");
    }

    static void delete() {

        if (front == -1) {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println(queue[front] + " deleted");

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % SIZE;
        }
    }

    static void display() {

        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue: ");

        int i = front;

        while (true) {
            System.out.print(queue[i] + " ");

            if (i == rear)
                break;

            i = (i + 1) % SIZE;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    insert(value);
                    break;

                case 2:
                    delete();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
