package com.demo.algorithms.path;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShortestPathService {

	public int shortestPath(Node node) {
		
		var toSaveMinValue = new int[1];
		toSaveMinValue[0] = Integer.MAX_VALUE;
		
		log.info("now its in node: {}", node.number);
		
		//starting the algorithm
		var m = shortestPath(node, node.number, toSaveMinValue, node.number);
		
		log.info("shortest path is total value is {}:", m[0]);
		
		return m[0];
	}
	
	/**
	 * 
	 * @param node actual node that i am
	 * @param total value to that node
	 * @param toSaveMinValue where the min value is saved  
	 * @param before just to inform where the algorithm is going back
	 * @return
	 */
	private int[] shortestPath(Node node, int total, int[] toSaveMinValue, int before) {		
		
		var nodes = node.getNodes();
		
		if (nodes.size() == 0) {
			if (total < toSaveMinValue[0]) {
				toSaveMinValue[0] = total;
			}
			return toSaveMinValue;
		}
		
		var minValue = new int[1];
		for (int i = 0; i < nodes.size(); i++) {
			log.info("now its in node: {}", nodes.get(i));
			
			//recursive call to go throw the elements of the list
			minValue = shortestPath(nodes.get(i), nodes.get(i).number + total, toSaveMinValue, nodes.get(i).number);
			//if the code is here is because there are no more elements forward so its going back
			
			log.info("now goes back to: {}", before);
			
		}
		
		return minValue;
	}
	
	
}
