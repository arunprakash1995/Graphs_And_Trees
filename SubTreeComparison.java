package GraphsAndTrees;

import java.util.LinkedList;

public class SubTreeComparison {

	public static boolean findIfSubtree(TreeNode root, TreeNode r){
		if(root==null) return false;
		if(r==null) return true;
		return compare(root,r);
	}

	public static boolean compare(TreeNode root, TreeNode r){
		if(root==null) return false;
		if(root.data == r.data && isMatch(root,r)){
			return true;
		}
		return compare(root.left,r) || compare(root.right,r);
	}

	public static boolean isMatch(TreeNode root,TreeNode r){
		if(root==null&&r==null) return true;
		if(root==null || r==null) return false;
		if(root.data !=r.data) return false;
		return isMatch(root.left,r.left)&&isMatch(root.right,r.right);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5};	
		int[] arr = {1, 2};

		// We needed this code for other files, so check out the code in the library
		TreeNode root = BuildBSTFromArray.buildBST(array);
		TreeNode r = BuildBSTFromArray.buildBST(arr);
		
		System.out.println(findIfSubtree(root,r));
		
	}
}

