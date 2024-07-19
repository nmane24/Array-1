// Time Complexity : O(n * m)  ... n = row in matrix; m = columns in matrix      as we are traversing the entire matrix. 
// All the rows and all the columns     
// Space Complexity : O(1) ; we are using an array where we store our output, but output space does not count. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//
/*
Leet code : https://leetcode.com/problems/diagonal-traverse/

Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]
Example 2:

Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]


Code Explanation

/*
Explanation : 
Boolean variable is used to track UP or DOWN direction of traversal.
Corner cases/matric edge cases are handled first and then normal scenarion is handled.

In normal UP traverse, i reduces by 1 and j increases by 1.
While handling corner cases, extreme corner is handled first i.e. when i = 0 and j = last column
and then other corner cases are handled i.e. when i = 0. Whenever we hit the corner case
direction is changed.
*/


public class diagonal_traverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;  // rows
        int n = mat[0].length;
        int i = 0; int j = 0;
        int result [] = new int[m*n];
        boolean dir = true;

        for(int idx =0 idx< m*n; idx++){
            result[idx]=mat[i][j];
            if(dir) {       // upward
                if (j == n-1) { // bounds check
                    i++;
                    dir = false;
                }else if(i == 0){
                    j++;
                    dir = false;
                }
                else{
                    j++;
                    i--;
                }
            }
            else{       // downward
                if (i == m-1) {
                    j++;
                    dir = true;
                }
                else if (j == 0) {
                    i++;
                    dir = true;
                }
                else{
                    j--;
                    i++;
                }
            }
        }
        return result;
    }
}
