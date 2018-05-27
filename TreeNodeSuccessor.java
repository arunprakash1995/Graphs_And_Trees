package GraphsAndTrees;

import java.util.LinkedList;

import javax.xml.soap.Node;

public class TreeNodeSuccessor {

	public static TreeNode findSuccessor(TreeNode node){
		if(node==null) return null;
		if(node.right != null){
			return minRightSubtree(node.right);
		}
		else if(node.parent.left == node){
			return node.parent;
		}
		else{
			return findSucc(node);
		}
	}

	public static TreeNode minRightSubtree(TreeNode node){
		while(node.left!=null){
			node = node.left;
		}
		return node;
	}

	public static TreeNode findSucc(TreeNode node){
		TreeNode parent = node.parent;
		while(parent != null && parent.left!=node){
			node=parent;
			parent = node.parent;
		}
		return parent;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		TreeNode root = BuildBSTFromArray.buildBST(array);
		TreeNode n = findSuccessor(root);
		System.out.println("\nsuccessor of " + root.data + " is " + findSuccessor(root).data);
		System.out.println("successor of " + n.data + " is " + findSuccessor(n).data);

		
	}
}


