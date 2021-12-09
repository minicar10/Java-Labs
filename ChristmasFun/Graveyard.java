package ChristmasFun;

import java.io.*;
import java.util.*;

public class Graveyard {
    public static void main (String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("ChristmasFun\\data\\graveyard.dat"));
        Map<Character, Integer> letters = new HashMap<>();

        while (sc.hasNextLine()){
            String line = sc.nextLine();
            line = line.substring(1, line.length()-1).toUpperCase();

            char[] characters = line.toCharArray();

            for(char character: characters){
                if(character != ' '){
               if(letters.containsKey(character)){
                   letters.put(character, letters.get(character)+1);
               } else { 
                   letters.put(character, 1);
               }
            }
            }

            char mostPrevalent = '?';
            int maxOccurrences = Integer.MIN_VALUE;

            for(Map.Entry<Character, Integer> entry : letters.entrySet()){
                if(entry.getValue() > maxOccurrences){
                    mostPrevalent = entry.getKey();
                    maxOccurrences = entry.getValue();
                }
            }

            for(int i = 0; i < maxOccurrences; i++){
                System.out.print(mostPrevalent + " ");
            }

            System.out.println();

            letters.clear();
        }
    }
    }

