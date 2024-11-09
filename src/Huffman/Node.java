/**
 * Assignment 1
 * Submitted by: 
 * Student 1. Moraz Tamir 	
 * Student 2. Ninel Benyish	
 */

package Huffman;

public class Node {
	int freq;
	short ch;
	Node left;
	Node right;

	public Node(short ch, int freq) // constructor for leaf of two character (2-bytes)
	{
		this.freq = freq;
		this.ch = ch;
		left = null;
		right = null;
	}

	public Node(Node left, Node right) // constructor for inside node
	{
		this.freq = left.freq + right.freq;
		this.ch = (short) Float.NaN;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [freq=" + freq + ", ch=" + ch + ", left=" + left + ", right=" + right + "]";
	}
	
	
}