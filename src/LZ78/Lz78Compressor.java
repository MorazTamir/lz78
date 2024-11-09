/**
 * Assignment 3
 * Submitted by: 
 * Student 1. Moraz Tamir 	
 * Student 2. Ninel Benyish	
 */

package LZ78;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class Lz78Compressor {
	HashMap<String, Integer> compressDictionary;
	HashMap<Integer, String> decompressDictionary;
	FileInputStream input;
	FileOutputStream output;

	public Lz78Compressor() {
		compressDictionary = new HashMap<String, Integer>();
		decompressDictionary = new HashMap<Integer, String>();
	}

	// limit by size of substring
	public String compress(String input_name, String output_name, int limit) {
		try {
			File file_in = new File(input_name);
			output = new FileOutputStream(output_name);
//			String out = "";

			byte[] data = readFromFile(file_in, input);

			for (int i = 0; i < data.length; i++) {
				char c = (char) data[i];
				String prefix = "";
				// to check if we need (i < data.length)
				while (i < data.length && compressDictionary.containsKey(prefix + c) && (prefix + c).length() < limit) {
					prefix += c;
					i++;
					if (i < data.length) {
						c = (char) data[i];
					} else {
						break;
					}
				}
				int index;

				if (i < data.length && compressDictionary.containsKey(prefix)) {
					index = compressDictionary.get(prefix);
					compressDictionary.put(prefix + c, compressDictionary.size() + 1);
				} else {
					index = 0;
					if (!compressDictionary.containsKey(String.valueOf(c)))
						compressDictionary.put(String.valueOf(c), compressDictionary.size() + 1);
				}
//				out += "(" + String.valueOf(index) + ", " + c + "),";
				// +48 will show the number as ascii code

				output.write((byte) (index - 128));
				output.write(c);

//				System.out.println(out);

				// limit the size of dictionary
				if (compressDictionary.size() > 250) {
					compressDictionary.clear();
				}

			}

//			System.out.println(compressDictionary);
			System.out.println("Compressed!");
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public byte[] readFromFile(File file, FileInputStream input) throws IOException {
		input = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		input.read(data);
		input.close();
		return data;
	}

	public String decompress(String input_name, String output_name) {
		try {
			File file_in = new File(input_name);
			output = new FileOutputStream(output_name);
//			String out = "";

			byte[] data = readFromFile(file_in, input);
			int dictionaryIndex = 1;

			for (int i = 0; i < data.length; i++) {
				int index = data[i] + 128;
				i++;
				char c = (char) data[i];
				if (decompressDictionary.get(index) != null) {
					decompressDictionary.put(dictionaryIndex, decompressDictionary.get(index) + String.valueOf(c));
				} else {
					decompressDictionary.put(dictionaryIndex, String.valueOf(c));
				}
				String letters = decompressDictionary.get(dictionaryIndex);
				for (int j = 0; j < letters.length(); j++) {
					output.write(letters.charAt(j));
				}

//				out += decompressDictionary.get(dictionaryIndex);
				dictionaryIndex++;
				if (decompressDictionary.size() > 250) {
					decompressDictionary.clear();
					dictionaryIndex = 1;
				}

			}
//			System.out.println(out);
//
//			System.out.println(decompressDictionary);
			System.out.println("Decompressed!");
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
