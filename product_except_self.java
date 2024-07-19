// Time Complexity : O(n)  ... n is number of elements in array           
// Space Complexity : O(m) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leet code : https://leetcode.com/problems/product-of-array-except-self/

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Code Explanation
BruteForce : Do the nested iterations for finding the product except where the number is , which will give n^2

// Time Complexity : O(3n) == O(n)  ... n is number of elements in array       
                        3n because 1 pass for getting left product, 1 pass for getting right product and 1 pass for the multiplication in them    
// Space Complexity : O(3n) == O(n) 

running product is used.
leftProduct stores the running product on left side of each element.
if          nums = [2, 3, 4, 5]
then leftProduct = [1, 2, 6, 24]
                    |  |
                    |  |--> on left side of 3 there is only one number i.e. 2 and the running product was 1, 
                            so the new product becomes 1*2 = 2
                    |
                    |-----> there is no number on left side of 2; therefore default value is kept 1

similarly, rightProduct = [60, 20, 5, 1]

Now, the product between leftProduct and righProduct elements gives the final answer.
result = [1*60, 2*20, 6*5, 24*1]
       = [60, 40, 30, 24]
*/


public class product_except_self {
    public int[] pr_except_self(int []nums){
        int n = nums.length;
        int rp = 1; // intialize the rp to 1
        int [] result = new int[n];
        result[0] = 1; // initialize the 0 index to 1

        // left product
        for (int i = 1; i<n;i++){ // start from 2nd element at index 1
               rp = rp * nums[i-1]; // calculate the running product from previous index
               result[i] = rp; // place the left product
        }
        //right product and multiply in place with left product
        rp = 1;
        for(int i = n-2; i>=0 ; i --){
                rp = rp * nums[i+1];            // calculate the right product
                result[i] = result[i]*rp;        // multiply the left  & right prod 
        }
        return result;
    }
}
