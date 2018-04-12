package models;

public class Tree {
	
	private Node root;
	
	public Tree(String text) {
		root = Tree.createNode(text);
	}

	public Node getRoot() {
		return root;
	}
	
	public static Node createNode(String information){
		return new Node(information);
	}
}