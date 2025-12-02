package test;

import java.util.*;

public class Q3 {

    public static boolean isOperator(char ch) {
        return "+-*/".contains(String.valueOf(ch));
    }

    public static int precedence(String op) {
        if (op.equals("+") || op.equals("-")) return 1;
        if (op.equals("*") || op.equals("/")) return 2;
        return 0;
    }

    public static double calc(String expression) {

        Stack<String> operators = new Stack<>();
        Queue<String> output = new LinkedList<>();

        // --- Step 1: convert INFIX → POSTFIX ---
        for (char ch : expression.toCharArray()) {

            // number
            if (Character.isDigit(ch)) {
                output.add(String.valueOf(ch));
            }

            // operator
            else if (isOperator(ch)) {

                String op = String.valueOf(ch);

                while (!operators.isEmpty() &&
                        !operators.peek().equals("(") &&
                        precedence(operators.peek()) >= precedence(op)) {

                    output.add(operators.pop());
                }

                operators.push(op);
            }

            // (
            else if (ch == '(') {
                operators.push("(");
            }

            // )
            else if (ch == ')') {

                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop());
                }

                operators.pop(); // remove '('
            }
        }

        // pop remaining operators
        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        // Debug: print postfix
        System.out.println("POSTFIX: " + output);

        // --- Step 2: convert POSTFIX → Expression tree ---
        Stack<Expression> exprStack = new Stack<>();

        while (!output.isEmpty()) {
            String token = output.poll();

            if (Character.isDigit(token.charAt(0))) {

                exprStack.push(new Number(Integer.parseInt(token)));

            } else {

                Expression right = exprStack.pop();
                Expression left = exprStack.pop();

                switch (token) {
                    case "+":
                        exprStack.push(new Plus(left, right));
                        break;
                    case "-":
                        exprStack.push(new Minus(left, right));
                        break;
                    case "*":
                        exprStack.push(new Mul(left, right));
                        break;
                    case "/":
                        exprStack.push(new Div(left, right));
                        break;
                }
            }
        }

        // only one expression remains
        Expression finalExpr = exprStack.pop();

        // --- Step 3: calculate the result ---
        return finalExpr.calculate();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your exercise:");
        String exercise = scanner.nextLine();

        double result = calc(exercise);
        System.out.println("Result: " + result);
    }
}
