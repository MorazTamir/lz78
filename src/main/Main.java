/**
 * Assignment 3
 * Submitted by: 
 * Student 1. Moraz Tamir 	
 * Student 2. Ninel Benyish	
 */


package main;

import javax.swing.JFrame;

//import Huffman.HufEncoderDecoder;
//import LZ78.Lz78Compressor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Lz78Compressor comp = new Lz78Compressor();
//		HufEncoderDecoder compHu = new HufEncoderDecoder();
//
//		comp.compress("OnTheOrigin.txt", "test.txt", 100);
//		compHu.Compress(new String[] { "test.txt" }, new String[] { "test.txt.lz78" });
//
//		compHu.Decompress(new String[] { "test.txt.lz78" }, new String[] { "test2.txt" });
//		comp.decompress("test2.txt", "OnTheOrigin2.txt");


		JFrame gui = new GuiForP();
		gui.setVisible(true);
	}

}
