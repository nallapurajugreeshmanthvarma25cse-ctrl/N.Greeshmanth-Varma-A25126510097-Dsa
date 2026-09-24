import java.util.Scanner;
import java.util.Stack;

public class unit_2_a {

    static int precedence(char ch) {
        if (ch == '^')
            return 3;

        if (ch == '*' || ch == '/')
            return 2;

        if (ch == '+' || ch == '-')
            return 1;

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter infix expression: ");
        String infix = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        String postfix = "";

        for (int i = 0; i < infix.length(); i++) {

            char ch = infix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix = postfix + ch;
            }

            else if (ch == '(') {
                stack.push(ch);
            }

            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix = postfix + stack.pop();
                }

                stack.pop();
            }

            else {
                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && precedence(stack.peek()) >= precedence(ch)) {

                    postfix = postfix + stack.pop();
                }

                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix = postfix + stack.pop();
        }

        System.out.println("Postfix expression: " + postfix);
    }
}
