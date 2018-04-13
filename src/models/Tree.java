package models;

public class Tree {
	
	private Node root;
	private String text;
	
	public Tree(String text) {
		root = Tree.createNode(text);
	}
	
	public void setText(String letter){
		text += letter;
	}
	
	public String getText() {
		return text;
	}

	public void addChildToRoot(String word, Node actual){
		if (!word.isEmpty()) {
			if (!actual.searchNodeByInformation(word.substring(0, 1))) {
				Node newNode = Tree.createNode(word.substring(0, 1));
				actual.addNode(newNode);
				addChildToRoot(word.substring(1, word.length()), newNode);
			}else{
				Node a = actual.getNodeByInformation(word.substring(0, 1));
				a.setValue();
				addChildToRoot(word.substring(1,  word.length()), a);
			}
		}
	}

	public Node getRoot() {
		return root;
	}
	
	public static Node createNode(String information){
		return new Node(information);
	}
}