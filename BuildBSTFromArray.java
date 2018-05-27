package GraphsAndTrees;

public class BuildBSTFromArray {

	public static TreeNode buildBST(int[] array){
		if(array.length==0) return null;
		return buildTree(array,0,array.length-1);
	}

	public static TreeNode buildTree(int[] array,int l,int h){
		if(l>h) return null;
		int mid = (l+h)/2;
		TreeNode n= new TreeNode(array[mid]);
		n.left = buildTree(array,l,mid-1);
		n.right = buildTree(array,mid+1,h);
		return n;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// We needed this code for other files, so check out the code in the library
		TreeNode root = buildBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Created BST? " + root.isBST());
		System.out.println("Height: " + root.height());
	}

}

