class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if(low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[low];
        int i = low, j = high;
        
        while(i < j){
            while(arr[i] <= pivot && i < high) i++;
            while(arr[j] > pivot && j > low) j--;
            
            if(i < j){
                swap(arr, i, j);
            }
        }
        swap(arr, j, low);
        return j;
    } 
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
