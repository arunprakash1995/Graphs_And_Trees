package GraphsAndTrees;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeCommonAncestor {
	public static TreeNode findCommonAnc(TreeNode root, TreeNode p,TreeNode q){
		if(root == null) return null;
		if(!covers(root,p) || !covers(root,q))
			return null;
		return find(root,p,q);
	}

	public static TreeNode find(TreeNode root,TreeNode p,TreeNode q){
		if(root==null || root==p || root ==q) return root;
		boolean LeftP = covers(root.left,p);
		boolean LeftQ = covers(root.left,q);
		TreeNode n;
		if((LeftP&&!LeftQ) || (!LeftP&&LeftQ)){
			return root;
		}
		else if(LeftP && LeftQ){
			n = find(root.left,p,q);
		}
		else{
			n = find(root.right,p,q);
		}
		return n;
	}

	public static boolean covers(TreeNode root, TreeNode n) {
		if(root==null) return false;
		if(root==n) return true;
		return covers(root.left,n) || covers(root.right,n);
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		// We needed this code for other files, so check out the code in the library
		TreeNode root = BuildBSTFromArray.buildBST(array);
		LinkedList<LinkedList<TreeNode>> list = TreeLayers.findLayers(root);
		TreeLayers.printResult(list);
		TreeNode p = root.left;
		TreeNode q = root.left.right.right;
		System.out.println("\ncommon Anc of "+p.data+" & "+q.data+" : " + findCommonAnc(root,p,q).data);
		
	}
}
