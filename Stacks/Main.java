package Stacks;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        ArrayList<String> expressions = new ArrayList<>();
        Scanner scanner = new Scanner(new File("Stacks\\input.dat"));

        while (scanner.hasNext()) {
            expressions.add(scanner.nextLine());
        }

        for (String expression : expressions) {
            System.out.println(expression + " = " + evaluate(expression));
        }
    }

    public static double evaluate(String expression) throws ParseException {
        Stack<Double> valueStack = new Stack<>();

        ArrayList<String> split = new ArrayList<>(Arrays.asList(expression.split(" ")));

        while (split.size() > 0) {
            String currValue = split.remove(0);

            try {
                double numValue = Double.parseDouble(currValue);
                valueStack.push(numValue);
            } catch (NumberFormatException e) {
                double numOne = valueStack.pop();
                double numTwo = valueStack.pop();
                double result = -1;

                switch (currValue) {
                    case "+" -> result = numOne + numTwo;
                    case "-" -> result = numOne - numTwo;
                    case "/" -> result = numOne / numTwo;
                    case "*" -> result = numOne * numTwo;
                    default -> throw new ParseException("Invalid Operator Found" + currValue,
                            expression.length() - split.size());
                }

                valueStack.push(result);
            }
        }

        return valueStack.peek();
    }
}
