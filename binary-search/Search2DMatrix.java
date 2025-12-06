// https://leetcode.com/problems/search-a-2d-matrix/

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while(left<=right){
            int mid =left + (right - left) / 2;
            int midMatrixValue = matrix[mid / col][mid % col];
            if(midMatrixValue == target){
                return true;
            }else if(midMatrixValue < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
