package MedianOfTwoSortedArrays;

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/
/**************************************************************************
The key point of this problem is to ignore half part of A and B each step 
recursively by comparing the median of remaining A and B:

if (aMid < bMid) Keep [aRight + bLeft]
else Keep [bRight + aLeft]

As the following: time=O(log(m + n)) 
****************************************************************************/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(nums1, 0, nums2, 0, l) + getkth(nums1, 0, nums2, 0, r)) / 2.0;
    }
    
    public double getkth(int[] A, int aStart, int[] B, int bStart, int k){
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);
        
        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 -1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 -1];
        
        if (aMid < bMid){
            return getkth(A, aStart + k/2, B, bStart, k - k/2); // check: aRight + bLeft
        }else{
            return getkth(A, aStart, B, bStart + k/2, k - k/2); // check: bRight + aLeft
        }
    }
}