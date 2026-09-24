import java.util.Scanner;

public class unit_1_a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[100];

        System.out.print("Enter number of employee IDs: ");
        int n = sc.nextInt();

        System.out.println("Enter IDs in ascending order:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print("Enter ID to search: ");
        int key = sc.nextInt();

        int low = 0;
        int high = n - 1;
        int comparisons = 0;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (a[mid] == key) {
                System.out.println("ID found at position " + (mid + 1));
                found = true;
                break;
            } else if (key < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (!found) {
            System.out.println("ID not found");
        }

        System.out.println("Number of comparisons = " + comparisons);
    }
}
