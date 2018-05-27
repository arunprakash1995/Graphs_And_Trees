package GraphsAndTrees;

import java.util.LinkedList;

public class CheckTreeBalance {
	public static boolean checkBalance(TreeNode root){
		if(root==null) return true;
		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);
		if(Math.abs(leftHeight-rightHeight)>1){
			return false;
		}
		return checkBalance(root.left)&&checkBalance(root.right);
	}

	public static int findHeight(TreeNode n){
		if(n==null)return -1;
		int height= Math.max(findHeight(n.left),findHeight(n.right))+1;
		return height;	
	}

	public static int checkHeight(TreeNode n){
		if(n==null) return -1;
		int leftHeight = checkHeight(n.left);
		if(leftHeight==Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		int rightHeight = checkHeight(n.left);
		if(rightHeight==Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		if(Math.abs(leftHeight-rightHeight)>1){
			return Integer.MIN_VALUE;
		}
		return Math.max(leftHeight,rightHeight)+1;
	}

	public static boolean checkBal(TreeNode root){
		if(checkHeight(root)==Integer.MIN_VALUE){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		TreeNode root = BuildBSTFromArray.buildBST(array);
		LinkedList<LinkedList<TreeNode>> list = TreeLayers.findLayers(root);
		TreeLayers.printResult(list);
		System.out.println("\nIs the Tree Balanced ? "+checkBalance(root));
	}
}
