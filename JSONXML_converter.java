package converter;
import java.util.Scanner;

public class JSONXML_converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.trim();
        StringBuilder converted = new StringBuilder();

        //json to xml
        if (input.charAt(0) == '{') {
            String[] tokens = input.split("\"");
            String key = tokens[1];

            if (input.contains("null")) {
                converted.append("<" + key + "/>");
            } else {
                String value = tokens[3];
                converted.append("<" + key + ">" + value + "</" + key + ">");
            }
            System.out.println(converted.toString());

        //xml to json
        } else if (input.charAt(0) == '<') {
            String[] tokens = input.split("[<>]");

            if (tokens.length == 2) {
                converted.append("{\"" + tokens[1].substring(0, tokens[1].length() - 1) + "\": null}");
            } else {
                converted.append("{\"" + tokens[1] + "\":\"" + tokens[2] + "\"}");
            }
            System.out.println(converted.toString());
        }

    }
}


