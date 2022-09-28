class Solution { 
    public int minLength(String s, int n) { 
        
    // 	HashMap<Integer,Integer> map=new HashMap<>();
    // 	map.put(1,2);
    // 	map.put(2,1);
    // 	map.put(3,4);
    // 	map.put(4,3);
    // 	map.put(5,6);
    // 	map.put(6,5);
    // 	map.put(7,8);
    // 	map.put(8,7);
    // 	map.put(0,9);
    // 	map.put(9,0);
    	
    // 	Stack<String> stack = new Stack<>();
    // 	for(int i =0; i< s.length(); i++){
    // 	    stack.push(charAt(i));
    // 	    if
    // 	}
    
    Stack<Integer> stack = new Stack<>();
    int[] pair = {9,2,1,4,3,6,5,8,7,0};
    for(char ch: s.toCharArray()){
        int key = ch - '0';
        if(stack.size() == 0){
            stack.push(key);
        }else{
            if(stack.peek() == pair[key]){
                stack.pop();
            }else{
                stack.push(key);
            }
        }
    }
    return stack.size();
    }
}
