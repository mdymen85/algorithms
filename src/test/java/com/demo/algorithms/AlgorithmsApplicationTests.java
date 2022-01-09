package com.demo.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.algorithms.path.Node;
import com.demo.algorithms.path.ShortestPathService;

@SpringBootTest
class AlgorithmsApplicationTests {

	@Autowired
	private ShortestPathService shortestPathService;
	
	@Test
	void shortestPath() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		
		n1.addNode(n2);
		n2.addNode(n3);
		n1.addNode(n4);
		n4.addNode(n5);
		n2.addNode(n6);
		n6.addNode(n7);
		n4.addNode(n8);
		n4.addNode(n9);
		
		n5.addNode(n7);
		n2.addNode(n5);
		n8.addNode(n9);
		
		int shortestPath = shortestPathService.shortestPath(n1);
		
		assertEquals(6, shortestPath);
		
	}

}
