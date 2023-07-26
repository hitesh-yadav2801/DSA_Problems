// Brute force will be in O(N^2) where we have to check all the elements in the left and in the right for every index

// Better approach in O(N) time 

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int i = 0;
        while(i < arr.length - 1 && arr[i] < arr[i + 1]){
            i++;
        }
        return i;
    }
}

// Optimal appraoch using binary search

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 1;
        int right = n - 2;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]){
                left = mid + 1;
            } else if(arr[mid] < arr[mid-1] && arr[mid] > arr[mid+1]){
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

