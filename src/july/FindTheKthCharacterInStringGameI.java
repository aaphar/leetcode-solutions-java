package july;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/
 */
public class FindTheKthCharacterInStringGameI {
    public char kthCharacter(int k) {
        List<Character> ch = new ArrayList();
        ch.add('a');

        while (ch.size() < k) {
            List<Character> temp = new ArrayList<>(ch);
            for (char c : ch) {
                int nextChar = c + 1;
                if (nextChar > 'z') {
                    nextChar = 'a';
                }
                temp.add((char) nextChar);
            }
            ch.addAll(temp);
        }

        return ch.get(k - 1);
    }
}
