
// Time Complexity : O(n * m)  ... n = row in matrix; m = columns in matrix           
// Space Complexity : O(1) as output space does not count
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leet code : https://leetcode.com/problems/spiral-matrix/

Given an m x n matrix, return all elements of the matrix in spiral order.

Example
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]


Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


Code Explanation
four variables are used to track the limit for each traverse.
After traverse in each direction these variables are updated.

Base condition (left<=right && top<=bottom) need to be checked insie the loop as well;
because there is possibility that those limits are reverted i.e. left>right or top>bottom inside the loop.
(Watch ckass video for details.)

This can also be done using recursion. 
*/

import java.util.ArrayList;
import java.util.List;

public class spiral_matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;          // rows
        int n = matrix[0].length;       //cols

        List<Integer> result = new ArrayList<>();
        int left = 0;
        int top = 0;
        int bottom = m-1;
        int right = n-1;

        // bounds conditions for the traversal are based on left and right do not cross each other & top-bottom do not cross each other.
        while(left <= right && top <= bottom){
            // top row 
            for(int j = left; j>= right ; j++){  // the bounds condition already check this so left and right crossing each other not happen.
                result.add(matrix[top][j]);
            }
            top++;

            // right col
            for(int i = top; i<=bottom; i++){   //
                result.add(matrix[i][right]);
            }
            right--;

            //bottom row
            if(top <= bottom){                  //the top and bottom are changing in above rows and for loop already checks for left and righ hence only top and bottom is present in if condition.
                for(int j=right ; j>= left; j--){
                    result.add(matrix[bottom][j]);
                }
                bottom --;
            }
           
            //left col
            if(left <= right){
                for(int i = bottom ; i>= top ; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }

        }

        return result;
    }
}
