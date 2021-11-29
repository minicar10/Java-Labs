
package Inflation;

import java.util.*;
import java.io.*;

public class Inflation {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> parsedValues = new ArrayList<>();
        ArrayList<Official> officials = new ArrayList<>();
        int dataSetsFollowed;
        Scanner fileScanner = new Scanner(new File("C:/Users/mchscs012/Documents/Java Labs/Inflation/inflation.in"));
        while (fileScanner.hasNext()) {
            parsedValues.add(fileScanner.nextLine());
        }
        dataSetsFollowed = Integer.parseInt(parsedValues.remove(0));
        officials = parseOfficials(dataSetsFollowed, parsedValues);
        for (Official official : officials) {
            System.out.println(official.getBribeAmount());
        }
    }

    public static ArrayList<Official> parseOfficials(int setsFollowed, ArrayList<String> parsedValues) {
        ArrayList<Official> returnList = new ArrayList<>();
        boolean canCreateNewObject = true;
        int activeIndex = 0;
        int relativeLinesRead = 0;
        for (int i = 0; i < parsedValues.size(); i++) {
            if (!parsedValues.get(i).equals("")) {
                if (canCreateNewObject && relativeLinesRead == 0) {
                    String[] splitArray = parsedValues.get(i).split(" ");
                    returnList.add(new Official(Integer.parseInt(splitArray[0]), Double.parseDouble(splitArray[1]),
                            Integer.parseInt(splitArray[2]), Double.parseDouble(splitArray[3])));
                    canCreateNewObject = false;
                } else if (relativeLinesRead == 1) {
                    returnList.get(activeIndex).setAssetsFollowed(Integer.parseInt(parsedValues.get(i)));
                } else if (relativeLinesRead > 1) {
                    returnList.get(activeIndex).addAsset(Integer.parseInt(parsedValues.get(i)));
                }
                relativeLinesRead++;
            } else {
                canCreateNewObject = true;
                activeIndex++;
                relativeLinesRead = 0;
            }
        }
        return returnList;
    }
}

class Official {
    private int wealthC;
    private double rebellionFactorR;
    private int transportationControlT;
    private double socialStatusN;
    private int assetsFollowedO;
    private int[] assets;

    public Official(int wealth, double rebellionFactor, int transportationControl, double socialStatus) {
        this.wealthC = wealth;
        this.rebellionFactorR = rebellionFactor;
        this.transportationControlT = transportationControl;
        this.socialStatusN = socialStatus;
        this.assets = new int[0];
    }

    public void addAsset(int newAsset) {
        if (assetsFollowedO > 0) {
            int[] newArray = new int[assets.length + 1];
            for (int i = 0; i < assets.length; i++) {
                newArray[i] = assets[i];
            }
            newArray[newArray.length - 1] = newAsset;
            this.assets = newArray;
            this.assetsFollowedO--;
        }
    }

    public void setAssetsFollowed(int assetsToFollow) {
        this.assetsFollowedO = assetsToFollow;
    }

    public int getTotalTrackedAssetValue() {
        int totalValue = 0;
        for (int asset : assets) {
            totalValue += asset;
        }
        return totalValue;
    }

    public double getBribeAmount() {
        double unroundedReturnValue = Math
                .sqrt(((wealthC + getTotalTrackedAssetValue()) * (Math.pow((2 - rebellionFactorR), 0.5))
                        * (Math.log10(transportationControlT))) / Math.pow(socialStatusN, 1.5));
        return (double) Math.round(unroundedReturnValue * 100) / 100;
    }
}
