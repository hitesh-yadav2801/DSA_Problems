//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        solve(arr, ans, 0, 0);
        Collections.sort(ans);
        return ans;
    }
    public void solve(ArrayList<Integer> arr, ArrayList<Integer> ans, int temp, int idx){
        if(idx >= arr.size()){
            ans.add(temp);
            return;
        }
        solve(arr, ans, temp + arr.get(idx), idx + 1);
        solve(arr, ans, temp, idx + 1);
    }
}
