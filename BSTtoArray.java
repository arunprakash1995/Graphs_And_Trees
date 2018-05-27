package GraphsAndTrees;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTtoArray {
	public static ArrayList<ArrayList<Integer>> findCombination(TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root==null) {
			result.add(new ArrayList<Integer>());
			return result;
		}
		ArrayList<ArrayList<Integer>> leftTree = findCombination(root.left);
		ArrayList<ArrayList<Integer>> rightTree = findCombination(root.right);
		ArrayList<Integer> prefix = new ArrayList<Integer>();
		prefix.add(root.data);

		for(ArrayList<Integer> lt:leftTree){
			for(ArrayList<Integer> rt:rightTree){
				find(lt,rt,result,prefix);
			}
		}
			return result;
		}

		public static void find(ArrayList<Integer> lt,ArrayList<Integer> rt, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> prefix){

			if(lt.size()==0 || rt.size()==0){
				ArrayList<Integer> r = (ArrayList<Integer>) prefix.clone();
				r.addAll(lt);
				r.addAll(rt);
				result.add(r);
				return;
			}

			int lf = (lt).remove(0);
			prefix.add(lf);
			find(lt,rt,result,prefix);
			prefix.remove(prefix.size()-1);
			lt.add(0,lf);

			int rf = rt.remove(0);
			prefix.add(rf);
			find(lt,rt,result,prefix);
			prefix.remove(prefix.size()-1);
			rt.add(0,rf);
		}
		
		public static void main(String[] args) {
			int[] array = {1, 2, 3, 4, 5};

			// We needed this code for other files, so check out the code in the library
			TreeNode root = BuildBSTFromArray.buildBST(array);
			LinkedList<LinkedList<TreeNode>> list = TreeLayers.findLayers(root);
			System.out.println(findCombination(root));
			
		}
	}
