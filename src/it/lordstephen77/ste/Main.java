/*
 * 
 * .----------------.  .----------------.  .----------------. 
 * | .--------------. || .--------------. || .--------------. |
 * | |    _______   | || |  _________   | || |  _________   | |
 * | |   /  ___  |  | || | |  _   _  |  | || | |_   ___  |  | |
 * | |  |  (__ \_|  | || | |_/ | | \_|  | || |   | |_  \_|  | |
 * | |   '.___`-.   | || |     | |      | || |   |  _|  _   | |
 * | |  |`\____) |  | || |    _| |_     | || |  _| |___/ |  | |
 * | |  |_______.'  | || |   |_____|    | || | |_________|  | |
 * | |              | || |              | || |              | |
 * | '--------------' || '--------------' || '--------------' |
 *  '----------------'  '----------------'  '----------------' 
 * 
 *            +-+-+-+-+-+-+ +-+-+-+-+ +-+-+-+-+ +-+
 *            |S|c|r|i|p|t| |T|e|x|t| |E|d|i|t|o|r|
 *            +-+-+-+-+-+-+ +-+-+-+-+ +-+-+-+-+ +-+
 * 
 * 
 * 
 * @name        LTE
 * @copyright   Stefano Peris (c) 2017
 * @author      Stefano Peris
 * @email       lordstephen77@gmail.com
 * @github      https://github.com/LordStephen77/LTE
 * @license     GPL-3.0 (https://www.gnu.org/licenses/gpl-3.0.en.html)
 * @create      dom 08 ott 2017 17:04:24 CEST
 * @update      lun 09 ott 2017 11:44:08 CEST
 * 
 */


package it.lordstephen77.ste;

import it.lordstephen77.ste.WinAbout;

import java.io.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;

import javax.swing.*;

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

public class Main extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -7305732243149994126L;
	
	// variables
    private JTextArea ta;
    private JMenuBar menuBar;
    private JMenu fileM;
    private JMenu editM;
    private JMenu infoM;
    private JMenuItem newfileI, openfileI, savefileI, exitI, aboutI;
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

    public void actionPerformed(ActionEvent e) {
    	
        JMenuItem choice = (JMenuItem) e.getSource();

        // new file
        if (choice == newfileI) {
        	
        	newfileI.addActionListener(this);  // Adding an action listener (so we know when it's been clicked).
        }
        
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
        
        /*
         * open file (bug?!?)
         */
        if (choice == openfileI) {
        
        int returnVal = fc.showOpenDialog(Main.this);

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
	
      
