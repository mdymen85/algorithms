package com.demo.algorithms.path;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Node {

	List<Node> nodes = new ArrayList<Node>();
	int number;
	
	public Node() {}
	
	public Node(int number) {
		this.number = number;
	}
	
	public Node(List<Node> nodes) {
		this.nodes = nodes;
	}
	
	public void addNode(Node node) {
		this.nodes.add(node);
	}
	
	public List<Node> getNodes() {
		return this.nodes;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.number);
	}
	
}
