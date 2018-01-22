package practiceMedium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};
public class CloneGraph {

	/*
	 * if graph is null, return null
	 * 
	 * use Map to save the original node in graph as key, and create the new copy of node
	 * and save it as value, and dfs each node in graph
	 * 
	 * return all values in map
	 * 
	 * Time: O(n)
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
        	return null;
        }
        Map <UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<> ();
        map.put(node, new UndirectedGraphNode(node.label));
        dfs(node, map);
        return map.get(node);
    }
	
	private void dfs(UndirectedGraphNode node, Map <UndirectedGraphNode, UndirectedGraphNode> map){
		UndirectedGraphNode curr = map.get(node);
		for(UndirectedGraphNode nei : node.neighbors){
			if(!map.containsKey(nei)){
				map.put(nei, new UndirectedGraphNode(nei.label));
				dfs(nei, map);
			}
			curr.neighbors.add(map.get(nei));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
