package GraphsAndTrees;

import java.util.LinkedList;
import java.util.Queue;

import GraphsAndTrees.Node.State;

public class Finder {

	public static boolean pathExists(Graph g,Node s,Node d){
		if(s==d) return true;
		g.revertStates();
		Queue<Node> q = new LinkedList<Node>();
		s.visit = State.visiting;
		q.add(s);
		while(!q.isEmpty()){
			Node n = q.remove();
			n.visit = State.visited;
			if(n==d){
				g.revertStates();
				return true;
			}
			if(n!=null) {
				for(Node a:n.getAdjacent()){
					if(a.visit==State.unvisited){
						a.visit=State.visiting;
						q.add(a);
					}
				}
			}
		}
		return false;

	}
	public static void main(String a[])
	{
		Graph g = Graph.createNewGraph();
		System.out.println(pathExists(g, g.getVertex(3), g.getVertex(5)));
	}
}
