package models;

import java.util.ArrayList;

public class Tree {
	
	private Node root;
	
	public Tree(String text) {
		root = Tree.createNode(text, null);
	}
	
	public void addChildToRoot(String word, Node actual){
		if (!word.isEmpty()) {
			if (!actual.searchNodeByInformation(word.substring(0, 1))) {
				Node newNode = Tree.createNode(word.substring(0, 1), actual);
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
	
	public static Node createNode(String information, Node father){
		return new Node(information, father);
	}	
	
	public ArrayList<Node> getWords(String word, ArrayList<Node> nodes){
		for (Node node : nodes) {
			if (word.length() <= 1) {
				if (node.getInformation().equals(word)) {
					return node.getNodeList();
				}
			}else{
				if (node.getInformation().equals(word.substring(0, 1))) {
					return getWords(word.substring(1, word.length()), node.getNodeList());
				}
			}
		}
		return nodes;
	}
	
	public String getStringBefore(Node n){
		String t = n.getInformation();
		Node actual = n;
		while(actual.getFather() != root){
			t = actual.getFather().getInformation() + t;
			actual = actual.getFather();
		}
		return t;
	}
	
	public ArrayList<String> getStringAfter(Node n){
		ArrayList<String> texts = new ArrayList<>();
		if (n.getNodeList().isEmpty()) {
			return null;
		}else{
			ArrayList<Node> nodes = n.getNodeList();
			for (Node node : nodes) {
				ArrayList<String> a = getStringAfter(node);
				for (String string : a) {
					string = n.getInformation() + string;
				}
				texts.addAll(a);
			}
		}
		return texts;
	}
}