import java.io.*;
import java.util.*;

public class Letters {

    public static void main(String[] args) throws Exception {


        List<String> strings = readStringsFromFile();
        Map<Character, Integer> result = process(strings);
        printResult(result);

    }

    private static Map<Character, Integer> process(List<String> strings) {
        Map<Character, Integer> result = new HashMap<>();
        char[] chars;

        for (String s : strings) {
            chars = s.toCharArray();
            for (char letters : chars) {
                if (result.containsKey(letters))
                    result.put(letters, result.get(letters) + 1);
                else
                    result.put(letters, 1);
            }
        }

        return result;
    }

    private static List<String> readStringsFromFile() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("SomeText"));
        ArrayList<String> list = new ArrayList<>();

        while (reader.ready()) {
            list.add(reader.readLine());
        }

        return list;
    }

    private static void printResult(Map<Character, Integer> map) throws Exception{

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }

    }
}