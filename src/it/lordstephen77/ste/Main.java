/*
 * STE (Script Text Editor)
 * Copyright (C) 2017 Stefano Peris
 * This file is distributed under the same license as the Script Text Editor package.
 */

package it.lordstephen77.ste;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

import java.io.*;

public class Main extends JFrame implements ActionListener {

    RSyntaxTextArea textArea = new RSyntaxTextArea(20, 40);
    
    JFrame frame = new JFrame("Input Dialog Box Frame");
    JButton button = new JButton("Show Input Dialog Box");
    JFileChooser fc = new JFileChooser();

    // variables
    private JTextArea ta;
    private int count;
    private JMenuBar menuBar;
    private JMenu fileM;
    private JMenu editM;
    private JMenu infoM;
    private JMenuItem exitI, saveI, aboutI;
    private String pad;
    private JToolBar toolBar;

    public Main() {

        super("Script Text Editor");
        setSize(900, 600); // set window resolution
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jpanel = new JPanel(new BorderLayout());
        
        textArea.setFont(new Font("default", Font.BOLD, 14)); // set a default font for the TextArea
        textArea.setCodeFoldingEnabled(true); // set codefolding
        textArea.setBracketMatchingEnabled(true); // set bracket matching
        textArea.setAutoIndentEnabled(true); // set autoindent
        textArea.setAntiAliasingEnabled(isEnabled()); // set antialiasing
        textArea.addMouseWheelListener(null); // set mousewheel zoom
        textArea.convertTabsToSpaces(); // convert tabs to spaces
        textArea.setTabSize(4);
  		textArea.setCaretPosition(0);
  		textArea.requestFocusInWindow();
  		textArea.setMarkOccurrences(true);
  		textArea.setCodeFoldingEnabled(true);
  		textArea.setClearWhitespaceLinesEnabled(false);
  		//textArea.setWhitespaceVisible(true);
  		//textArea.setPaintMatchedBracketPair(true);
        RTextScrollPane rscrollpane = new RTextScrollPane(textArea);
        jpanel.add(rscrollpane);
        
        // Displays the default text in the editor (DefaultTextArea class).
        textArea.setText(DefaultTextArea.text);
        
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        /*
         * select default language:
         * 
         * C, CPLUSPLUS, CSHARP, PYTHON, LUA, RUBY, DART, FORTRAN, HTML, CSS, JAVASCRIPT, PHP
         * MAKEFILE, UNIX_SHELL, WINDOWS_BATCH, ASSEMBLER_X86, BBCODE, CLOJURE, D, DELPHI, DOCKERFILE, DTD
         * GROOVY, HOSTS, HTACCESS, INI, JSON, XML, YAML, LATEX, LISP, LESS, MXML, NSIS, PROPERTIES_FILE
         * SCALA, SAS, SQL, TCL, TYPESCRIPT, VISUAL_BASIC, NONE.
         * 
         * Warning: NONE is equivalent to a simple text file (.txt) does not apply any color to the code.
         */
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        pane.add(sp);

        count = 0;
        pad = " ";
        
		ta = new JTextArea(); // textarea

		menuBar = new JMenuBar(); // menubar
		fileM = new JMenu("File"); // file menu
		editM = new JMenu("Edit"); // edit menu
		infoM = new JMenu("Info"); // info menu
		
		exitI = new JMenuItem("Exit");  // menu items on File Menu
		saveI = new JMenuItem("Save");  // menu items on File Menu
		aboutI = new JMenuItem("About");
		toolBar = new JToolBar();
		
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);

		setJMenuBar(menuBar);
		menuBar.add(fileM); // "File" on the menu bar
		fileM.add(saveI); // "Save" on the menu item for File
		fileM.add(exitI); // "Exit" on the menu item for File
		
		//menuBar.add(editM);
		
		menuBar.add(infoM);
		infoM.add(aboutI); // "About" on the menu bar

		saveI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

		pane.add(toolBar,BorderLayout.NORTH);

		saveI.addActionListener(this);
		exitI.addActionListener(this);
		aboutI.addActionListener(this);

		setVisible(true);

	}

void writetofile(File ff) throws Exception {
	
    FileWriter fw = new FileWriter(ff.getAbsoluteFile());
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(textArea.getText());
    bw.close(); 
}
private static void printLines(String name, InputStream ins) throws Exception {
    String line = null;
    BufferedReader in = new BufferedReader(
        new InputStreamReader(ins));
    while ((line = in.readLine()) != null) {
        System.out.println(name + " " + line);
    }
}
private static void runProcess(String command) throws Exception {
	
    Process pro = Runtime.getRuntime().exec(command);
    printLines(command + "\n============================================================\nOUTPUT:\n\n\n\n",
    		pro.getInputStream());
    
    printLines(command + " stderr:", pro.getErrorStream());
    pro.waitFor();
}

@Override
public void actionPerformed(ActionEvent e) {
	
    JMenuItem choice = (JMenuItem) e.getSource();

    // save file
    if (choice == saveI) {
    	
       int returnVal = fc.showSaveDialog(Main.this);

       if (returnVal == JFileChooser.APPROVE_OPTION) {
	       try {
	    	   
	           File file = fc.getSelectedFile();
	           writetofile(file);
	       }
	       
	       catch(Exception esa) {
	    	   
	       }
       }    
   }
    
    // quit program
	else if (choice == exitI) {
		
       System.exit(0);
	}
    
 else if(choice == aboutI) {
	 
  	 JOptionPane.showMessageDialog(null,"Script Text Editor.\n\n"
  	 		+ "By Stefano Peris (c) 2017","Script Text Editor",1);
  	 }

}

	public static void main(String[] args) {
		
		// implements the native system look
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			
		}
		
    	new Main();
	}

}
	
      
