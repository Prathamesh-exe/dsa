// https://leetcode.com/problems/happy-number/
public class HappyNumber {
    public static  boolean isHappy(int n) {
        int slow=square(n);
        int fast=square(square(n));
        while(slow!=fast){
            slow=square(slow);
            fast=square(square(fast));
            if(slow==1 || fast ==1) return true;
        }
        return slow==1;
    }
    public static  int square(int n){
        int square=0;
        while(n>0){
           int digit=n%10;
           square+=digit*digit;
           n=n/10;
        }
        return square;
    }
    public static void main(String[] args) {
        int n=2;
        boolean result=isHappy(n);
        System.out.println("Is "+n+" a happy number? "+result);
    }
}