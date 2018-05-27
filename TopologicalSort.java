package GraphsAndTrees;

import java.util.ArrayList;
import java.util.Stack;

import GraphsAndTrees.Node.State;

public class TopologicalSort {


	public static Stack<Node> buildOrder(ArrayList<Node> nodes){
		if(nodes==null) return null;
		Stack<Node> st = new Stack<Node>();
		for(Node n:nodes){
			if(n.visit==State.unvisited){
				if(!doDFS(n,st))
					return null;
			}
		}
		return st;
	}
	public static boolean doDFS(Node n,Stack<Node> st){
		n.visit= State.visited;
		for(Node a:n.getAdjacent()){
			if(a.visit==State.unvisited){
				doDFS(a,st);
			}
			else{
				return false;//cycle
			}
		}
		st.push(n);
		return true;
	}
	
	public static void main(String a[])
	{
		Graph g = Graph.createNewGraph();
		System.out.println(Finder.pathExists(g, g.getVertex(3), g.getVertex(5)));
		ArrayList<Node> lst = new ArrayList<Node>();
		for(Node n:g.vertices) {
			lst.add(n);
		}
		Stack<Node> st = buildOrder(lst);
		System.out.println(st);
	}

}
