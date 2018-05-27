package GraphsAndTrees;

import java.util.HashMap;
import java.util.LinkedList;

public class PathSum{
	public static int find(int sum,TreeNode node){
		if(node==null) return 0;
		HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
		return find(node,mp,0,sum);
	}
	
	public static int find(TreeNode node,HashMap<Integer,Integer> mp,int rs,int sum){
		if(node==null) return 0;
		int runSum= rs+node.data;
		int x = runSum-sum;
		int totalPath = mp.getOrDefault(x,0);
		
		if(runSum==sum){
			++totalPath;
		}
		
		addToMap(mp,runSum,1);
		totalPath += find(node.left,mp,runSum,sum);
		totalPath += find(node.right,mp,runSum,sum);
		addToMap(mp,runSum,-1);

		return totalPath;
	}

	public static void addToMap(HashMap<Integer,Integer> mp,int rs,int cnt){
		int ct = mp.getOrDefault(rs,0)+cnt;
		if(cnt==0){
			mp.remove(rs);
		}
		else{
			mp.put(rs,cnt);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5};

		// We needed this code for other files, so check out the code in the library
		TreeNode root = BuildBSTFromArray.buildBST(array);
		LinkedList<LinkedList<TreeNode>> list = TreeLayers.findLayers(root);
		System.out.println(find(5,root));
		String str="AS";
		String s = "AS";
		String p =s;
		p="ASD";
		System.out.println(str.equals(s));
	}
}
