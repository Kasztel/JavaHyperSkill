import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Main {

    public static String polishToLatin (String word) {

        char[] charrArray = word.toCharArray();
        for(int i = 0; i < charrArray.length; i++) {
            switch (charrArray[i]) {
                case 'Ó':
                    charrArray[i] = 'O';
                    break;
                case 'ą':
                    charrArray[i] = 'a';
                    break;
                case 'ę':
                    charrArray[i] = 'e';
                    break;
                case 'ć':
                    charrArray[i] = 'c';
                    break;
                case 'ł':
                    charrArray[i] = 'l';
                    break;
                case 'ń':
                    charrArray[i] = 'n';
                    break;
                case 'ó':
                    charrArray[i] = 'o';
                    break;
                case 'ś':
                    charrArray[i] = 's';
                    break;
                case 'ź':
                    charrArray[i] = 'z';
                    break;
                case 'ż':
                    charrArray[i] = 'z';
                    break;
                default:
                    break;
            }

        }

        return new String(charrArray);
    }

    public static boolean isNearPalindrome (String word) {
        int i = 0;
        int j = word.length() - 1;

        while (i < j) {
            int nextInt = (int)word.charAt(j) + 1;
            int nextChar = (char)nextInt;
            int prevInt = (int)word.charAt(j) - 1;
            int prevChar = (char)prevInt;

            if (word.charAt(i) != word.charAt(j) && word.charAt(i) != nextChar && word.charAt(i) != prevChar) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        try {
            File file = new File(args[0]);
            Scanner input = new Scanner(file);
            FileWriter myWriter = new FileWriter("output.txt");


            LinkedHashMap<String, Integer> occurences = new LinkedHashMap<>();

            while (input.hasNext()) {

                String word = polishToLatin(input.next()).toLowerCase();

                if (isNearPalindrome(word)) {
                    if (!occurences.containsKey(word)) {
                        occurences.put(word, 1);
                    } else {
                        occurences.replace(word, occurences.get(word) + 1);
                    }
                }
            }

            for (String name : occurences.keySet()) {
                String value = occurences.get(name).toString();
                myWriter.write(name + " " + value + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
