package GraphsAndTrees;

import java.util.LinkedList;

public class CheckBST {
	public static boolean check(TreeNode root){
		if(root==null) return true;
		int min = root.data;
		int max = root.data;
		return check(root.left,null,max)&&check(root.right,min,null);
	}

	public static boolean check(TreeNode root,Integer min,Integer max){
		if(root==null)return true;
		if(min!=null && root.data<=min){
			return false;
		}
		if(max!=null && root.data>max){
			return false;
		}
		return check(root.left,min,root.data)&&check(root.right,root.data,max);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		TreeNode root = BuildBSTFromArray.buildBST(array);
		System.out.println("is BST ? " + check(root));
	}
}
