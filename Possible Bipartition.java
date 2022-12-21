class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> a = 
        new ArrayList<ArrayList<Integer>>();
        int[] color = new int[n+1];
        for(int i=0;i<=n;i++){
            a.add(new ArrayList<Integer>());
        }
        for(int[] i: dislikes){
            a.get(i[0]).add(i[1]);
            a.get(i[1]).add(i[0]);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
            if(color[i]==0){
                color[i] = 1;
                q.add(i);
                while(!q.isEmpty()){
                    int front = q.poll();
                    for(int j : a.get(front)){
                        if(color[j] == color[front]) return false;
                        if(color[j] == 0){
                            color[j] = -color[front];
                            q.add(j);
                        }
                    }
                }
            }          
        }   
        return true; 
    }
}
