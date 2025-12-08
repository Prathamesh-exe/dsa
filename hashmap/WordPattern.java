// https://leetcode.com/problems/word-pattern/

import java.util.*;

public class WordPattern{
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }
    private static boolean wordPattern(String pattern,String s){
        Map<Character, String> map = new HashMap<>();

        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;

        for(int i = 0; i < pattern.length(); i++){
                char ch = pattern.charAt(i);
                String word = words[i];
                if(map.containsKey(ch) && !map.get(ch).equals(word)){
                    return false;
                }
                if(!map.containsKey(ch) && map.containsValue(word)){
                    return false;
                }
                if(!map.containsKey(ch)){
                    map.put(ch, word);
                }
            }
        return true;
        }
    }
