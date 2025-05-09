package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/test/11hj4snj8e7/questions/18e5jjhf3
 */
public class ClosestColor {
    public static List<String> closestColor(List<String> pixels) {
        // Write your code here
        List<String> answer = new ArrayList<>();

        for (String pixel : pixels) {
            List<Integer> numbers = new ArrayList<>();

            int i = 8;
            while (i < 16) {
                int ans = Integer.parseInt(pixel.substring(0,i), 2);
                System.out.println(ans);
                numbers.add(ans);
                i += 8;
            }


            double min = 0;
            String binary_255 = Integer.toBinaryString(255);
            String color = "";

            // black
            double distance = Math.sqrt(
                    Math.pow((numbers.get(0) - 0), 2)
                            + Math.pow((numbers.get(1) - 0), 2)
                            + Math.pow((numbers.get(2) - 0), 2));

            if (distance < min) {
                min = distance;
                color = "000000000000000000000000";
            }

            // white
            distance = Math.sqrt(
                    Math.pow((numbers.get(0) - 255), 2)
                            + Math.pow((numbers.get(1) - 255), 2)
                            + Math.pow((numbers.get(2) - 255), 2));

            if (distance < min) {
                min = distance;
                color = binary_255 + binary_255 + binary_255;
            }

            // red
            distance = Math.sqrt(
                    Math.pow((numbers.get(0) - 255), 2)
                            + Math.pow((numbers.get(1) - 0), 2)
                            + Math.pow((numbers.get(2) - 0), 2));

            if (distance < min) {
                min = distance;
                color = binary_255 + "00000000" + "00000000";
            }

            // green
            distance = Math.sqrt(
                    Math.pow((numbers.get(0) - 0), 2)
                            + Math.pow((numbers.get(1) - 255), 2)
                            + Math.pow((numbers.get(2) - 0), 2));

            if (distance < min) {
                min = distance;
                color = "00000000" + binary_255 + "00000000";
            }

            // blue
            distance = Math.sqrt(
                    Math.pow((numbers.get(0) - 0), 2)
                            + Math.pow((numbers.get(1) - 0), 2)
                            + Math.pow((numbers.get(2) - 255), 2));

            if (distance < min) {
                min = distance;
                color = "00000000" + "00000000" + binary_255;
            }
            answer.add(color);
        }

        return answer;
    }
}
