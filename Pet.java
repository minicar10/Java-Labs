import java.util.*;

public class Pet {
    public String speak() {
        return null;
    }
}

class Cat extends Pet {
    String breed;

    public Cat() {
        super();
        this.breed = "";
    }

    public Cat(String breedName) {
        super();
        this.breed = breedName;
    }

    @Override
    public String speak() {
        return "meow";
    }

    @Override
    public String toString() {
        return "Purring...";
    }
}

class Dog extends Pet {
    int trainabilityFactor;
    String[] listOfTricks;

    public Dog(int trainabilityFactor) {
        super();
        this.trainabilityFactor = trainabilityFactor;
        this.listOfTricks = new String[0];
    }

    public void learnNewTrick(int difficulty, String newTrickName) {
        if (difficulty <= trainabilityFactor) {
            String[] newArray = new String[listOfTricks.length + 1];
            for (int i = 0; i < listOfTricks.length; i++) {
                newArray[i] = listOfTricks[i];
            }
            newArray[newArray.length - 1] = newTrickName;
            this.listOfTricks = newArray;
        }
    }

    public String doTrick() {
        return listOfTricks[(int) ((Math.random() * ((listOfTricks.length - 1))))];
    }

    @Override
    public String speak() {
        int randomNumber = (int) ((Math.random() * (100)));

        if (randomNumber <= 70) {
            return "Woof!";
        }
        return "Bark!";
    }
}