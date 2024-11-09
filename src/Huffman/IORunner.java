package Huffman;
import java.io.IOException;

/**
 * Assignment 1
 * Submitted by: 
 * Student 1. Moraz Tamir 	
 * Student 2. Ninel Benyish	
 */
public class IORunner {

	static String IN_FILE_PATH = "OnTheOrigin.txt";
	//OnTheOrigin.txt
	//Red_Flowers.bmp
	//Romeo and Juliet  Entire Play.txt
	//Smiley.bmp
	static String ENCODED_FILE = "encoded.txt";
	static String DECODED_FILE = "decoded.txt"; //OUT_FILE_PATH the type file need to be like IN_FILE_PATH


	public static void main(String[] args) throws IOException {
		String[] input = new String[5];
		String[] output = new String[5];
		String[] input1 = new String[5];
		input[0] = IN_FILE_PATH;
		output[0] = ENCODED_FILE;
		HufEncoderDecoder test = new HufEncoderDecoder();
		test.Compress(input, output);
		input1[0] = DECODED_FILE;
		test.Decompress(output, input1);
		
	}
}