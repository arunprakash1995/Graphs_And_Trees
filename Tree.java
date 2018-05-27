package GraphsAndTrees;

import java.util.Random;

public class Tree{

	Node root;

	Tree(int v){
		root = new Node(v);
	}
	
	public void add(int a) {
		root.addNode(a);
	}
	
	public Node getRandom() {
		Random r = new Random();
		int n = r.nextInt(root.size);
		return root.getRandom(n);
	}
	
	class Node{
		int data ;
		int size;
		Node left;
		Node right;

		
		
		Node(int data){	
			this.data=data;
			this.size=1;
		}

		public void addNode(int val){
			if(val<=this.data){
				if(this.left==null){
					Node n = new Node(val);
					this.left=n;
				}
				else{
					addNode(val);
				}
			}
			else {
				if(this.right==null){
					Node n = new Node(val);
					this.right=n;
				}
				else{
					addNode(val);
				}
			}
			size++;
		}
		
		public Node getRandom(){
			Random r = new Random();
			int lefts = this.left==null?0:this.left.size;
			int index = r.nextInt(this.size);
			if(index==lefts){
				return this;
			}
			if(index<lefts){
				return this.left.getRandom();
			}
			else{
				return this.right.getRandom();
			}
		}
		
		public Node getRandom(int index){
			int ls = left==null?0:left.size;
			if(index==ls){
				return this;
			}
			if(index<ls){
				return this.left.getRandom(index);
			}
			else{
				return this.right.getRandom(index-(ls+1));
			}
		}
	}

	public static void main(String[] args) {
		Tree t = new Tree(5);
		t.add(3);
		t.add(8);
		System.out.println("randome node : "+ t.getRandom().data);
		
	}
}
