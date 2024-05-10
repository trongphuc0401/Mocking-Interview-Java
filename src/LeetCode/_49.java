package LeetCode;

import java.util.*;

public class _49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String word : strs) {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);

            String sortedWord = new String(ch);

            if(!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());

            }
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }

}
