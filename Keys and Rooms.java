//By BFS

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] vis = new boolean[rooms.size()];
        vis[0] = true;
        for(int i : rooms.get(0)){
            q.add(i);
            vis[i] = true;
        }
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i : rooms.get(temp)){
                if(vis[i] == false){
                    q.add(i);
                    vis[i] = true;
                }
            }
        }
        for(int i=0;i<vis.length;i++){
            if(vis[i] == false) return false;
        }
        return true;
    }
}
