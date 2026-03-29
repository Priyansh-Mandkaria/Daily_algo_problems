// Last updated: 3/29/2026, 4:07:38 PM
1class Solution {
2    public int maxSubArray(int[] arr) {
3        // brute force -- gone upto 200/210 test case time limit exceed.
4        // int max = Integer.MIN_VALUE;
5        // for(int i = 0 ; i < arr.length; i++){
6        //     for(int j = i ; j < arr.length; j++){
7        //         int sum = 0;
8        //         for(int k = i ; k <= j; k++){
9        //             sum += arr[k];
10        //         }
11        //         max = Math.max(max,sum);
12        //     }
13        // }
14        // return max;
15
16        // Brute -2 Approch removing 1 loop summation loop . 
17        // we do sum tis time in the j loop only . gone upto --test case 205/210
18        // int max = Integer.MIN_VALUE;
19        // for(int i = 0 ; i < arr.length; i++){
20        //     int sum = 0;
21        //     for(int j = i ; j < arr.length; j++){
22        //         sum +=arr[j];
23        //         max = Math.max(max,sum);
24        //     }
25        // }
26        // return max;
27
28        // Kadane -- O(N)
29        int max = Integer.MIN_VALUE;
30        int sum = 0;
31        for(int i = 0; i  < arr.length; i++){
32            sum += arr[i];
33            if(sum > max){
34                max = sum;
35            }
36            if(sum < 0){
37                sum = 0;
38            }
39        }
40        return max;
41    }
42}