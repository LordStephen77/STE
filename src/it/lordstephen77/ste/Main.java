/*
 * STE (Script Text Editor)
 * Copyright (C) 2017 Stefano Peris
 * This file is distributed under the same license as the Script Text Editor package.
 */

package it.lordstephen77.ste;

import it.lordstephen77.ste.WinAbout;

import java.io.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.plaf.FileChooserUI;

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

public class Main extends JFrame implements ActionListener {
	
	// variables
    private JTextArea ta;
    private int count;
    private JMenuBar menuBar;
    private JMenu fileM;
    private JMenu editM;
    private JMenu infoM;
    private JMenuItem newfileI, openfileI, savefileI, exitI, aboutI;
    private String pad;
    private JToolBar toolBar;

    RSyntaxTextArea textArea = new RSyntaxTextArea();
    
    JFrame frame = new JFrame("Input Dialog Box Frame");
    JButton button = new JButton("Show Input Dialog Box");
    JFileChooser fc = new JFileChooser();

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

        // MENUBAR
        count = 0;
        pad = " ";
        
    	ta = new JTextArea(); // textarea

    	// main menubar
    	menuBar = new JMenuBar(); // menubar
    	fileM = new JMenu("File"); // file menu
    	editM = new JMenu("Edit"); // edit menu
    	infoM = new JMenu("Info"); // info menu
    	
    	// file menu
    	newfileI = new JMenuItem("New");  // menu items on File Menu
    	openfileI = new JMenuItem("Open File");  // menu items on File Menu
    	savefileI = new JMenuItem("Save");  // menu items on File Menu
    	exitI = new JMenuItem("Exit");  // menu items on File Menu
    	
    	// info menu
    	aboutI = new JMenuItem("About"); // menu items on File Menu
    	toolBar = new JToolBar();
    	
    	ta.setLineWrap(true);
    	ta.setWrapStyleWord(true);

    	setJMenuBar(menuBar);
    	menuBar.add(fileM); // "File" on the menu item for File
    	fileM.add(newfileI); // "New" on the menu item for File
    	fileM.add(openfileI); // "Open File" on the menu item for File
    	fileM.add(savefileI); // "Save" on the menu item for File
    	fileM.add(exitI); // "Exit" on the menu item for File
    	
    	menuBar.add(editM); // "Edit" on the menu item for File
    	
    	
    	menuBar.add(infoM); // "Info" on the menu item for File
    	infoM.add(aboutI); // "About" on the menu bar

    	// shortcuts
    	newfileI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    	openfileI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
    	savefileI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

    	pane.add(toolBar,BorderLayout.NORTH);

    	newfileI.addActionListener(this);
    	openfileI.addActionListener(this);
    	savefileI.addActionListener(this);
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

    public void actionPerformed(ActionEvent e) {
    	
        JMenuItem choice = (JMenuItem) e.getSource();

        // save file
        if (choice == savefileI) {
        	
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
        
        // open file
        if (choice == openfileI) {
        
        int returnValue = fc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
			}
        }
        
        // quit program
    	else if (choice == exitI) {
    		
           System.exit(0);
    	}
        
     else if(choice == aboutI) {
    	 
    	 new WinAbout();
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
	
      
