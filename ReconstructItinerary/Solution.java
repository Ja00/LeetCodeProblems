//Record all the dst for every src, using HashMap
//Do DFS to track a valid path. As all the dsts for a 
//particular src have been sorted, no need to worry about order.

class Solution {
    public List<String> findItinerary(String[][] tickets) {
    	HashMap<String, ArrayList<String>> map = new HashMap<>();

    	for(String[] ticket : tickets) {
    		String key = ticket[0], value = ticket[1];

    		if(map.containsKey(key)) {
    			map.get(key).add(value);
    		} else {
    			ArrayList<String> newList = new ArrayList<>();
    			newList.add(value);
    			map.put(key, newList);
    		}
    	}

    	for(ArrayList<String> list : map.values()) {
    		Collections.sort(list);
    	}

    	ArrayList<String> ans = new ArrayList<>();
    	dfs("JFK", map, ans, tickets.length + 1);
    	return ans;
   	}

   	public boolean dfs(String cur, HashMap<String, ArrayList<String>> map, ArrayList<String> ans, int total) {

   		ans.add(cur);
   		if(ans.size() == total) {
   			return true;
   		}
   		//Don't put the 2nd condition on the 1st position, error.
   		if(!map.containsKey(cur) || map.get(cur).size() == 0) {
   			return false;
   		}

   		ArrayList<String> curList = map.get(cur);

   		//classic DFS block
   		for(int i = 0; i < curList.size(); i++) {
   			String next = curList.remove(i);
   			
   			if(dfs(next, map, ans, total)) {
   				return true;
   			}

   			ans.remove(ans.size() - 1);
   			curList.add(i, next);
   		}
   		return false;
   	}

}