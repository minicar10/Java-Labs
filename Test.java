import java.util.*;

public class Test {
    public static void main(String[] args) {
        // create a treeset of name treeSetOne
        TreeSet<String> treeSetOne = new TreeSet<String>();
        // create another treeset of name treesetTwo
        TreeSet<String> treeSetTwo = new TreeSet<String>();

        treeSetOne.add("A");
        treeSetOne.add("B");
        treeSetOne.add("C");
        treeSetOne.add("D");

        treeSetTwo.add("A");
        treeSetTwo.add("B");
        treeSetTwo.add("C");
        treeSetTwo.add("D");
        treeSetTwo.add("E");

        System.out.println(treeSetOne.addAll(treeSetTwo));
    }
}
