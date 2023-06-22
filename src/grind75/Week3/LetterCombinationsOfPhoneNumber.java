package grind75.Week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    List<String> result = new ArrayList<>();
    Map<Character, List<Character>> map = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
    );

    public void dfs(String digits, int index, String cur) {
        if (index == digits.length()) {
            if (cur.length() > 0) {
                result.add(cur);
            }
            return;
        }

        map.get(digits.charAt(index)).forEach(ch -> dfs(digits, index+1, cur+ch));
    }

    public List<String> letterCombinations(String digits) {
        dfs(digits, 0, "");
        return result;
    }
}
