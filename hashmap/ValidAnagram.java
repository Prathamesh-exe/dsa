// https://leetcode.com/problems/valid-anagram/
import java.util.*;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
    private static boolean isAnagram(String s,String t){
        if(s.length() != t.length()) return false;

        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int c : count){
            if(c != 0) return false;
        }
        return true;
    }
    
      private static boolean isAnagram2(String s,String t){
        if(s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            map.put(ch1, map.getOrDefault(ch1, 0) + 1);
            map.put(ch2, map.getOrDefault(ch2, 0) - 1);
        }
        for(int val : map.values()){
            if(val != 0) return false;
        }
        return true;
    }
}
