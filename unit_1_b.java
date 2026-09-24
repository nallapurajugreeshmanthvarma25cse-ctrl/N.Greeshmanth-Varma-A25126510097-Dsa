import java.util.Scanner;

public class unit_1_b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of marks: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.println("Enter marks:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int shifts = 0;

        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
                shifts++;
            }

            a[j + 1] = key;

            System.out.print("After pass " + i + ": ");
            for (int k = 0; k < n; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();
        }

        System.out.print("Final sorted list: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
        System.out.println("Total shifts = " + shifts);
    }
}
