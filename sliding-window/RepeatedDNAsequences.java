// https://leetcode.com/problems/repeated-dna-sequences/description/?envType=problem-list-v2&envId=sliding-window
import java.util.*;

public class RepeatedDNAsequences {
    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s));
    }

    private static List<String> findRepeatedDnaSequences(String s) {
       int left=0;
       int right=10;
       if(s.length()<10)return new ArrayList<>();
       Set<String> seen=new HashSet<>();
       Set<String> result=new HashSet<>();
       for(;right<=s.length();left++,right++){
        String substring=s.substring(left,right);
        if(seen.contains(substring)){
            result.add(substring);
        }else{
            seen.add(substring);
        }
       }
         return new ArrayList<>(result);
    }
    
}
