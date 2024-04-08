class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int count[] = new int[2];
        for(int student : students){
            count[student]++;
        }
        for(int i = 0; i < n; i++){
            int sandwich = sandwiches[i];
            if(count[sandwich] == 0){
                return n - i;
            }
            count[sandwich]--;
        }
        return 0;
    }
}
