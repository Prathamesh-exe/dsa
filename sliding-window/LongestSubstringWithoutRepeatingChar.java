// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.*;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int maxLength = lengthOfLongestSubstring(s);

        System.out.println("Length of the longest substring without repeating characters: " + maxLength);
    }

    private static int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int maxLength=0;
        Set<Character> set=new HashSet<>();
        while(right<s.length()){
            char currChar=s.charAt(right);

            //check duplicate
                
            while(set.contains(currChar)){
                set.remove(s.charAt(left));
                left++;
            }

            //if not duplicate calculate length
           set.add(currChar);
           maxLength=Math.max(maxLength,right-left+1);

            //if window==k
            
            right++;

        }
        return maxLength;
    
        
    }
}
