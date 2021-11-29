/* 
Erick Torres,
Beck - 4th,
Computer Science 3,
August 27, 2021
*/

package Organizing;

import java.util.*;

import java.io.*;

public class Organizing {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("C:/Users/mchscs012/Documents/Java Labs/Organizing/organizing.in"));
        ArrayList<String> parsedValues = new ArrayList<>();
        ArrayList<AdventureItem> adventureItems = new ArrayList<>();
        ArrayList<AdventureItem> sortedAdventureItems = new ArrayList<>();

        while (fileScanner.hasNext()) {
            parsedValues.add(fileScanner.nextLine());
        }

        int numberOfTrials = Integer.parseInt(parsedValues.get(0));

        for (int i = 1; i < parsedValues.size(); i++) {
            adventureItems.add(new AdventureItem(parsedValues.get(i)));
        }

        ArrayList<AdventureItem> sortedByUtility = returnSortedList(adventureItems, AdventureItem.memberEnum.UTILITY);
        ArrayList<AdventureItem> sortedByWeight = returnReversedArrayList(
                returnSortedList(adventureItems, AdventureItem.memberEnum.WEIGHT));
        ArrayList<AdventureItem> sortedByCost = returnReversedArrayList(
                returnSortedList(adventureItems, AdventureItem.memberEnum.COST));

        ArrayList<Integer> duplicateIndices = new ArrayList<>();
        ArrayList<Integer> completedIndices = new ArrayList<>();

        for (int i = 0; i < sortedByUtility.size() - 1; i++) {
            if (sortedByUtility.get(i).utility == sortedByUtility.get(i + 1).utility) {
                duplicateIndices.add(i);
                duplicateIndices.add(i + 1);
            }
        }

        for (int i = 0; i < sortedByUtility.size(); i++) {
            if (!duplicateIndices.contains(i)) {
                sortedAdventureItems.add(sortedByUtility.get(i));
                completedIndices.add(i);
            }
        }

        duplicateIndices.clear();

        for (int i = 0; i < sortedByWeight.size() - 1; i++) {
            if (!completedIndices.contains(i)) {
                if (sortedByWeight.get(i).weight == sortedByWeight.get(i + 1).weight) {
                    duplicateIndices.add(i);
                    duplicateIndices.add(i + 1);
                }
            }
        }

        for (int i = 0; i < sortedByWeight.size() - 1; i++) {
            if (!duplicateIndices.contains(i)) {
                sortedAdventureItems.add(sortedByWeight.get(i));
                completedIndices.add(i);
            }
        }

        duplicateIndices.clear();

        for (int i = 0; i < sortedByCost.size(); i++) {
            if (!completedIndices.contains(i)) {
                sortedAdventureItems.add(sortedByCost.get(i));
            }
        }

        String[] output = new String[numberOfTrials];

        for (int i = 0; i < numberOfTrials; i++) {
            output[i] = sortedAdventureItems.get(i).name;
        }

        System.out.print(String.join(", ", output));
    }

    public static ArrayList<AdventureItem> returnSortedList(ArrayList<AdventureItem> inputArray,
            AdventureItem.memberEnum sortingScope) {
        ArrayList<AdventureItem> returnArray = inputArray;

        boolean completed = false;
        AdventureItem temporaryAdventureItem;

        while (!completed) {
            completed = true;
            for (int i = 0; i < returnArray.size() - 1; i++) {
                if (returnArray.get(i).getAdventureItemMember(sortingScope) < returnArray.get(i + 1)
                        .getAdventureItemMember(sortingScope)) {
                    temporaryAdventureItem = returnArray.get(i + 1);
                    returnArray.set(i + 1, returnArray.get(i));
                    returnArray.set(i, temporaryAdventureItem);
                    completed = false;
                }
            }
        }

        return returnArray;
    }

    public static <T> ArrayList<T> returnReversedArrayList(ArrayList<T> inputArrayList) {
        ArrayList<T> reversedList = new ArrayList<T>();

        for (int i = inputArrayList.size() - 1; i >= 0; i--) {
            reversedList.add(inputArrayList.get(i));
        }

        return reversedList;
    }
}

class AdventureItem {
    protected final String name;
    protected final int utility;
    protected final int weight;
    protected final int cost;

    public AdventureItem(String unsanitizedString) {
        String[] sanitizedElements = unsanitizedString.split(" ");

        this.name = sanitizedElements[0];
        this.utility = Integer.parseInt(sanitizedElements[1]);
        this.weight = Integer.parseInt(sanitizedElements[2]);
        this.cost = Integer.parseInt(sanitizedElements[3]);
    }

    protected static enum memberEnum {
        UTILITY, WEIGHT, COST
    }

    public int getAdventureItemMember(memberEnum value) {
        switch (value) {
            case UTILITY:
                return utility;
            case WEIGHT:
                return weight;
            case COST:
                return cost;
            default:
                return -1;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
