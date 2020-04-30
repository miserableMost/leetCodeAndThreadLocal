package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeSet_TreeMap {
    public static void printHighChangeables(Map<String, List<String>> adjWords, int minWords){
        for (Map.Entry<String, List<String>> entry : adjWords.entrySet()) {
            List<String> words = entry.getValue();
            if(words.size() >= minWords){
                System.out.println(entry.getKey()+" (");
                System.out.println(words.size()+"):");
                for (String w : words) {
                    System.out.println(" "+w);
                }
                System.out.println();
            }
        }
    }
    private static boolean oneCharOff(String word1,String word2){
        if(word1.length() != word2.length())
            return false;
        int diffs = 0;
        for (int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i))
                if(++diffs> 1)
                    return false;
        }
        return diffs == 1;
    }
    public static Map<String,List<String>> computeAdjacentWords(List<String> theWords){
        Map<String,List<String>> adjWords = new TreeMap<>();
        Map<Integer,List<String>> wordsByLength = new TreeMap<>();
        for (String w : theWords) {
            update(wordsByLength,w.length(),w);
        }
        for (List<String> groupsWords : wordsByLength.values()) {
            String[] words = new String[groupsWords.size()];
            groupsWords.toArray(words);
            for (int i = 0; i < words.length; i++) {
                for (int j = i+1; j < words.length; j++) {
                    if(oneCharOff(words[i],words[j])){
                        update(adjWords,words[i],words[j]);
                        update(adjWords,words[j],words[i]);
                    }
                }
            }
        }
        return adjWords;
     }

    private static void update(Map<Integer, List<String>> m, int key, String value) {
        List<String> lst = m.get(key);
        if(lst == null){
            lst = new ArrayList<>();
            m.put(key,lst);
        }
        lst.add(value);
    }

    private static void update(Map<String, List<String>> m, String key, String value) {
          List<String> lst = m.get(key);
          if(lst == null){
              lst = new ArrayList<>();
              m.put(key,lst);
          }
          lst.add(value);
    }
}
