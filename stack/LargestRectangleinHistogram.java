// https://leetcode.com/problems/largest-rectangle-in-histogram/
import java.util.*;

public class LargestRectangleinHistogram {
    public static void main(String[] args) {
        int[] heights = {9,0};
        System.out.println(largestRectangleArea(heights));
    }
    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n =heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

       //right boundary(right smaller)
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i]=n;
            }else{
                right[i]=stack.peek();
            }
            stack.push(i);
        }

        //clear stack for left boundary
        stack.clear();
        
        //left boundary(left smaller)
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i]=-1;
            }else{
                left[i]=stack.peek();
            }
            stack.push(i);
        }

        int maxArea=0;
        for(int i=0;i<n;i++){
            int width=right[i]-left[i]-1;
            int area=width*heights[i];
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
}
    }
    