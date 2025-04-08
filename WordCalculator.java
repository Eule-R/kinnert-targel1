/*
watheq shaer
325489532
HW 1
*/
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter expression:");
        String input = scanner.nextLine().toLowerCase();
        String[] words = input.split(" ");

        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> operators = new ArrayList<>();

        boolean expectNumber = true;

        for (String word : words) {
            if (isNumber(word)) {
                if (expectNumber) {
                    numbers.add(getNumber(word));
                    expectNumber = false;
                }
            } else if (isOperator(word)) {
                if (!expectNumber) {
                    operators.add(word);
                    expectNumber = true;
                }
            }
        }

        if (numbers.size() == 0) {
            System.out.println("Invalid input. No numbers found.");
            return;
        }

        for (int i = 0; i < operators.size(); i++) {
            String op = operators.get(i);
            if (op.equals("times") || op.equals("divided")) {
                int a = numbers.get(i);
                int b = numbers.get(i + 1);
                int result = op.equals("times") ? a * b : a / b;

                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            }
        }

        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            String op = operators.get(i);
            int b = numbers.get(i + 1);
            if (op.equals("plus")) {
                result += b;
            } else if (op.equals("minus")) {
                result -= b;
            }
        }

        System.out.println("The value of expression '" + input + "' is: " + result);
    }

    public static boolean isNumber(String word) {
        return switch (word) {
            case "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" -> true;
            default -> false;
        };
    }

    public static boolean isOperator(String word) {
        return switch (word) {
            case "plus", "minus", "times", "divided" -> true;
            default -> false;
        };
    }

    public static int getNumber(String word) {
        return switch (word) {
            case "zero" -> 0;
            case "one" -> 1;
            case "two" -> 2;
            case "three" -> 3;
            case "four" -> 4;
            case "five" -> 5;
            case "six" -> 6;
            case "seven" -> 7;
            case "eight" -> 8;
            case "nine" -> 9;
            case "ten" -> 10;
            default -> 0;
        };
    }
}
/*
"C:\Program Files\Java\jdk-23\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.3.4.1\lib\idea_rt.jar=55075" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\shaer\IdeaProjects\HW01\out\production\HW01 Main
Enter expression:
eight divided by two plus seven plus two times three minus one
The value of expression 'eight divided by two plus seven plus two times three minus one' is: 16

Process finished with exit code 0
*/
