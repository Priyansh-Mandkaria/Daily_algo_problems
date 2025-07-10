// Last updated: 7/10/2025, 8:59:16 AM
class Solution {
    public int maxSubArray(int[] arr) {
        // brute force -- gone upto 200/210 test case time limit exceed.
        // int max = Integer.MIN_VALUE;
        // for(int i = 0 ; i < arr.length; i++){
        //     for(int j = i ; j < arr.length; j++){
        //         int sum = 0;
        //         for(int k = i ; k <= j; k++){
        //             sum += arr[k];
        //         }
        //         max = Math.max(max,sum);
        //     }
        // }
        // return max;

        // Brute -2 Approch removing 1 loop summation loop . 
        // we do sum tis time in the j loop only . gone upto --test case 205/210
        // int max = Integer.MIN_VALUE;
        // for(int i = 0 ; i < arr.length; i++){
        //     int sum = 0;
        //     for(int j = i ; j < arr.length; j++){
        //         sum +=arr[j];
        //         max = Math.max(max,sum);
        //     }
        // }
        // return max;

        // Moore Voting Algorithm
        long max = Long.MIN_VALUE;
        long sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum > max){
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return (int)max;
    }
}