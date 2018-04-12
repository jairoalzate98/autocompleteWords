package models;

import java.util.ArrayList;

public class Node {
	
	private String information;
	private ArrayList<Node> nodeList;
	
	public Node(String information) {
		this.information = information;
		nodeList = new ArrayList<>();
	}
	
	public void addNode(Node node){
		nodeList.add(node);
	}

	public ArrayList<Node> getNodeList() {
		return nodeList;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@Override
	public String toString() {
		return information;
	}
}