class Solution
{
	int  select(int arr[], int i)
	{
        int min = i;
        for(int j = i + 1; j < arr.length; j++){
            if(arr[j] < arr[min]){
                min = j;
            }
        }
        return min;
	}
	
	void selectionSort(int arr[], int n)
	{
	    for(int i = 0; i < n - 1; i++){
	        int min = select(arr, i);
	        if(min != i){
	            swap(arr, min, i);
	        }
	    }
	}
	static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
