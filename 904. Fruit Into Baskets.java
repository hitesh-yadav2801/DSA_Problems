// using hashmap

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int ans  = 0;
        for(int right = 0; right < fruits.length; right++){
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            if(basket.size() > 2){
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if(basket.get(fruits[left]) == 0){
                    basket.remove(fruits[left]); 
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

// complicated code(not prefered)

class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length==0){
            return 0;
        }
        int res = 1;
        int i = 0;
        while(i<fruits.length){
            int type1 = fruits[i];
            int type2 = -1;
            int j = i+1;
            int curr = 1;
            int index = 0;
            boolean flag = false;
            boolean b = false;
            while(j<fruits.length){
                if(type1 != fruits[j] && type2 == -1){
                    type2 = fruits[j];
                    flag = true;
                    index = j;
                }
                if(type1 == fruits[j] || type2 == fruits[j]){
                    curr++;
                    j++;
                }
                else{
                    b = true;
                    break;
                }
            }
            res = Math.max(res,curr);
            if(flag && b){
                i = index;
            }
            else{
                i = j;
            }
            
        }
        return res;
    }
}
