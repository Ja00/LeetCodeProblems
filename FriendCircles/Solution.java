//The matrix describes a bi-directional graph.
//Just do the dfs for every person.

class Solution {
    
    public int findCircleNum(int[][] M) {
    	boolean[] visited = new boolean[M.length];
    	int ans = 0;

    	for(int i = 0; i < M.length; i++) {
    		if(visited[i] == false){
    			dfs(M, i, visited);
    			ans++;
    		}
    	}
    	return ans;
	}

	public void dfs(int[][] M, int cur, boolean[] visited) {
		for(int i = 0; i < M[cur].length; i++) {
			if(visited[i] == false && M[cur][i] == 1) {
				visited[i] = true;
				dfs(M, i, visited);
			}
		}
	}
}