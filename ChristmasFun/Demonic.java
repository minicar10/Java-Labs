package ChristmasFun;

import java.util.*;
import java.io.*;

public class Demonic {
    static final String[] operators = { "+", "-", "/", "*", "^" };

    static boolean isOperator(String s) {
        for (String op : operators) {
            if (op.equals(s)) {
                return true;
            }
        }
        return false;
    }

    static String prefixToInfix(String prefix) {
        String[] tokens = prefix.split(" ");
        Stack<String> stack = new Stack<String>();
        for (String token : tokens) {
            if (isOperator(token)) {
                String op2 = stack.pop();
                String op1 = stack.pop();
                stack.push("(" + op1 + token + op2 + ")");
            } else {
                stack.push(token);
            }
        }
        return stack.pop();
    }

    static String postfixToInfix(String postfix) {
        String[] tokens = postfix.split(" ");
        Stack<String> stack = new Stack<String>();
        for (String token : tokens) {
            if (isOperator(token)) {
                String op2 = stack.pop();
                String op1 = stack.pop();
                stack.push("(" + op1 + token + op2 + ")");
            } else {
                stack.push(token);
            }
        }
        return stack.pop();
    }

    static double evaluate(String expression) {
        String[] tokens = expression.split(" ");
        Stack<Double> stack = new Stack<Double>();
        for (String token : tokens) {
            if (isOperator(token)) {
                double op2 = stack.pop();
                double op1 = stack.pop();
                if (token.equals("+")) {
                    stack.push(op1 + op2);
                } else if (token.equals("-")) {
                    stack.push(op1 - op2);
                } else if (token.equals("*")) {
                    stack.push(op1 * op2);
                } else if (token.equals("/")) {
                    stack.push(op1 / op2);
                } else if (token.equals("^")) {
                    stack.push(Math.pow(op1, op2));
                }
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("ChristmasFun\\data\\demonic.dat"));
        ArrayList<String> infixEntries = new ArrayList<>();

        while (sc.hasNextLine()) {
            String prospective = sc.nextLine();

            if (isOperator(prospective.substring(0, 1))) {
                infixEntries.add(prefixToInfix(prospective));
            } else if (isOperator(prospective.substring(prospective.length() - 1, prospective.length()))) {
                infixEntries.add(postFixToInfix(prospective));
            } else {
                infixEntries.add(prospective);
            }
        }

        for (String entry : infixEntries) {
            System.out.println(entry + " = " + evaluate(entry));
        }
    }
}