package models;

import java.util.ArrayList;

public class Node {
	
	private String information;
	private ArrayList<Node> nodeList;
	private int value;
	private Node father;
	
	public Node(String information, Node father) {
		this.information = information;
		this.father = father;
		nodeList = new ArrayList<>();
		value = 0;
	}
	
	public Node getFather() {
		return father;
	}

	public int getValue() {
		return value;
	}
	
	public void setValueForList(int value){
		this.value = value;
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