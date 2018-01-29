//Use HashMap to record the already calculated result for every state.


class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <= 0) {
            return true;
        }
        
        if((1+maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        
        return helper(desiredTotal, new int[maxChoosableInteger], new HashMap<String, Boolean>());
    }
    
    public boolean helper(int total, int[] state, HashMap<String, Boolean> map) {
        String cur = Arrays.toString(state);
        if(map.containsKey(cur)) {
            return map.get(cur);
        }
        
        for(int i = 0; i < state.length; i++) {
            if(state[i] == 0) {
                state[i] = 1;
                if(total <= i+1 || !helper(total-(i+1), state, map)) {
                    map.put(cur, true);
                    state[i] = 0;
                    return true;
                }
                state[i] = 0;
            }
        }
        map.put(cur, false);
        return false;
    }
}