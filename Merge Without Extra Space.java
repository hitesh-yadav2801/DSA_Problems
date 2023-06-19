// Using extra space

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        int x = 0, y = 0, i = 0;
        long[] arr = new long[n + m];
        while(x < n && y < m){
            if(arr1[x] < arr2[y]){
                arr[i++] = arr1[x++];
            } else {
                arr[i++] = arr2[y++];
            }
        }
        while(x < n){
            arr[i++] = arr1[x++];
        }
        while(y < m){
            arr[i++] = arr2[y++];
        }
        for(int idx = 0; idx < n + m; idx++){
            if(idx < n){
                arr1[idx] = arr[idx];
            } else {
                arr2[idx - n] = arr[idx];
            }
        }
    }
}
