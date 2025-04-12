package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber obj = new LetterCombinationsOfAPhoneNumber();
        System.out.println(obj.letterCombinations("23")); // Expected: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    }

    List<String> result = new ArrayList<>();
    Map<Character, String> keypad = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return result;
        }
        generateCombination(digits, 0, new StringBuilder());
        return result;
    }

    private void generateCombination(String digits, int currentIndex, StringBuilder currentCombination) {
        if (currentIndex == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        char currentDigit = digits.charAt(currentIndex);
        String letterOptions = keypad.get(currentDigit);

        for (int i = 0; i < letterOptions.length(); i++) {
            char letter = letterOptions.charAt(i);
            currentCombination.append(letter);
            generateCombination(digits, currentIndex + 1, currentCombination);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}
