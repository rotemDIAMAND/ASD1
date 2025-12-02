package test;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q3 {

    public static double calc(String expression){
        Stack<String> numbers = new Stack<>();
        Queue<String> operators = new LinkedList<>();

        // כאן תכתבי את הלוגיקה שלך לפענוח הביטוי
        return 0; // ערך זמני
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your exercise:");
        String exercise = scanner.nextInt();

        double result = calc(exercise);
        System.out.println("Result: " + result);
    }
}
