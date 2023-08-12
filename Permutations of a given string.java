class Solution {
    HashSet<String> ansSet = new HashSet<>();
    public List<String> find_permutation(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, ans, new StringBuilder(), new boolean[s.length()]);
        Collections.sort(ans); // Sort the result list lexicographically
        return ans;
    }

    public void backtrack(String s, List<String> ans, StringBuilder temp, boolean[] visited) {
        if (temp.length() == s.length()) {
            if(!ansSet.contains(temp.toString())){
                ans.add(temp.toString());
                ansSet.add(temp.toString());
            }
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.append(s.charAt(i));
                backtrack(s, ans, temp, visited);
                visited[i] = false; // Backtrack by marking the character as unvisited
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
}
