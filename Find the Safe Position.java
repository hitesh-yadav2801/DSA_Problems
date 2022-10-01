class Solution {
    static int safePos(int n, int k) {
        List<Integer> list = new LinkedList();
        for(int i=1; i<=n; i++){
            list.add(i);
        }
        int i = 0;
        while(list.size()>1){
            i = (i+k-1)%list.size();
            list.remove(i);
        }
        return list.get(0);
        // code here
    }
}
