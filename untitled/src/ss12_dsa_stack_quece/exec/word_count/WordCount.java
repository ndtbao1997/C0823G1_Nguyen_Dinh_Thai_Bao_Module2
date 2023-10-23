package ss12_dsa_stack_quece.exec.word_count;

import java.util.TreeMap;

public class WordCount {
    public static void main(String[] args) {
        String word = "Count the number of occurrences of each word in a string using Map";
        String[] arrWord = word.split(" ");
        TreeMap<String, Integer> wordCount = new TreeMap<>();
        for(String x: arrWord){
            x = x.toLowerCase();
            wordCount.put(x, wordCount.getOrDefault(x,0)+1);
        }
        System.out.println(wordCount);
    }
}
