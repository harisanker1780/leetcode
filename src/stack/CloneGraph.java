package stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		return copy(node, null, new HashMap<Integer, UndirectedGraphNode>());
    }
	
	private UndirectedGraphNode copy(UndirectedGraphNode source, UndirectedGraphNode target, HashMap<Integer, UndirectedGraphNode> created) {
		
		if(source == null) {
			return null;
		}
		
		if(target == null) {
			target = new UndirectedGraphNode(source.label);
			created.put(target.label, target);
		}
		
		for(UndirectedGraphNode neighbour: source.neighbors) {
			if(created.containsKey(neighbour.label)) {
				target.neighbors.add(created.get(neighbour.label));
			}
			else {
				UndirectedGraphNode newNode = copy(neighbour, null, created);
				created.put(newNode.label, newNode);
				target.neighbors.add(newNode);
			}
		}
		
		return target;
	}
	
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
}
