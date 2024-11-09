/**
 * Assignment 3
 * Submitted by: 
 * Student 1. Moraz Tamir 	
 * Student 2. Ninel Benyish	
 */

package main;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Huffman.HufEncoderDecoder;
import LZ78.Lz78Compressor;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class GuiForP extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String IN_FILE_PATH = "OnTheOrigin.txt";

	// Initial settings

	private JLabel screen;
	private ImageIcon background = new ImageIcon(GuiForP.class.getResource("/BackGr.jpg"));

	final String NAMES_STUDENT = "Ninel Benyush & Moraz Tamir";
	final Color WHITE_COLOR = new Color(0xffffff);
	final Font FONT_CHECKBOX = new Font(Font.SANS_SERIF, Font.BOLD, 15);
	final int WIDTH = 540;
	final int HEIGHT = 360;

	// creat buttons
	private JButton start = new JButton("START");

	private JButton upload_file = new JButton("Upload file");
	private JTextField file_path = new JTextField();
	private JButton save_file = new JButton("Save file");

	private JLabel limit_comment = new JLabel("Limit String:");
	private JTextField value_limit = new JTextField();

	// create check-box chose compress or decompress
	private JRadioButton compress = new JRadioButton("COMPRESS");
	private JRadioButton decompress = new JRadioButton("DECOMPRESS");
	private ButtonGroup buttonsGroup = new ButtonGroup();

	// create check-box chose type compressing
	JRadioButton Lz78Only = new JRadioButton("LZ78", false);
	JRadioButton lzAndHuffman = new JRadioButton("LZ78 & HUFFMAN", false);
	ButtonGroup typeGroup = new ButtonGroup();

	public GuiForP() {
		// Determining locations
		screen = new JLabel(background);
		screen.setLayout(null);
		screen.setSize(WIDTH, HEIGHT);
		ImageIcon image = new ImageIcon(GuiForP.class.getResource("/logo.png"));
		setIconImage(image.getImage());

		// Adding our names
		screen.setIconTextGap(-40);
		screen.setText(NAMES_STUDENT);
		screen.setHorizontalTextPosition(JLabel.CENTER);
		screen.setVerticalTextPosition(JLabel.TOP);
		screen.setForeground(WHITE_COLOR);
		screen.setFont(new Font("MV Boli", Font.PLAIN, 20));

//		// Adding positions of Buttons
		start.setBounds(340, 260, 120, 30);
		screen.add(start);

		upload_file.setBounds(340, 100, 120, 30);
		screen.add(upload_file);
		file_path.setBounds(100, 105, 190, 20);
		screen.add(file_path);

		// Limit for String in dictionary
		limit_comment.setBounds(100, 130, 100, 30);
		limit_comment.setForeground(WHITE_COLOR);
		limit_comment.setFont(FONT_CHECKBOX);
		value_limit.setBounds(200, 130, 60, 20);
		screen.add(limit_comment);
		screen.add(value_limit);

		// Adding check-box in panel
		// first panel
		compress.setBounds(340, 170, 175, 15);
		decompress.setBounds(340, 200, 175, 15);
		buttonsGroup.add(compress);
		buttonsGroup.add(decompress);
		compress.setOpaque(false);
		compress.setForeground(WHITE_COLOR);
		compress.setFont(FONT_CHECKBOX);
		decompress.setOpaque(false);
		decompress.setForeground(WHITE_COLOR);
		decompress.setFont(FONT_CHECKBOX);

		screen.add(compress);
		screen.add(decompress);

		// second panel
		Lz78Only.setBounds(80, 170, 70, 15);
		lzAndHuffman.setBounds(80, 200, 175, 15);
		typeGroup.add(Lz78Only);
		typeGroup.add(lzAndHuffman);
		Lz78Only.setOpaque(false);
		Lz78Only.setForeground(WHITE_COLOR);
		lzAndHuffman.setOpaque(false);
		Lz78Only.setFont(FONT_CHECKBOX);
		lzAndHuffman.setForeground(WHITE_COLOR);
		lzAndHuffman.setFont(FONT_CHECKBOX);
		start.addActionListener(this);

		screen.add(Lz78Only);
		screen.add(lzAndHuffman);

//		value_limit.addActionListener((new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//		        String number = value_limit.getText();  
//		        int num = Integer.parseInt(number);
//			}
//
//		}));

		upload_file.addActionListener((new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JFileChooser chooser = new JFileChooser();// parameterised constructor
															// JFileChooser( file ) is called.
				int state = chooser.showSaveDialog(null); // opening the saved dialogue
				// save the file in state
				File SelectedFile = chooser.getSelectedFile();
				String filePath = SelectedFile.getAbsolutePath();
				file_path.setText(filePath);
				
				
			    String nameToReturn = SelectedFile.getName();
				file_path.setText(nameToReturn);
				System.out.println(nameToReturn);
				String nameToReturn2 = nameToReturn.substring(nameToReturn.length() - 4);
				nameToReturn2 = nameToReturn.substring(0,nameToReturn.length() - 4) +'2'+ nameToReturn2;
				System.out.println(nameToReturn2);
			}

		}));

		// Default setting
		add(screen);
		setSize(WIDTH, HEIGHT + 30);
		setTitle("LZ78 Compressor");
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Lz78Compressor comp = new Lz78Compressor();
		HufEncoderDecoder compHu = new HufEncoderDecoder();

		String number = value_limit.getText();
		int num = Integer.parseInt(number);


			if (Lz78Only.isSelected() && compress.isSelected()) {
				comp.compress("OnTheOrigin.txt", "test.txt", num);
				JOptionPane.showMessageDialog(this, "You Chose: LZ78 COMPRESS\nLimit string: " + num);

			}

			if (lzAndHuffman.isSelected() && compress.isSelected()) {
				comp.compress("OnTheOrigin.txt", "test.txt", num);
				compHu.Compress(new String[] { "test.txt" }, new String[] { "test.txt.lz78" });
				JOptionPane.showMessageDialog(this, "You Chose: LZ78 & HUFFMAN COMPRESS\nLimit string: " + num);
			}



			if (Lz78Only.isSelected() && decompress.isSelected()) {
				compHu.Decompress(new String[] { "test.txt.lz78" }, new String[] { "test2.txt" });
				JOptionPane.showMessageDialog(this, "You Chose: LZ78 DECOMPRESS.");

			}

			if (lzAndHuffman.isSelected() && decompress.isSelected()) {
				compHu.Decompress(new String[] { "test.txt.lz78" }, new String[] { "test2.txt" });
				comp.decompress("test2.txt", "OnTheOrigin2.txt");
				JOptionPane.showMessageDialog(this, "You Chose: LZ78 & HUFFMAN DECOMPRESS.");
			}
	}
}
