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

    static String prefixToInfix(String expression) {
        String[] tokens = expression.split(" ");

        throw new UnsupportedOperationException("Not implemented yet.");
    }

    static String postFixToInfix(String expression) {
        String[] tokens = expression.split(" ");

        throw new UnsupportedOperationException("Not implemented yet.");
    }

    static int evaluateInfixExpression(String expression) {
        String[] tokens = expression.split(" ");

        throw new UnsupportedOperationException("Not implemented yet.");
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

        for (String expression : infixEntries) {
            System.out.println(evaluateInfixExpression(expression));
        }
    }
}

class Expression {

    public Expression(String expression) {

    }
}