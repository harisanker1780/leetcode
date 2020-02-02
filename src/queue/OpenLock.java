package queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpenLock {
	
	public int openLock(String[] deadends, String target) {
		Queue<Node> queue = new LinkedList<Node>();
		Set<String> visited = new HashSet<String>();
		List<String> deadendList = Arrays.asList(deadends);
		int minMove = -1;
		
		Node start = new Node(0, 0, 0, 0, 0);
		
		if(deadendList.contains(start.toString())) {
			return minMove;
		}
		
		queue.add(start);
		visited.add(start.toString());
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if(target.equals(cur.toString())) {
				if(minMove == -1) {
					minMove = cur.move;
				}
				else if(cur.move < minMove) {
					minMove = cur.move;
				}
			}
			
			if(minMove == -1 || cur.move < minMove) {
				List<Node> neighbours = neighbours(cur, cur.move + 1);
				for(Node node: neighbours) {
					if(!deadendList.contains(node.toString()) && !visited.contains(node.toString())) {
						queue.add(node);
						visited.add(node.toString());
					}
				}
			}
		}
		
		return minMove;
    }
	
	private List<Node> neighbours(Node node, int move) {
		List<Node> neighbours = new ArrayList<Node>();
		
		neighbours.add(new Node((node.w1 + 1) % 10, node.w2, node.w3, node.w4, move));
		neighbours.add(new Node(node.w1, (node.w2 + 1) % 10, node.w3, node.w4, move));
		neighbours.add(new Node(node.w1, node.w2, (node.w3 + 1) % 10, node.w4, move));
		neighbours.add(new Node(node.w1, node.w2, node.w3, (node.w4 + 1) % 10, move));
		neighbours.add(new Node(node.w1 == 0 ? 9 : node.w1 - 1, node.w2, node.w3, node.w4, move));
		neighbours.add(new Node(node.w1, node.w2 == 0 ? 9 : node.w2 - 1, node.w3, node.w4, move));
		neighbours.add(new Node(node.w1, node.w2, node.w3 == 0 ? 9 : node.w3 - 1, node.w4, move));
		neighbours.add(new Node(node.w1, node.w2, node.w3, node.w4 == 0 ? 9 : node.w4 - 1, move));
		return neighbours;
	}
	
	private class Node {
		int w1, w2, w3, w4, move;
		public Node(int w1, int w2, int w3, int w4, int move) {
			this.w1 = w1;
			this.w2 = w2;
			this.w3 = w3;
			this.w4 = w4;
			this.move = move;
		}
		
		@Override
		public String toString() {
			return w1 + "" + w2 + "" + w3 + "" + w4;
		}
	}
	
	public static void main(String[] args) {
		OpenLock solution = new OpenLock();
		
		/*String[] deadends = {"0201","0101","0102","1212","2002"};
		String target = "0202";*/
		
		/*String[] deadends = {"8888"};
		String target = "0009";*/
		
		String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
		String target = "8888";
		
		/*String[] deadends = {"0000"};
		String target = "8888";*/
		
		System.out.println(solution.openLock(deadends, target));
	}
}
