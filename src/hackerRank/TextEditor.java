package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * explanationWithImages/TextEditor.png
 */
public class TextEditor {
    public static void main(String[] args) {
//      commands = [["Insert", "Present"], ["Print", "5"], ["Left", "4"], ["Insert", "test"], ["Print", "8"], ["Delete", "4"], ["Print", "7"]]

        List<List<String>> commands = List.of(
                List.of("Insert", "Present"),
                List.of("Print", "5"),
                List.of("Left", "4"),
                List.of("Insert", "test"),
                List.of("Print", "8"),
                List.of("Delete", "4"),
                List.of("Print", "7")
        );

//        List<List<String>> commands = List.of(
//                List.of("Insert", "addthis"),
//                List.of("Print", "5"),
//                List.of("Left", "4"),
//                List.of("Right", "2"),
//                List.of("Backspace", "1"),
//                List.of("Delete", "1"),
//                List.of("Print", "10")
//        );
        getPrintedStrings(commands);
    }

    public static List<String> getPrintedStrings(List<List<String>> commands) {
        // Write your code here
        List<String> result = new ArrayList<>();
        StringBuilder sBuilder = new StringBuilder();
        int cursor = 0;
        for (List<String> list : commands) {
            String comandString = list.get(0);
            switch (comandString) {
                case "Insert" -> {
                    // [91, 87) -> out of range for 87
                    sBuilder.insert(cursor, list.get(1));
                    cursor += list.get(1).length();
                    if (cursor > sBuilder.length()) {
                        cursor = sBuilder.length();
                    }
                }
                case "Print" -> {
                    // 2, (-2, 6)->(0, 3)
                    int startIndex = cursor - Integer.parseInt(list.get(1));
                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    int endIndex = cursor + Integer.parseInt(list.get(1));
                    if (endIndex > sBuilder.length()) {
                        endIndex = sBuilder.length();
                    }
                    String s = sBuilder.substring(startIndex, endIndex);
                    result.add(s);
                    System.out.println(s);
                }
                case "Left" -> {
                    int l = Integer.parseInt(list.get(1));
                    cursor -= l;
                    if (cursor < 0) {
                        cursor = 0;
                    }
                }
                case "Right" -> {
                    int r = Integer.parseInt(list.get(1));
                    cursor += r;
                    if (cursor > sBuilder.length()) {
                        cursor = sBuilder.length();
                    }
                }
                case "Backspace" -> {
                    int count = Integer.parseInt(list.get(1));
                    while (count > 0 && cursor > 0) {
                        sBuilder.deleteCharAt(cursor - 1);
                        count--;
                        cursor--;
                    }
                    if (cursor < 0) {
                        cursor = 0;
                    }
                }
                case "Delete" -> {
                    int count = Integer.parseInt(list.get(1));
                    while (count > 0) {
                        sBuilder.deleteCharAt(cursor);
                        count--;
                    }
                }
            }
        }
        return result;
    }
}
