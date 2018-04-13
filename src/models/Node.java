package models;

import java.util.ArrayList;

public class Node {
	
	private String information;
	private ArrayList<Node> nodeList;
	private int value;
	
	public Node(String information) {
		this.information = information;
		nodeList = new ArrayList<>();
		value = 0;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue() {
		value++;
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
	
	public Node getNodeByInformation(String information){
		for (Node node : nodeList) {
			if (node.getInformation().equals(information)) {
				return node;
			}
		}
		return null;
	}
	
	public boolean searchNodeByInformation(String information){
		for (Node node : nodeList) {
			if (node.getInformation().equals(information)) {
				return true;
			}
		}
		return false;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@Override
	public String toString() {
		return information + " -> " + value;
	}
}