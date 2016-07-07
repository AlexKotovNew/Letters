import java.io.*;
import java.util.*;

public class Letters {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("D:\\KoT\\letters.txt"));
        ArrayList<String> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        char[] words = new char[0];

        while (reader.ready()) {
            list.add(reader.readLine());
        }


        for (String string : list) {
            words = string.toCharArray();
            Arrays.sort(words);
            for (char letters : words) {
                if (map.containsKey(letters))
                    map.put(letters, map.get(letters) + 1);
                else
                    map.put(letters, 1);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\KoT\\letters.txt"))) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
                writer.write(entry.getKey() + " - " + entry.getValue());
                writer.newLine();
            }
        }
    }
}