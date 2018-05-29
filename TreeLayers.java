package GraphsAndTrees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import GraphsAndTrees.Node.State;

public class TreeLayers {
	public static LinkedList<LinkedList<TreeNode>> findLayers(TreeNode root){
		if(root==null) return null;
		LinkedList<LinkedList<TreeNode>> result= new LinkedList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> parent = new LinkedList<TreeNode>();
		parent.add(root);

		while(!parent.isEmpty()){
			result.add((LinkedList<TreeNode>) parent.clone());
			LinkedList<TreeNode> child = new LinkedList<TreeNode>();
			while(!parent.isEmpty()){
				TreeNode n = parent.remove();
				if(n.left != null) {
					child.add(n.left);
				}
				if(n.right !=null) {
					child.add(n.right);
				}
			}
			parent = (LinkedList<TreeNode>) child.clone();
		}
		return result;
	}
	
	public static void printResult(LinkedList<LinkedList<TreeNode>> l) {
		for(LinkedList<TreeNode> t : l) {
			Iterator it = t.iterator();
			System.out.println();
			while(it.hasNext()) {
				TreeNode x=(TreeNode) it.next();
				System.out.print(x.data+ " ");
			}
		}
	}


	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = BuildBSTFromArray.buildBST(array);
		LinkedList<LinkedList<TreeNode>> list = findLayers(root);
		printResult(list);
	}

}
