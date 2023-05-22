package practice_1;

import java.util.ArrayList;

public class Practice_1_Main {
    public static void main(String[] args) {
        Consumer<String[]> consumer = (array) -> {
            String maxLine = "";
            int maxCountLine = 0;
            for (String line : array) {
                ArrayList<Character> unique = new ArrayList<Character>();
                for( int i = 0; i < line.length(); i++) {
                    if( !unique.contains(line.charAt(i))) {
                        unique.add(line.charAt(i));
                    }
                }
                int count = unique.size();
                if (count > maxCountLine) {
                    maxCountLine = count;
                    maxLine = line;
                }
            }
            System.out.println(maxLine);
        };
        String[] test = {"dff", "abcd", "hhs"};
        consumer.accept(test);
    }
}
