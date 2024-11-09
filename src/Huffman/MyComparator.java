/**
 * Assignment 1
 * Submitted by: 
 * Student 1. Moraz Tamir 	
 * Student 2. Ninel Benyish	
 */

package Huffman;

import java.util.Comparator;

// copied from the internet(geeksforgeeks)
class MyComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		return o1.freq - o2.freq;
	}

}